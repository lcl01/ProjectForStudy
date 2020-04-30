package com.itheima.utils;

public class TransactionManager {
    private ConnectionUtils connectionUtils;
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }
    public  void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void commit(){
        try {
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void rollback(){
        try {
            connectionUtils.getThreadConnection().rollback();
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
