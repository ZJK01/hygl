package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 部门表
 */
@Entity
public class Department implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer departmentId;      // 部门编号
	private String departMentName;     // 部门名称
	private String workSet;        	   // 部门办公地点
	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentname() {
		return departMentName;
	}

	public void setDepartmentname(String departmentname) {
		this.departMentName = departmentname;
	}

	public String getWorkset() {
		return workSet;
	}

	public void setWorkset(String workset) {
		this.workSet = workset;
	}

	public Department(Integer departmentId, String departmentname, String workset) {
		super();
		this.departmentId = departmentId;
		this.departMentName = departmentname;
		this.workSet = workset;
	}

	public Department() {
		super();
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departMentName=" + departMentName + ", workSet="
				+ workSet + "]";
	}

	
}
