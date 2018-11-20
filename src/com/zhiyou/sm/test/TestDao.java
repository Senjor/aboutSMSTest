package com.zhiyou.sm.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhiyou.sm.dao.UserMapper;
import com.zhiyou.sm.entity.User;

public class TestDao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1.����spring�������ļ�
		ClassPathXmlApplicationContext cxt=
				new ClassPathXmlApplicationContext("classpath:spring/spring-dao.xml");
		//2.���user��dao��Ķ���
		UserMapper dao=cxt.getBean(UserMapper.class);
		//����dao��ķ���
		User user = dao.selectByPrimaryKey(Long.parseLong("1"));
		System.out.println("�û���: "+user.getUsername()+"  ����: "+user.getUserpassword());
		
		
	}

}
