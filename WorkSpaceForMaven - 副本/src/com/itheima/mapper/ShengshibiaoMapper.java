package com.itheima.mapper;

import com.itheima.bean.Shengshibiao;
import com.itheima.bean.ShengshibiaoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShengshibiaoMapper {
    int countByExample(ShengshibiaoExample example);

    int deleteByExample(ShengshibiaoExample example);

    int insert(Shengshibiao record);

    int insertSelective(Shengshibiao record);

    List<Shengshibiao> selectByExample(ShengshibiaoExample example);

    int updateByExampleSelective(@Param("record") Shengshibiao record, @Param("example") ShengshibiaoExample example);

    int updateByExample(@Param("record") Shengshibiao record, @Param("example") ShengshibiaoExample example);
}