package com.example.demo.dao.imp;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.MailVoDao;
import com.example.demo.entity.MailVo;

@Component
public class MailVoDaoImp implements MailVoDao {

	private Logger logger = LoggerFactory.getLogger(getClass());// 提供日志类

	@Autowired
	private JavaMailSenderImpl mailSender;

	// 获取发件人邮箱名
	@Override
	public String getMailSendFrom() {
		// TODO Auto-generated method stub
		return mailSender.getUsername();
	}

	@Override
	public void SimpleMail(MailVo mailVo, MultipartFile[] files) {
		// TODO Auto-generated method stub
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailSender.createMimeMessage(), true);// true表示支持复杂类型
			mailVo.setFromone(getMailSendFrom());// 邮件发信人从配置项读取
			messageHelper.setFrom(mailVo.getFromone());// 邮件发信人
			messageHelper.setTo(mailVo.getTouser().split(","));// 邮件收信人
			messageHelper.setSubject(mailVo.getSubject());// 邮件主题
			messageHelper.setText(mailVo.getText());// 邮件内容
//			if (!StringUtils.isEmpty(mailVo.getCc())) {// 抄送
//				messageHelper.setCc(mailVo.getCc().split(","));
//			}
//			if (!StringUtils.isEmpty(mailVo.getBcc())) {// 密送
//				messageHelper.setCc(mailVo.getBcc().split(","));
//			}
//			if (mailVo.getMultipartFiles() != null) {// 添加邮件附件
//				for (MultipartFile multipartFile : mailVo.getMultipartFiles()) {
//					messageHelper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
//				}
//			}
			if (files != null) {// 添加邮件附件
				for (MultipartFile multipartFile : files) {
					messageHelper.addAttachment(multipartFile.getOriginalFilename(), multipartFile);
				}
			}
			if (StringUtils.isEmpty(mailVo.getSentDate())) {// 发送时间
				mailVo.setSentDate(new Date());
				messageHelper.setSentDate(mailVo.getSentDate());
			}
			mailSender.send(messageHelper.getMimeMessage());// 正式发送邮件
			mailVo.setStatus("ok");
			logger.info("发送邮件成功：{}->{}", mailVo.getFromone(), mailVo.getTouser());
		} catch (Exception e) {
			throw new RuntimeException(e);// 发送失败
		}
	}

	/**
	 * 发送邮件
	 */
	@Override
	public MailVo sendMail(MailVo mailVo, MultipartFile[] files) {
		try {
			checkMail(mailVo); // 1.检测邮件
			SimpleMail(mailVo, files); // 2.发送邮件
			return saveMail(mailVo); // 3.保存邮件
		} catch (Exception e) {
			logger.error("发送邮件失败:", e);// 打印错误信息
			mailVo.setStatus("fail");
			mailVo.setError(e.getMessage());
			return mailVo;
		}

	} // 检测邮件信息类

	private void checkMail(MailVo mailVo) {
		if (StringUtils.isEmpty(mailVo.getTouser())) {
			throw new RuntimeException("邮件收信人不能为空");
		}
		if (StringUtils.isEmpty(mailVo.getSubject())) {
			throw new RuntimeException("邮件主题不能为空");
		}
		if (StringUtils.isEmpty(mailVo.getText())) {
			throw new RuntimeException("邮件内容不能为空");
		}
	} // 构建复杂邮件信息类

	private MailVo saveMail(MailVo mailVo) { // 将邮件保存到数据库..
		return mailVo;
	} // 获取邮件发信人

}