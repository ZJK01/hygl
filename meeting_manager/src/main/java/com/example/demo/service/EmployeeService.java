package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.entity.Employee;

public interface EmployeeService {
	
	public Employee findById(Integer id);
	
	public Employee findByName(String name);
	
	public List<Employee> findAll();
	
	public void delEmployee(Integer id);
	
	/**
	 * 根据用户名和密码
	 */
	public Employee findByEmployeeNameAndEmployeePassword(Employee employee);

	
	/**
	 * 增加员工
	 */
	public Employee add(Employee employee);
	
	/**
	 * 分页
	 * */
	public Page<Employee> fy(int ys,int hs);
	
	/**
	 * 获得页数
	 * */
	public Integer getPage(int count);
	
	/**
	 * 模糊查询
	 * */
	List<Employee> getUsers(Employee employee);
	

}
