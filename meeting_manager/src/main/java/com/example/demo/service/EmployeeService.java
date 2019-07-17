package com.example.demo.service;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	public Employee findById(Integer id);
	
	public Employee findByName(String name);
	
	/**
	 * 增加员工
	 */
	public Employee add(Employee employee);
}
