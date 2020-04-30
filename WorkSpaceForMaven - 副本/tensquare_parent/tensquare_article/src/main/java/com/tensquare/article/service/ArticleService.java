package com.tensquare.article.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.client.NoticeClient;
import com.tensquare.article.config.RabbitmqConfig;
import com.tensquare.article.dao.ArticleDao;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.pojo.Notice;
import com.tensquare.util.IdWorker;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("ALL")
@Transactional
@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private NoticeClient noticeClient;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange exchange;

    @Autowired
    private RabbitAdmin rabbitAdmin;
    /**
     * 查询所有
     *
     * @return
     */
    public List<Article> findAll() {
        return articleDao.selectList(null);
    }

    public Article findById(String articleId) {
        return articleDao.selectById(articleId);
    }

    public void add(Article article) {
        //1.新增文章
        String authorId = "1";
        article.setId(idWorker.nextId() + "");
        article.setVisits(0);   //浏览量
        article.setThumbup(0);  //点赞数
        article.setComment(0);  //评论数
        article.setUserid(authorId);
//2.通知
        Set<String> members = redisTemplate.opsForSet().members("article_author_" + authorId);
        for (String uid : members) {
            //消息通知
            Notice notice = new Notice();
            notice.setReceiverId(uid);
            notice.setOperatorId(authorId);
            notice.setAction("publish");
            notice.setTargetType("article");
            notice.setTargetId(article.getId());
            notice.setCreatetime(new Date());
            notice.setType("sys");
            notice.setState("0");
            noticeClient.add(notice);
        }
        articleDao.insert(article);
        //入库成功后，发送mq消息，内容是消息通知id
        rabbitTemplate.convertAndSend(RabbitmqConfig.EX_ARTICLE,authorId,article.getId());
    }

    public void update(Article article) {
        //方式一
        articleDao.updateById(article);
        //方式二
        //EntityWrapper<Article> wrapper = new EntityWrapper<>();
        //wrapper.eq("id",article.getId());
        //articleDao.update(article, wrapper);
    }
    public void delete(String id) {
        articleDao.deleteById(id);
    }
    /**
     * 分页查询
     * @param map
     * @param page
     * @param size
     * @return
     */
    public Page<Article> search(Map map, int page, int size) {
        //1.封装分页对象
        Page<Article> pageList = new Page<>(page, size);
        //2.封装条件对象
        EntityWrapper<Article> entityWrapper = new EntityWrapper<>();
        if(!StringUtils.isEmpty(map.get("columnid"))){
            entityWrapper.eq("columnid",map.get("columnid"));
        }
        if(!StringUtils.isEmpty(map.get("userid"))){
            entityWrapper.eq("userid",map.get("userid"));
        }
        if(!StringUtils.isEmpty(map.get("title"))){
            // 不用补%, 下同
            entityWrapper.like("title", (String) map.get("title"));
        }
        if(!StringUtils.isEmpty(map.get("content"))){
            entityWrapper.like("content","%"+map.get("content")+"%");
        }

        //3.调用Dao
        List<Article> list = articleDao.selectPage(pageList, entityWrapper);
        pageList.setRecords(list);
        return pageList;
    }
    /**
     * 订阅
     * @param userId
     * @param articleId
     * @return
     */
    public boolean subscribe(String userId, String articleId) {
        //1.根据文章Id获得文章作者Id
        String authorId =  articleDao.selectById(articleId).getUserid();
        //2.存到Redis
        //当前用户关注的作者set
        String userKey = "article_subscribe_"+userId;
        //该作者被关注的用户set
        String authorKey = "article_author_"+authorId;
        Boolean isMember = redisTemplate.opsForSet().isMember(userKey, authorId);
        //创建queue
        Queue queue = new Queue("article_subscribe_" + userId, true);
        //声明exchange和queue的绑定关系，设置路由键为作者id
        Binding binding = BindingBuilder.bind(queue).to(exchange).with(authorId);
        //3.判断是否已经订阅
        if(isMember){
            redisTemplate.opsForSet().remove(userKey,authorId);
            redisTemplate.opsForSet().remove(authorKey,userId);
            //进行解绑
            rabbitAdmin.removeBinding(binding);
            return false;
        }else{
            redisTemplate.opsForSet().add(userKey,authorId);
            redisTemplate.opsForSet().add(authorKey,userId);
            rabbitAdmin.declareQueue(queue);
            rabbitAdmin.declareBinding(binding);

            return true;
        }
    }

    public void thumbup(String articleId,String userId) {
        Article article = articleDao.selectById(articleId);
        article.setThumbup(article.getThumbup()+1);
        articleDao.updateById(article);
        //消息通知
        Notice notice = new Notice();
        notice.setReceiverId(article.getUserid());
        notice.setOperatorId(userId);
        notice.setAction("thumbup");
        notice.setTargetType("article");
        notice.setTargetId(articleId);
        notice.setCreatetime(new Date());
        notice.setType("user");
        notice.setState("0");

        noticeClient.add(notice);
    }

    public void thumbup(String articleId) {
        Article article = articleDao.selectById(articleId);
        article.setThumbup(article.getThumbup()+1);
        articleDao.updateById(article);
    }
}
