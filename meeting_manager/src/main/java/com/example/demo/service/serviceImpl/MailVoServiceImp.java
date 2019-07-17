package com.example.demo.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.MailVoDao;
import com.example.demo.entity.MailVo;
import com.example.demo.service.MailVoService;

@Component
public class MailVoServiceImp implements MailVoService {

	@Autowired
	private MailVoDao mailVoDao;

	@Override
	public String getMailSendFrom() {
		// TODO Auto-generated method stub
		return mailVoDao.getMailSendFrom();
	}

	@Override
	public void SimpleMail(MailVo mailVo, MultipartFile[] files) {
		// TODO Auto-generated method stub
		mailVoDao.SimpleMail(mailVo, files);
	}

	@Override
	public MailVo sendMail(MailVo mailVo, MultipartFile[] files) {
		// TODO Auto-generated method stub
		return mailVoDao.sendMail(mailVo, files);
	}

}
