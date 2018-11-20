package com.zhiyou.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.sm.dao.UserMapper;
import com.zhiyou.sm.entity.User;
//创建service层的对象
@Service
public class UserServiceImpl implements UserService {
	//声明一个dao层的属性
	//利用注解自动注入
	@Autowired
	private UserMapper userDao;
	
	
	@Override
	public User getUserByNo(Long userNo) {
		// 把integer转换为Long
		return userDao.selectByPrimaryKey(userNo);
	}

	@Override
	public List<User> getAll() {
		// 返回所有用户
		return userDao.getAll();
	}

	@Override
	public boolean add(User user) {
		int count=userDao.insertSelective(user);
		//count返回的主键值
		System.out.println("count="+count);
		if(count>0)
			return true;
		return false;
	}

	@Override
	public boolean delete(Long id) {
		int count=userDao.deleteByPrimaryKey(id);
		if(count>0)
			return true;
		return false;
	}

	@Override
	public boolean update(User user) {
		int count=userDao.updateByPrimaryKeySelective(user);
		if(count>0)
			return true;
		return false;
	}

}
