package com.itheima.bean;

import com.changgou.bean.User01;

import java.util.List;

public class PageBean {
    private List<com.changgou.bean.User01> list;
    private int curPage;
    private int sumPage;
    private int count;
    private int curSize;

    public PageBean(List<com.changgou.bean.User01> list, int curPage, int sumPage, int count, int curSize) {
        this.list = list;
        this.curPage = curPage;
        this.sumPage = sumPage;
        this.count = count;
        this.curSize = curSize;
    }

    public List<com.changgou.bean.User01> getList() {
        return list;
    }

    public void setList(List<User01> list) {
        this.list = list;
    }

    public int getCurPage() {
        return curPage;
    }

    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }

    public int getSumPage() {
        return sumPage;
    }

    public void setSumPage(int sumPage) {
        this.sumPage = sumPage;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCurSize() {
        return curSize;
    }

    public void setCurSize(int curSize) {
        this.curSize = curSize;
    }
}
