package com.lcl.dao;

import com.lcl.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository <User,Integer>{

}
