package com.lcl.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.lcl.constant.MessageConstant;
import com.lcl.dao.MemberDao;
import com.lcl.dao.OrderDao;
import com.lcl.dao.OrderSettingDao;
import com.lcl.entity.Result;
import com.lcl.pojo.Member;
import com.lcl.pojo.Order;
import com.lcl.pojo.OrderSetting;
import com.lcl.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Service(interfaceClass = OrderService.class)
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderSettingDao orderSettingDao;
    @Autowired
    private MemberDao memberDao;

    @Override
    public Result order(Map map) throws Exception {
        String orderDate = (String) map.get("orderDate");
        Date date = DateUtils.parseString2Date(orderDate);
        OrderSetting orderSetting = orderSettingDao.findByOrderDate(date);
        if (orderSetting == null) {
            return new Result(false, MessageConstant.SELECTED_DATE_CANNOT_ORDER);
        }
        int number = orderSetting.getNumber();
        int reservations = orderSetting.getReservations();
        if (reservations >= number) {
            return new Result(false, MessageConstant.ORDER_FULL);
        }
        String telephone = (String) map.get("telephone");
        Member member = memberDao.findByTelephone(telephone);
        if (member != null) {
            Integer memberId = member.getId();
            int setmealId = Integer.parseInt((String) map.get("setmealId"));
            Order order = new Order(memberId, date, null, null, setmealId);
            List <Order> list = orderDao.findByCondition(order);
            if (list != null && list.size() > 0) {
                return new Result(false, MessageConstant.HAS_ORDERED);
            }
        } else {
            member = new Member();
            member.setName((String) map.get("name"));
            member.setPhoneNumber(telephone);
            member.setIdCard((String) map.get("idCard"));
            member.setSex((String) map.get("sex"));
            member.setRegTime(new Date());
            memberDao.add(member);
        }

        orderSetting.setReservations(orderSetting.getReservations() + 1);
        orderSettingDao.editReservationsByOrderDate(orderSetting);
        Order order = new Order(member.getId(),
                date,
                (String) map.get("orderType"),
                Order.ORDERSTATUS_NO, Integer.parseInt((String) map.get("setmealId")));
        orderDao.add(order);

        return new Result(true,MessageConstant.ORDER_SUCCESS,order);
    }

    @Override
    public Result findById4Detail(Integer id) throws Exception {
        Map map=orderDao.findById4Detail(id);
        if(map !=null){
            Date orderDate = (Date)map.get("orderDate");
            map.put("orderDate",DateUtils.parseDate2String(orderDate));
            return new Result(true,MessageConstant.QUERY_ORDER_SUCCESS,map);
        }
        return new Result(false,MessageConstant.QUERY_ORDER_FAIL);
    }

}