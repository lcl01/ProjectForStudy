package com.lcl.mapper;

import com.lcl.domain.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
@Mapper
public interface UserMapper {
    List<User> findAll();
}
