package com.changgou.bean;

import java.io.Serializable;

public class Route01 implements Serializable {
    private int rid;//线路id
    private String rname;//线路名称
    private double price;//价格
    private String routeIntroduce;//线路介绍
    private String rflag; //是否上架，0代表没有上架，1代表是上架
    private String rdate; //上架时间
    private String isThemeTour;//是否主题旅游，0代表不是，1代表是
    private String sourceId;//数据的来源id
    private int cid;//所属分类
    private int sid;//所属商家
    private int count;//收藏数量
    private String rimage;//缩略图

    public Route01() {
    }

    public Route01(int rid, String rname, double price, String routeIntroduce, String rflag, String rdate, String isThemeTour, String sourceId, int cid, int sid, int count, String rimage) {
        this.rid = rid;
        this.rname = rname;
        this.price = price;
        this.routeIntroduce = routeIntroduce;
        this.rflag = rflag;
        this.rdate = rdate;
        this.isThemeTour = isThemeTour;
        this.sourceId = sourceId;
        this.cid = cid;
        this.sid = sid;
        this.count = count;
        this.rimage = rimage;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRouteIntroduce() {
        return routeIntroduce;
    }

    public void setRouteIntroduce(String routeIntroduce) {
        this.routeIntroduce = routeIntroduce;
    }

    public String getRflag() {
        return rflag;
    }

    public void setRflag(String rflag) {
        this.rflag = rflag;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public String getIsThemeTour() {
        return isThemeTour;
    }

    public void setIsThemeTour(String isThemeTour) {
        this.isThemeTour = isThemeTour;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage;
    }

    @Override
    public String toString() {
        return "Route01{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", price=" + price +
                ", routeIntroduce='" + routeIntroduce + '\'' +
                ", rflag='" + rflag + '\'' +
                ", rdate='" + rdate + '\'' +
                ", isThemeTour='" + isThemeTour + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", cid=" + cid +
                ", sid=" + sid +
                ", count=" + count +
                ", rimage='" + rimage + '\'' +
                '}';
    }
}
