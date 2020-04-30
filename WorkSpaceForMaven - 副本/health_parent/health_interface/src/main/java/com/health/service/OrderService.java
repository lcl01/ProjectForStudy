package com.health.service;

import com.health.pojo.Result;

import java.util.Map;

public interface OrderService {
   public Result order(Map map) throws Exception;

   Result findById4Detail(Integer id) throws Exception;

}
