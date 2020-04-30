package com.health.dao;

import com.health.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface OrderSettingDao {

    public long findCountByOrderDate(Date orderDate);
    public void editNumberByOrderDate(OrderSetting orderSetting);

    public void add(OrderSetting orderSetting);

    public List<OrderSetting> getOrderSettingByMonth(Map<Object, Object> map);

    OrderSetting findByOrderDate(Date date);

    void editReservationsByOrderDate(OrderSetting orderSetting);

}
