package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 会议表
 */
@Entity
public class Meeting implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer meetingId; 	// 会议id
	private Integer broomId; 	// 会议室id
	private Integer meetingCount; // 会议人数
	private Date startTime; 	// 会议开始时间
	private Date endTime; 		// 会议结束时间
	private String meetingStas; // 会议内容
	private Date reservAtionTime; // 预定时间
	private Integer reservAtionuserId; // 预定人id

	public Integer getmeetingId() {
		return meetingId;
	}

	public void setmeetingId(Integer meetingId) {
		this.meetingId = meetingId;
	}

	public Integer getBroomid() {
		return broomId;
	}

	public void setBroomid(Integer broomid) {
		this.broomId = broomid;
	}

	public Integer getMeetingcount() {
		return meetingCount;
	}

	public void setMeetingcount(Integer meetingcount) {
		this.meetingCount = meetingcount;
	}

	public Date getStarttime() {
		return startTime;
	}

	public void setStarttime(Date starttime) {
		this.startTime = starttime;
	}

	public Date getEndtime() {
		return endTime;
	}

	public void setEndtime(Date endtime) {
		this.endTime = endtime;
	}

	public String getMeetingstas() {
		return meetingStas;
	}

	public void setMeetingstas(String meetingstas) {
		this.meetingStas = meetingstas;
	}

	public Date getReservationtime() {
		return reservAtionTime;
	}

	public void setReservationtime(Date reservationtime) {
		this.reservAtionTime = reservationtime;
	}

	public Integer getReservationuserid() {
		return reservAtionuserId;
	}

	public void setReservationuserid(Integer reservationuserid) {
		this.reservAtionuserId = reservationuserid;
	}

	public Meeting(Integer meetingId, Integer broomid, Integer meetingcount, Date starttime, Date endtime,
			String meetingstas, Date reservationtime, Integer reservationuserid) {
		super();
		this.meetingId = meetingId;
		this.broomId = broomid;
		this.meetingCount = meetingcount;
		this.startTime = starttime;
		this.endTime = endtime;
		this.meetingStas = meetingstas;
		this.reservAtionTime = reservationtime;
		this.reservAtionuserId = reservationuserid;
	}

	public Meeting() {
		super();
	}

	@Override
	public String toString() {
		return "Meeting [meetingId=" + meetingId + ", broomId=" + broomId + ", meetingCount=" + meetingCount
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", meetingStas=" + meetingStas
				+ ", reservAtionTime=" + reservAtionTime + ", reservAtionuserId=" + reservAtionuserId + "]";
	}

	
}
