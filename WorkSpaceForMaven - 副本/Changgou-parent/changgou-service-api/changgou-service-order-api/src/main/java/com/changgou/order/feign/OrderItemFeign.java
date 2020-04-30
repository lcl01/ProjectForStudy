package com.changgou.order.feign;

import com.changgou.entity.Result;
import com.changgou.order.pojo.OrderItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:sz.itheima
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="order")
@RequestMapping("/orderItem")
public interface OrderItemFeign {

//    /***
//     * OrderItem分页条件搜索实现
//     * @param orderItem
//     * @param page
//     * @param size
//     * @return
//     */
//    @PostMapping(value = "/search/{page}/{size}" )
//    Result<PageInfo> findPage(@RequestBody(required = false) OrderItem orderItem, @PathVariable (value = "id") int page, @PathVariable (value = "id") int size);
//
//    /***
//     * OrderItem分页搜索实现
//     * @param page:当前页
//     * @param size:每页显示多少条
//     * @return
//     */
//    @GetMapping(value = "/search/{page}/{size}" )
//    Result<PageInfo> findPage(@PathVariable (value = "id") int page, @PathVariable (value = "id") int size);

    /***
     * 多条件搜索品牌数据
     * @param orderItem
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<OrderItem>> findList(@RequestBody(required = false) OrderItem orderItem);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable (value = "id") String id);

    /***
     * 修改OrderItem数据
     * @param orderItem
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody OrderItem orderItem, @PathVariable (value = "id") String id);

    /***
     * 新增OrderItem数据
     * @param orderItem
     * @return
     */
    @PostMapping
    Result add(@RequestBody OrderItem orderItem);

    /***
     * 根据ID查询OrderItem数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<OrderItem> findById(@PathVariable (value = "id") String id);

    /***
     * 查询OrderItem全部数据
     * @return
     */
    @GetMapping
    Result<List<OrderItem>> findAll();
}