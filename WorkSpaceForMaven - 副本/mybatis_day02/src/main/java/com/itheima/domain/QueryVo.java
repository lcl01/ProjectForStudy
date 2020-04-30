package com.itheima.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName QueryVo
 * @Description TODO
 * @Author ly
 * @Company 深圳黑马程序员
 * @Date 2019/5/23 11:24
 * @Version V1.0
 */
public class QueryVo {

    private User user;
    private List<Integer> ids=new ArrayList <Integer>();

    public List <Integer> getIds() {
        return ids;
    }

    public void setIds(List <Integer> ids) {
        this.ids = ids;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
