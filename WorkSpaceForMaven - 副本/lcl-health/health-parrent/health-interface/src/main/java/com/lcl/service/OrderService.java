package com.lcl.service;

import com.lcl.entity.Result;

import java.util.Map;

public interface OrderService {
    public Result order(Map map) throws Exception;

    public Result findById4Detail(Integer id) throws Exception;

}
