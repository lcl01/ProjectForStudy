package com.itheima.dao;

import com.itheima.bean.Customer;
import com.itheima.utils.C3P0Utils;
import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerDao {
    public void save(Customer customer) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(C3P0Utils.getDataSource());
        String sql="insert into cst_customer value(null,?,?,?,?,?,?)";
        Object[] arges={customer.getCustName(),
                customer.getCustSource(),customer.getCustIndustry(),customer.getCustLevel(),
                customer.getCustPhone(),customer.getCustMobile()};
        jdbcTemplate.update(sql,arges);
    }
}
