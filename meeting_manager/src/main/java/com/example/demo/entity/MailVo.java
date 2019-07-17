package com.example.demo.entity;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mailvo")
public class MailVo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;// 邮件id
	private String fromone;// 邮件发送人
	private String touser;// 邮件接收人（多个邮箱则用逗号","隔开）
	private String subject;// 邮件主题
	private String text;// 邮件内容
	private Date sentDate;// 发送时间
	private String status;// 状态
	private String error;// 报错信息

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFromone() {
		return fromone;
	}

	public void setFromone(String fromone) {
		this.fromone = fromone;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getSentDate() {
		return sentDate;
	}

	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public MailVo(Integer id, String fromone, String touser, String subject, String text, Date sentDate, String status,
			String error) {
		super();
		this.id = id;
		this.fromone = fromone;
		this.touser = touser;
		this.subject = subject;
		this.text = text;
		this.sentDate = sentDate;
		this.status = status;
		this.error = error;
	}

	public MailVo() {
	}

	@Override
	public String toString() {
		return "MailVo [id=" + id + ", fromone=" + fromone + ", touser=" + touser + ", subject=" + subject + ", text="
				+ text + ", sentDate=" + sentDate + ", status=" + status + ", error=" + error + "]";
	}

}
