package com.itheima.service.impl;

import com.itheima.bean.Customer;
import com.itheima.dao.CustomerDao;

public class CustomerService {
    public void addCustomer(Customer customer) throws Exception{
        CustomerDao customerDao = new CustomerDao();
        customerDao.save(customer);
    }
}
