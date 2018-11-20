package com.zhiyou.sm.service;

import java.util.List;

import com.zhiyou.sm.entity.User;

public interface UserService {
	//获得所有
	List<User> getAll();
	
	//添加操作
	boolean add(User user);
	
	//刪除的方法
	boolean delete(Long id);
	
	//更新操作
	boolean update(User user);
	
	//取一个用户对象
	public User getUserByNo(Long userNo);
	
}
