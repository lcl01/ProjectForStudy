package com.itheima.proxy.impl;

import com.itheima.proxy.Producer;

public class ProducerImpl implements Producer {
    public void saleProduct(float money) {
        System.out.println("销售产品，并拿到钱："+money);
    }

    public void afterService(float money) {
        System.out.println("提供售后服务，并拿到钱："+money);
    }
}
