package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 会议室表
 */
@Entity
public class Boradroom implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer boradroomId; // 编号
	private String boradroomName; // 名称
	private String boradRoomNumber; // 人数
	private String boradRoomreMark; // 描述备注
	private String boradRoomType; // 类型
	private String boradRoomStatus; // 会议室状态

	public Integer getBoradroomId() {
		return boradroomId;
	}

	public void setBoradroomId(Integer boradroomId) {
		this.boradroomId = boradroomId;
	}

	public String getBoradroomName() {
		return boradroomName;
	}

	public void setBoradroomName(String boradroomName) {
		this.boradroomName = boradroomName;
	}

	public String getBoradRoomNumber() {
		return boradRoomNumber;
	}

	public void setBoradRoomNumber(String boradRoomNumber) {
		this.boradRoomNumber = boradRoomNumber;
	}

	public String getBoradRoomreMark() {
		return boradRoomreMark;
	}

	public void setBoradRoomreMark(String boradRoomreMark) {
		this.boradRoomreMark = boradRoomreMark;
	}

	public String getBoradRoomType() {
		return boradRoomType;
	}

	public void setBoradRoomType(String boradRoomType) {
		this.boradRoomType = boradRoomType;
	}

	public String getBoradRoomStatus() {
		return boradRoomStatus;
	}

	public void setBoradRoomStatus(String boradRoomStatus) {
		this.boradRoomStatus = boradRoomStatus;
	}

	public Boradroom(Integer boradroomId, String boradroomName, String boradRoomNumber, String boradRoomreMark,
			String boradRoomType, String boradRoomStatus) {
		super();
		this.boradroomId = boradroomId;
		this.boradroomName = boradroomName;
		this.boradRoomNumber = boradRoomNumber;
		this.boradRoomreMark = boradRoomreMark;
		this.boradRoomType = boradRoomType;
		this.boradRoomStatus = boradRoomStatus;
	}

	public Boradroom() {
		super();
	}

	@Override
	public String toString() {
		return "Boradroom [boradroomId=" + boradroomId + ", boradroomName=" + boradroomName + ", boradRoomNumber="
				+ boradRoomNumber + ", boradRoomreMark=" + boradRoomreMark + ", boradRoomType=" + boradRoomType
				+ ", boradRoomStatus=" + boradRoomStatus + "]";
	}

}
