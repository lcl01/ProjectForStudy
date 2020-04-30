package com.tensquare.notice.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.entity.Result;
import com.tensquare.notice.dao.NoticeDao;
import com.tensquare.notice.dao.NoticeFreshDao;
import com.tensquare.notice.feign.ArticleClient;
import com.tensquare.notice.feign.UserClient;
import com.tensquare.notice.pojo.Notice;
import com.tensquare.notice.pojo.NoticeFresh;
import com.tensquare.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("ALL")
@Service
public class NoticeService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private NoticeDao noticeDao;
    @Autowired
    private NoticeFreshDao noticeFreshDao;
    @Autowired
    private UserClient userClient;
    @Autowired
    private ArticleClient articleClient;

    public Notice findById(String id) {

        return noticeDao.selectById(id);
    }


        public void add (Notice notice){
            //1.设置初始值
            notice.setState("0");
            notice.setCreatetime(new Date());
            String id = idWorker.nextId() + "";
            notice.setId(id);
            noticeDao.insert(notice);

            //2.待推送消息入库，新消息提醒
            NoticeFresh noticeFresh = new NoticeFresh();
            noticeFresh.setNoticeId(id);//消息id
            noticeFresh.setUserId(notice.getReceiverId());//待通知用户的id
            noticeFreshDao.insert(noticeFresh);
        }

    public Page<Object> findPage(int page, int size) {
        Page<Object> pageList = new Page<>(page, size);
        List<Notice> list = noticeDao.selectPage(pageList, new EntityWrapper<Notice>());
        pageList.setRecords(Collections.singletonList(list));
        return pageList;
    }

    public void update(Notice notice) {
        noticeDao.updateById(notice);
    }

    public Page<NoticeFresh> freshPage(String userId, int page, int size) {
        Page<NoticeFresh> pageList = new Page<>(page, size);
        EntityWrapper<NoticeFresh> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("userId",userId);
        List<NoticeFresh> list = noticeFreshDao.selectPage(pageList, entityWrapper);
        pageList.setRecords(list);
        return pageList;
    }
    private void getNoticeInfo(Notice notice) {
        Result userResult = userClient.findById(notice.getOperatorId());
        HashMap userMap = (HashMap) userResult.getData();
        notice.setOperatorName(userMap.get("nickname").toString());
        //获取文章信息
        if ("article".equals(notice.getTargetType())) {
            Result articleResult = articleClient.findById(notice.getTargetId());
            HashMap articleMap = (HashMap) articleResult.getData();
            notice.setTargetName(articleMap.get("title").toString());
        }
    }
    @Transactional
    public void save(Notice notice) {
        //初始化数据
        notice.setCreatetime(new Date());
        notice.setState("0");

        //通知消息入库
        notice.setId(idWorker.nextId() + "");
        noticeDao.insert(notice);

        //新的通知提醒消息入库
        //NoticeFresh noticeFresh = new NoticeFresh();
        //noticeFresh.setNoticeId(notice.getId());
        //noticeFresh.setUserId(notice.getReceiverId());
        //noticeFreshDao.insert(noticeFresh);

    }
}