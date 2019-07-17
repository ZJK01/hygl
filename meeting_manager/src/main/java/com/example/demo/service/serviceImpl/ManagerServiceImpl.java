package com.example.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ManagerDao;
import com.example.demo.entity.Manager;
import com.example.demo.service.ManagerService;

@Service(value="ManagerServiceImpl")
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerDao managerdao;
	
	@Override
	public Manager search(Manager manager) {
		return managerdao.findByManagerNameAndManagerPassword(manager);
		
	}

}
