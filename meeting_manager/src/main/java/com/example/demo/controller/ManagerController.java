package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Manager;
import com.example.demo.service.ManagerService;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Resource(name="ManagerServiceImpl")
	private ManagerService managerService;
	
	@GetMapping("/")
	public String main(ModelMap model) {
		return "index";
	}
	
	@PostMapping("/yuyue")
	public String managerlogin(String username,String password,ModelMap model) {
		Manager manager=new Manager();
		manager.setManagerName(username);
		manager.setManagerPassword(password);
		Manager man=managerService.search(manager);
		model.put("user", man);
		if(man!=null) {
			return "yuyue";
		}else {
			return "index";
		}
	}
		
}	
