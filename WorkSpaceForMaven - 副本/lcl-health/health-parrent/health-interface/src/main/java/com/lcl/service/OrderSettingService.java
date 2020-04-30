package com.lcl.service;

import com.lcl.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

public interface OrderSettingService {

    public void add(List<OrderSetting> List);
    public List<Map> getOrderSettingByMonth(String date);
    public void editNumberByDate(OrderSetting orderSetting);
}

