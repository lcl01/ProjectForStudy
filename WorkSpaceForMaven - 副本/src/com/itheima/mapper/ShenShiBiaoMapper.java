package com.itheima.mapper;

import com.itheima.bean.ShenShiBiao;
import com.itheima.bean.ShenShiBiaoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShenShiBiaoMapper {
    int countByExample(ShenShiBiaoExample example);

    int deleteByExample(ShenShiBiaoExample example);

    int insert(ShenShiBiao record);

    int insertSelective(ShenShiBiao record);

    List<ShenShiBiao> selectByExample(ShenShiBiaoExample example);

    int updateByExampleSelective(@Param("record") ShenShiBiao record, @Param("example") ShenShiBiaoExample example);

    int updateByExample(@Param("record") ShenShiBiao record, @Param("example") ShenShiBiaoExample example);
}