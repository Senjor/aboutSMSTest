package com.zhiyou.sm.controller;
import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou.sm.entity.User;
import com.zhiyou.sm.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService us;
	
	//http://192.168.94.124:8080/ssm/toIndex
	@RequestMapping("/toIndex")
	public String toIndex(HttpServletRequest req){
		List<User> list = us.getAll();
		
		req.setAttribute("users", list);
		return "index";
	}
	

	@RequestMapping("/toAdd")
	public String toAdd(){
		return "add";
	}
	
	
	//http://192.168.94.124:8080/ssm/add
	@RequestMapping("/add")
	public String add(User user,Model model){
		boolean isAdd=us.add(user);
		if(!isAdd){
			model.addAttribute("errMess", "���ʧ����");
		}
		
		return "redirect:toIndex";
	}
	
	@RequestMapping("/toDel")
	public String del(Long id,HttpServletRequest req){
		
		boolean isDel = us.delete(id);
		if(!isDel){
			req.setAttribute("errMess", "�h��ʧ����");
		}
		
		return "forward:toIndex";
	}
	
	
	
	@RequestMapping("/toUp")
	public String toUpload(Long id,HttpServletRequest req){
		User user = us.getUserByNo(id);
		//�ѫ@�õ��Ñ�����뵽������
		req.setAttribute("user", user);
		return "update";
	}
	
	@RequestMapping("/update")
	public String upload(User user,HttpServletRequest req){
		boolean isUp=us.update(user);
		if(!isUp){
			req.setAttribute("errMess", "����ʧ��");
		}
		return "forward:toIndex";
	}
	
}
