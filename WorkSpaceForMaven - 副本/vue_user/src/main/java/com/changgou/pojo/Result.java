package com.changgou.pojo;

/**
 * 包名:com.itheima.springboot.domain
 * 作者:Leevi
 * 日期2019-09-17  17:23
 */
public class Result {
    private boolean flag;
    private Object data;
    private String message;

    public Result() {
    }

    public Result(boolean flag, Object data, String message) {
        this.flag = flag;
        this.data = data;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "flag=" + flag +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
