package com.itheima.bean;

import java.io.Serializable;
import java.util.List;

public class PageBean<Route> implements Serializable {
    private List<Route> list;
    private int curPage;
    private int sumPage;
    private int count;
    private int curSize;

    public PageBean() {
    }

    public PageBean(List <Route> list, int curPage, int sumPage, int count, int curSize) {
        this.list = list;
        this.curPage = curPage;
        this.sumPage = sumPage;
        this.count = count;
        this.curSize = curSize;
    }

    public List <Route> getList() {
        return list;
    }

    public void setList(List <Route> list) {
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

    @Override
    public String toString() {
        return "PageBean{" +
                "list=" + list +
                ", curPage=" + curPage +
                ", sumPage=" + sumPage +
                ", count=" + count +
                ", curSize=" + curSize +
                '}';
    }
}
