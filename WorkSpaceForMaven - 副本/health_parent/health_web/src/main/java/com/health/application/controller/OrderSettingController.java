package com.health.application.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.health.constant.MessageConstant;
import com.health.service.OrderSettingService;
import com.health.utils.POIUtils;
import com.health.pojo.OrderSetting;
import com.health.pojo.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ordersetting")
public class OrderSettingController {
    @Reference
    private OrderSettingService orderSettingService;

    @RequestMapping("/upload")
    public Result upload(@RequestParam("excelFile") MultipartFile excelFile) throws IOException {
        //读取Excel文件数据
        try {
            List<String[]> list = POIUtils.readExcel(excelFile);
            if (list !=null && list.size()>0) {
                List<OrderSetting> orderSettinglist=new ArrayList<>();
                for (String[] strings : list) {
                    OrderSetting orderSetting = new OrderSetting(
                            new Date(strings[0]),
                            Integer.parseInt(strings[1])
                    );
                    orderSettinglist.add(orderSetting);
                }
                orderSettingService.add(orderSettinglist);
            }
            return new Result(true, MessageConstant.IMPORT_ORDERSETTING_SUCCESS);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.IMPORT_ORDERSETTING_FAIL);
        }
    }
    @RequestMapping("/getOrderSettingByMonth")
    public Result getOrderSettingByMonth(String date){
        try {
            List<Map> list=orderSettingService.getOrderSettingByMonth(date);
            System.out.println(list+"list");
            //获取预约设置数据成功
            return new Result(true,MessageConstant.GET_ORDERSETTING_SUCCESS,list);
        } catch (Exception e) {
            e.printStackTrace();
            //获取预约设置数据失败
            return new Result(false,MessageConstant.GET_ORDERSETTING_FAIL);
        }

    }
    /**
     * 根据指定日期修改可预约人数
     * @param orderSetting
     * @return
     */
    @RequestMapping("/editNumberByDate")
    public Result editNumberByDate(@RequestBody OrderSetting orderSetting){
        try {
            orderSettingService.editNumberByDate(orderSetting);
            //预约设置成功
            return new Result(true,MessageConstant.ORDERSETTING_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            //预约设置失败
            return new Result(false,MessageConstant.ORDERSETTING_FAIL);
        }
    }
}
