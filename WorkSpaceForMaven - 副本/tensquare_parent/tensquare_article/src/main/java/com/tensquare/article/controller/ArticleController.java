package com.tensquare.article.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import com.tensquare.entity.PageResult;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private RedisTemplate redisTemplate;
    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        List<Article> list = articleService.findAll();
        return new Result(true, StatusCode.OK, "文章查询成功", list);
    }
    @RequestMapping(value = "/{articleId}",method = RequestMethod.GET)
    public Result findById(@PathVariable("articleId") String articleId) {
        Article article = articleService.findById(articleId);
        return new Result(true, StatusCode.OK, "文章查询成功", article);
    }
    //新增文章
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Article article) {
        articleService.add(article);
        return new Result(true, StatusCode.OK, "添加成功");
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable String id, @RequestBody Article article) {
        article.setId(id);
        articleService.update(article);
        return new Result(true, StatusCode.OK, "修改成功");
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        articleService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }
    /**
     * 文章分页
     * @param map
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.POST)
    public Result search(@RequestBody Map map, @PathVariable(value = "page") int page, @PathVariable(value = "size")int size) {
        Page<Article> pageList = articleService.search(map,page,size);
        PageResult pageResult = new PageResult(pageList.getTotal(),pageList.getRecords());
        return new Result(true, StatusCode.OK, "分页查询成功",pageResult);
    }
    /**
     * 订阅
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/subscribe/{articleId}", method = RequestMethod.POST)
    public Result subscribe(@PathVariable("articleId") String articleId) {
        String userId = "2";
        boolean flag = articleService.subscribe(userId, articleId);
        if(flag){
            return new Result(true, StatusCode.OK, "订阅成功");
        }else{
            return new Result(true, StatusCode.OK, "取消订阅");
        }
    }
    /**
     * 文章点赞
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/thumbup/{articleId}", method = RequestMethod.PUT)
    public Result thumbup(@PathVariable(value = "articleId") String articleId){
        //模拟当前用户
        String userId = "4";

        //控制重复点赞
        Object value = redisTemplate.opsForValue().get("article_" + userId + "_" + articleId);
        if(value != null){
            return new Result(false, StatusCode.REPERROR, "不能重复点赞");
        }

        articleService.thumbup(articleId);
        redisTemplate.opsForValue().set("article_" + userId + "_" + articleId,"OK");
        return new Result(true, StatusCode.OK, "点赞成功");
    }
}
