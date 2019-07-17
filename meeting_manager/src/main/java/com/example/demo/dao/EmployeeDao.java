package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

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
	
	/**
	 * 根据用户名和密码查找用户(自动生成sql语句)
	 * */
	@Query("from Employee where employeeName=:#{#employee.employeeName}  and employeePassword=:#{#employee.employeePassword}")
	public Employee findByemployeeNameAndemployeePassword(Employee employee);
}
