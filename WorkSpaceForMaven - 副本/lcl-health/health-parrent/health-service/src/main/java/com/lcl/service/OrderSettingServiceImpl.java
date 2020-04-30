package com.lcl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcl.dao.OrderSettingDao;
import com.lcl.pojo.OrderSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(interfaceClass = OrderSettingService.class)
@Transactional
public class OrderSettingServiceImpl implements OrderSettingService{
    @Autowired
    private OrderSettingDao orderSettingDao;
    @Override
    public void add(List<OrderSetting> list) {
        if(list != null && list.size() > 0){
            for (OrderSetting orderSetting : list) {
                //检查此数据（日期）是否存在
                long count = orderSettingDao.findCountByOrderDate(orderSetting.getOrderDate());
                if(count > 0){
                    //已经存在，执行更新操作
                    orderSettingDao.editNumberByOrderDate(orderSetting);
                }else{
                    //不存在，执行添加操作
                    orderSettingDao.add(orderSetting);
                }
            }
        }
    }

    @Override
    public List <Map> getOrderSettingByMonth(String date) {
        String dateBegin=date+"-1";
        String dateEnd=date+"-31";
        Map map = new HashMap();
        map.put("dateBegin",dateBegin);
        map.put("dateEnd",dateEnd);
        List<OrderSetting> list=orderSettingDao.getOrderSettingByMonth(map);
        List <Map> data = new ArrayList <>();
        for (OrderSetting orderSetting : list) {
            Map orderSettingMap = new HashMap <>();
            orderSettingMap.put("date",orderSetting.getOrderDate().getDate());
            orderSettingMap.put("number",orderSetting.getNumber());
            orderSettingMap.put("reservations",orderSetting.getReservations());
            data.add(orderSettingMap);
        }
        return data;
    }

    @Override
    public void editNumberByDate(OrderSetting orderSetting) {
        long count = orderSettingDao.findCountByOrderDate(orderSetting.getOrderDate());
        if (count>0) {
            orderSettingDao.editNumberByOrderDate(orderSetting);
        }else {
            orderSettingDao.add(orderSetting);
        }
    }
}
