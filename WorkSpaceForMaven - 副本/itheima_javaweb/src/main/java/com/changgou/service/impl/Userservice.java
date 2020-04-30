package com.itheima.service.impl;

import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import com.itheima.utils.MailUtil;
import com.itheima.utils.Md5Util;
import com.itheima.utils.UUIDUtil;

public class Userservice {
    private UserDao userDao = new UserDao();
    public void regist(User user) throws Exception{
        user.setStatus("N");
        user.setCode(UUIDUtil.getUuid());
        user.setPassword(Md5Util.encodeByMd5(user.getPassword()));
        MailUtil.sendMail(user.getEmail(),"尊敬的:"+user.getName()+"欢迎注册黑马旅游网!请点击如下超链接进行激活!<a href='http://localhost:8080/userServlet?method=active&code="+user.getCode()+"'>点击激活</a>");
        userDao.save(user);

    }

    public boolean active(String code) throws Exception {
        int rows =  userDao.active(code);
        return rows>0;
    }

    public User login(String username, String password) throws Exception {
        password = Md5Util.encodeByMd5(password);

        return userDao.login(username,password);
    }
}
