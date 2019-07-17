package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * 员工表
 */
@Entity
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer employeeId;      // 员工编号
	private String employeeName;     // 员工姓名
	private String employeeAccount;  // 员工账户
	private String employeePassword; // 登录密码
	private String power;            // 权力
	private String employeeEmail;    // 邮箱
	private Integer departMent;     // 所属部门
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAccount() {
		return employeeAccount;
	}
	public void setEmployeeAccount(String employeeAccount) {
		this.employeeAccount = employeeAccount;
	}
	public String getEmployeePassword() {
		return employeePassword;
	}
	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public Integer getDepartMent() {
		return departMent;
	}
	public void setDepartMent(Integer departMent) {
		this.departMent = departMent;
	}
	public Employee(Integer employeeId, String employeeName, String employeeAccount, String employeePassword,
			String power, String employeeEmail, Integer departMent) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeAccount = employeeAccount;
		this.employeePassword = employeePassword;
		this.power = power;
		this.employeeEmail = employeeEmail;
		this.departMent = departMent;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeAccount="
				+ employeeAccount + ", employeePassword=" + employeePassword + ", power=" + power + ", employeeEmail="
				+ employeeEmail + ", departMent=" + departMent + "]";
	}

	

}
