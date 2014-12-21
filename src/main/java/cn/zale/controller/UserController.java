package cn.zale.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.zale.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/list")
	public String getUserList(Map<String , Object> map)
	{
		map.put("userList", userService.listUsers());
		for (int i = 0; i < userService.listUsers().size(); i++) {
			System.out.println(userService.listUsers().toString());
		}
		
		return "/userLists";
	}
}
