package com.health.beans;

import java.util.ArrayList;
import java.util.List;

public class QueryVo {
    private User02 user02;
    private List<Integer> ids=new ArrayList<Integer>();
    public QueryVo() {
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }

    public User02 getUser02() {
        return user02;
    }

    public void setUser02(User02 user02) {
        this.user02 = user02;
    }

    public QueryVo(User02 user02) {
        this.user02 = user02;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "user02=" + user02 +
                '}';
    }
}
