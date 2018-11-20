package com.zhiyou.sm.dao;

import java.util.List;

import com.zhiyou.sm.entity.User;

public interface UserMapper {
	//获得所有的用户信息
	List<User> getAll();
	
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}