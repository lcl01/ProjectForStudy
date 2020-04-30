package code;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class test {
    public static void main(String[] args) {
        WrapperCar wrapperCar = new WrapperCar(new Qq());
        wrapperCar.run();
        wrapperCar.stop();
    }
    @Test
    public void fun01() throws SQLException {
        Connection connection = null;
        PreparedStatement p1= null;
        PreparedStatement p2 = null;
        try {
             connection = DruidUtils.getConnection();
             connection.setAutoCommit(false);
            String sql = "update account set money =  money - ? where name = ?";
            p1 = connection.prepareStatement(sql);
            p1.setDouble(1,100.0);
            p1.setString(2,"zs");
            p1.executeUpdate();
//            int i = 1/0;//模拟出错
            String sql2 = "update account set money =  money + ? where name = ?";
            p2 = connection.prepareStatement(sql2);
            p2.setDouble(1,100.0);
            p2.setString(2,"ls");
            p2.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //3. 释放资源
            p1.close();
            p2.close();
            connection.close();
        }
    }
    @Test
    public void fun02(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
        String sql = "insert into user values (?,?,?,?)";
        Object[] params = {null,"ls","123456","李四"};
        jdbcTemplate.update(sql,params);
    }
    @Test
    public void fun03(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
        //2. 使用update,执行sql语句
//        String sql = "update user set username = ? where id = ?";
//        Object[] params = {"ww",4};
        jdbcTemplate.update("DELETE FROM  user WHERE  id = ?",4);
    }
    @Test
    public void fun04(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
        String sql = "select * from user where id = ?";
        Map<String, Object> map = jdbcTemplate.queryForMap(sql, 1);
        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string);
            System.out.println(map.get(string));
            System.out.println("---------------");
        }
    }
    @Test
    public void fun05(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
        String sql = "select * from user where id = ?";
        User user=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),1);
        System.out.println(user);
    }
    @Test
    public void fun06(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
        String sql = "select * from user";
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList(sql);
//        Set<String> strings = mapList.get(2).keySet();
//        for (String string : strings) {
//            System.out.println(string);
//        }
//        mapList.get(1).keySet()+mapList.get(1).get()
        for (Map<String, Object> ss : mapList) {
            for (String s : ss.keySet()) {
//                System.out.println(s);
                System.out.println(s+":"+ss.get(s));
            }
        }
    }
    @Test
    public void fun07(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
        String sql="select * from user";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        for (User user : users) {
            System.out.println(user);
        }
    }
    @Test
    public void fun08(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
        String sql="select COUNT(id)from user";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }
    }
