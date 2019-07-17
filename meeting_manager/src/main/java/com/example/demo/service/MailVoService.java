package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.MailVo;

public interface MailVoService {
	/* 邮件发送 */
	public String getMailSendFrom();

	public void SimpleMail(MailVo mailVo, MultipartFile[] files);

	public MailVo sendMail(MailVo mailVo, MultipartFile[] files);
}
