package com.zhiyou.sm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou.sm.dao.UserMapper;
import com.zhiyou.sm.entity.User;
//����service��Ķ���
@Service
public class UserServiceImpl implements UserService {
	//����һ��dao�������
	//����ע���Զ�ע��
	@Autowired
	private UserMapper userDao;
	
	
	@Override
	public User getUserByNo(Long userNo) {
		// ��integerת��ΪLong
		return userDao.selectByPrimaryKey(userNo);
	}

	@Override
	public List<User> getAll() {
		// ���������û�
		return userDao.getAll();
	}

	@Override
	public boolean add(User user) {
		int count=userDao.insertSelective(user);
		//count���ص�����ֵ
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
