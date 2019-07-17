package com.example.demo.dao;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.MailVo;

public interface MailVoDao {

	/* 邮件发送 */
	public String getMailSendFrom();

	public void SimpleMail(MailVo mailVo, MultipartFile[] files);

	public MailVo sendMail(MailVo mailVo, MultipartFile[] files);
}
