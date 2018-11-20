package com.zhiyou.sm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.exceptions.ClientException;
import com.zhiyou.sm.entity.User;
import com.zhiyou.sm.util.SmsDemo;

@Controller
public class RegController {

	@ResponseBody
	@RequestMapping("/user/code")
	public String getCode(String tel, HttpServletRequest request) {

		// 获取tel
		// 生成验证码
		String[] codes = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		// 生成一个6位数的验证码
		String code = "";
		for (int i = 0; i < 6; i++) {
			int j = (int) (Math.random() * 10);
			code += codes[j];
		}

		// 调用方法
		try {
			SmsDemo.sendSms(tel, code);

			// 把code放到session里，并设置有限期
			HttpSession session = request.getSession();
			session.setAttribute("code", code);
			// 设置有效时间
			session.setMaxInactiveInterval(5* 60);

			return "200";
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "400";
		}

	}
	
	@RequestMapping("/user/reg")
	public String checkReg(User user){
		//输出得到的信息,
		System.out.println("用户名="+user.getUsername()+"  密码"+user.getUserpassword()+" 验证码:"+user.getUsercode());
		//做插入操作,同时比对session中存入的验证码...
		
		return "success";
	}
	
	
}
