package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee> {
	/**
	 * 根据id查找员工
	 * */
	public Employee findByEmployeeId(Integer id);
	
	/**
	 * 更具name查找员工
	 * */
	public Employee findByEmployeeName(String employeeName);
}
