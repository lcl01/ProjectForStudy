package com.itheima.service;

import com.itheima.bean.User;
import com.itheima.dao.UserDao;
import com.itheima.utils.MailUtil;
import com.itheima.utils.Md5Util;
import com.itheima.utils.UUIDUtil;

public class UserService {
    private UserDao userDao = new UserDao();
    public void regist(User user) throws Exception {
        user.setStatus("N");
        user.setCode(UUIDUtil.getUuid());
        user.setPassword(Md5Util.encodeByMd5(user.getPassword()));
        userDao.save(user);
        MailUtil.sendMail(user.getEmail(),"尊敬的:"+user.getName()+"欢迎注册黑马旅游网!请点击如下超链接进行激活!<a href='http://localhost:8080/travel/user?method=active&code="+user.getCode()+"'>点击激活</a>");
    }

    public Boolean active(String code) {
        int row= userDao.active(code);
        return row>0;

    }

    public User login(String username, String password) throws Exception {
         password= Md5Util.encodeByMd5(password);
         System.out.println(password);
        return userDao.login(username,password);
    }
}
