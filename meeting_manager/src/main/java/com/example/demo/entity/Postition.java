package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 职位表
 */
@Entity
public class Postition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer positionId; // 部门编号
	private String positionName; // 部门名称

	public Integer getPositionid() {
		return positionId;
	}

	public void setPositionid(Integer positionid) {
		this.positionId = positionid;
	}

	public String getPositionname() {
		return positionName;
	}

	public void setPositionname(String positionname) {
		this.positionName = positionname;
	}

	public Postition(Integer positionid, String positionname) {
		super();
		this.positionId = positionid;
		this.positionName = positionname;
	}

	public Postition() {
		super();
	}

	@Override
	public String toString() {
		return "Postition [positionId=" + positionId + ", positionName=" + positionName + "]";
	}

}
