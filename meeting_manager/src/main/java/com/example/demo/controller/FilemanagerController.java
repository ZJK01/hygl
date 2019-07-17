package com.example.demo.controller;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.common.util.Editor;
import com.example.demo.entity.Matter;
import com.example.demo.service.MatterService;

@Controller
@RequestMapping("filemanager")
public class FilemanagerController {
	@Autowired
	Editor Editor; // 配置类(负责文件富文本框中内容的读写)

	@Resource(name = "MatterServiceImpl")
	MatterService matterService;

	@GetMapping("/")
	public String filemain() {
		return "filemanager/sendfile";
	}

	@PostMapping("/fileup")
	public String fileup(@ModelAttribute Matter matter) {
		try {
			Editor.docFile(matter.getMattercontent(), matter.getMatterName());
		} catch (Exception e) {
			System.out.println("写入失败");
			e.printStackTrace();
		}
		matter.setMatterTime(new Date());
		matterService.save(matter);
		return "redirect:/";
	}
}
