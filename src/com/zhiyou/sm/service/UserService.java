package com.zhiyou.sm.service;

import java.util.List;

import com.zhiyou.sm.entity.User;

public interface UserService {
	//�������
	List<User> getAll();
	
	//��Ӳ���
	boolean add(User user);
	
	//�h���ķ���
	boolean delete(Long id);
	
	//���²���
	boolean update(User user);
	
	//ȡһ���û�����
	public User getUserByNo(Long userNo);
	
}
