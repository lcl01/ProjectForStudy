package com.health.service;

import com.health.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

public interface OrderSettingService {


    void add(List<OrderSetting> orderSettinglist);


    List<Map> getOrderSettingByMonth(String date);

    void editNumberByDate(OrderSetting orderSetting);
}
