package com.lcl.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lcl.constant.MessageConstant;
import com.lcl.entity.Result;
import com.lcl.pojo.OrderSetting;
import com.lcl.service.OrderSettingService;
import com.lcl.utils.POIUtils;
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
    public Result upload(@RequestParam("excelFile")MultipartFile excelFile){
        try {
            List <String[]> list = POIUtils.readExcel(excelFile);
            if (list !=null && list.size()>0) {
                List <OrderSetting> orderSettingList = new ArrayList <>();
                for (String[] strings : list) {
                    OrderSetting orderSetting = new OrderSetting(new Date(strings[0]),Integer.parseInt(strings[1]));
                    orderSettingList.add(orderSetting);
                }
                orderSettingService.add(orderSettingList);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, MessageConstant.IMPORT_ORDERSETTING_FAIL);

        }
        return new Result(true,MessageConstant.IMPORT_ORDERSETTING_SUCCESS);
    }
    @RequestMapping("/getOrderSettingByMonth")
    public Result getOrderSettingByMonth(String date){
        try {
            System.out.println(date);
            List<Map> list=orderSettingService.getOrderSettingByMonth(date);
            return new Result(true,MessageConstant.GET_ORDERSETTING_SUCCESS,list);
        } catch (Exception e) {
            e.printStackTrace();
            return  new Result(false,MessageConstant.GET_ORDERSETTING_FAIL);
        }
    }
    @RequestMapping("/editNumberByDate")
    public Result editNumberByDate(@RequestBody OrderSetting orderSetting){
        try {
            orderSettingService.editNumberByDate(orderSetting);
            return new Result(false,MessageConstant.ORDERSETTING_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,MessageConstant.ORDERSETTING_FAIL);
        }

    }

}
