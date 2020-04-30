package com.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.health.constant.MessageConstant;
import com.health.dao.MemberDao;
import com.health.dao.OrderDao;
import com.health.dao.OrderSettingDao;
import com.health.pojo.Member;
import com.health.pojo.Order;
import com.health.pojo.OrderSetting;
import com.health.pojo.Result;
import com.health.service.OrderService;
import com.health.utils.DateUtils;
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
        //2.判断当前日期是否预约满了
        int number = orderSetting.getNumber();//可预约人数
        int reservations = orderSetting.getReservations();//已预约人数
        if (reservations >= number) {
            return new Result(false, MessageConstant.ORDER_FULL);
        }
        //3.判断当前用户是否是会员
        String telephone = (String) map.get("telephone");
        Member member = memberDao.findByTelephone(telephone);
        if (member != null) {
            //3.1.是会员, 避免重复预约
            Integer memberId = member.getId();
            int setmealId = Integer.parseInt((String) map.get("setmealId"));
            Order order = new Order(memberId, date, null, null, setmealId);
            List<Order> list = orderDao.findByCondition(order);
            if (list != null && list.size() > 0) {
                return new Result(false, MessageConstant.HAS_ORDERED);
            }
            } else {
                //3.2.不是会员, 需要添加到会员表
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
            Order order1 = new Order(member.getId(), date,
                    (String) map.get("orderType"),
                    Order.ORDERSTATUS_NO,
                    Integer.parseInt((String) map.get("setmealId")));
            orderDao.add(order1);

            return new Result(true, MessageConstant.ORDER_SUCCESS, order1);
        }

    @Override
    public Result findById4Detail(Integer id) throws Exception {
        Map map = orderDao.findById4Detail(id);
        if (map !=null) {
            //处理日期格式
            Date orderDate = (Date) map.get("orderDate");
            map.put("orderDate",DateUtils.parseDate2String(orderDate));
            return new Result(true,MessageConstant.QUERY_ORDER_SUCCESS,map);
        }
        return new Result(false,MessageConstant.QUERY_ORDER_FAIL);
    }
}