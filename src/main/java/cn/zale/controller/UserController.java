package cn.zale.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.zale.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/list")
	public String getUserList(Map<String, Object> map) {
		map.put("userList", userService.listUsers());
		for (int i = 0; i < userService.listUsers().size(); i++) {
			System.out.println(userService.listUsers().toString());
		}

		return "/userLists";
	}

	@RequestMapping(value = "/upload/{id}", method = RequestMethod.POST)
	public @ResponseBody String upload(
			@RequestParam(value = "myfiles", required = false) MultipartFile file,
			@PathVariable String id) {
		//File f = new File(id + file.getOriginalFilename());
		try {
			//FileUtils.copyInputStreamToFile(file.getInputStream(), f);
			System.out.println("id is" + id);
			userService.saveImage(id,file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "上传成功";
	}
}
