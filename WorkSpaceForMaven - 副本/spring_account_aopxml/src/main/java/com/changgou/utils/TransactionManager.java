package com.changgou.utils;

public class TransactionManager {
    private ConnectionUtils connectionUtils;
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }
    public  void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
            System.out.println("开启事务");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
            System.out.println("提交事务");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
            System.out.println("回滚事务");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void release(){
        try {
            connectionUtils.getThreadConnection().close();//把连接还回连接池中
            connectionUtils.removeConnection();//线程和连接解绑
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
