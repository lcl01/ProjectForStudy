package com.tensquare.notice.contrller;

import com.baomidou.mybatisplus.plugins.Page;
import com.tensquare.entity.PageResult;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import com.tensquare.notice.pojo.Notice;
import com.tensquare.notice.pojo.NoticeFresh;
import com.tensquare.notice.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/notice")
@CrossOrigin
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Result findById(@PathVariable(value = "id") String id) {
        Notice notice =  noticeService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功",notice);
    }
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Notice notice) {
        noticeService.add(notice);
        return new Result(true, StatusCode.OK, "新增成功");
    }
    @RequestMapping(value = "/findPage/{page}/{size}",method = RequestMethod.GET)
    public Result findPage(@PathVariable int page, @PathVariable int size) {
        Page<Object> pageList =  noticeService.findPage(page,size);
        PageResult<Object> pageResult = new PageResult<Object>(pageList.getTotal(), pageList.getRecords());

    return new Result(true, StatusCode.OK, "查询成功",pageResult);
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public Result update(@PathVariable String id,@RequestBody Notice notice) {
        notice.setId(id);
        noticeService.update(notice);
        return new Result(true, StatusCode.OK, "修改成功");
    }
    @RequestMapping(value = "/freshPage/{userId}/{page}/{size}",method = RequestMethod.GET)
    public Result freshPage(@PathVariable String userId,@PathVariable int page ,@PathVariable int size) {
        Page<NoticeFresh> pageList =  noticeService.freshPage(userId,page,size);
        PageResult<NoticeFresh> pageResult =   new PageResult<NoticeFresh>(pageList.getTotal(),pageList.getRecords());
        return new Result(true, StatusCode.OK, "查询成功",pageResult);
    }

}
