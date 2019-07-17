package com.example.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@Service(value="EmployeeServiceImpl")
public class EmployeeServiceImpl implements EmployeeService {

   @Autowired
   private 	EmployeeDao employeedao;
	
	@Override
	public Employee findById(Integer id) {
		return employeedao.findByEmployeeId(id);
	}

	@Override
	public Employee findByName(String employeename) {
		
		return employeedao.findByEmployeeName(employeename);
	}

	@Override
	public Employee add(Employee employee) {
		
		return employeedao.save(employee);
	}
	
}
