package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.MailVo;
import com.example.demo.service.MailVoService;

@Controller
//@RequestMapping("email")
public class EmailController {

	@Autowired
	private MailVoService mailVoService;

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("mailvo/sendMail");// 打开发送邮件的页面
		mv.addObject("from", mailVoService.getMailSendFrom());
		return mv;
	}

	/**
	 * 发送邮件
	 */
	@ResponseBody
	@PostMapping("/mail/send")
	public MailVo sendMail(MailVo mailVo, MultipartFile[] files) {
		System.out.println(11);
//		mailVo.setMultipartFiles(files);
		return mailVoService.sendMail(mailVo, files);// 发送邮件和附件
	}
   
}
