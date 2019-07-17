package com.example.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Meeting;
import com.example.demo.service.ManagerService;
import com.example.demo.service.MeetingService;
import com.example.demo.service.serviceImpl.EmployeeServiceImpl;

@Controller
@RequestMapping("/demanager")
public class DemanagerController {

	@Resource(name = "ManagerServiceImpl")
	private ManagerService managerService;
	
	@Resource(name = "EmployeeServiceImpl")
	private EmployeeServiceImpl employeeServiceImpl;
	
	@Resource(name = "meetingServiceImpl")
	private MeetingService meetingService;

	@GetMapping("/")
	public String main() {
		return "html/login.html";
	}

	@GetMapping("/zc")
	public String zcc() {
		return "html/reg";
	}

	@PostMapping("httt")
	public String htt() {
		return "html/ht";
	}
	

	// 分页
	@PostMapping("/pagefy")
	public String huiyi(@ModelAttribute Meeting meeting, Model model, @RequestParam(defaultValue = "0") Integer id) {

		Integer count = meetingService.count();// 总行数
		Integer pages; // 总页数
		Integer pageCount = 3; // 每页浏览行数
		if (count % pageCount == 0) {
			pages = count / pageCount;
		} else {
			pages = count / pageCount + 1;
		}
		Integer pagecurrent = 0; // 当前页数
		if (0 != id) {
			pagecurrent = id; // 当前页数=id
		}
		Page<Meeting> list = meetingService.fy(pages, pageCount);
		model.addAttribute("list", list);
		model.addAttribute("pagecurrent", pagecurrent);
		model.addAttribute("pages", pages);

		return "html/pagefy ";

	}

	// 登陆进入预约页面
	@PostMapping("/yuyue")
	public String managerlogin(HttpServletRequest request, Model model, @ModelAttribute User user,
			HttpSession session) {
		User user1 = userService.getUser(user);
		String error = "账号或者密码错误";
		session.setAttribute("user1", user1);
		if (null != user1) {
			model.addAttribute("user1", user1);
			return "html/yuyue";
		} else {
			model.addAttribute("error", error);
			return "html/login  ";

		}
	}

	// 个人页面
	@GetMapping("/geren")
	public String geren(Model model, HttpSession session, HttpServletRequest request) {

		User user2 = (User) session.getAttribute("user1");// 从上一个sessin获取值
		session.setAttribute("user2", user2);// 丢到下一个视图层
		model.addAttribute("user2", user2);// 放入模型从点开页面geren.html获取
		return "html/geren";
	}

	// 注册用户
	@PostMapping("reg")
	public String adduser(@ModelAttribute User user, HttpSession session, Model model) {

		if (!user.username.equals("")) {
			if (user.password != "") {
				if (user.sex != "") {
					if (user.upload != "") {
						if (user.starttime != "") {
							if (user.email != "") {
								if (user.introduce != "") {
									userService.save(user);
									return "html/zc";
								} else {

									return "redirect:../zc";
								}
							} else {

								return "redirect:../zc";
							}
						} else {

							return "redirect:../zc";
						}
					} else {

						return "redirect:../zc";
					}
				} else {

					return "redirect:../zc";
				}
			} else {

				return "redirect:../zc";
			}
		} else {

			return "redirect:../zc";
		}

	}

	// 预定会议
	@PostMapping("/ht1")
	public String ht(@ModelAttribute Meeting meeting, Model model) {

		if (meeting.date != "") {
			if (meeting.startTime != "") {
				if (meeting.location != "") {
					if (meeting.context != "") {
						if (meeting.endTime != "") {
							meetingService.save(meeting);
							return "html/sucess_send";
						} else {
							return "redirect:../httt";
						}
					} else {
						return "redirect:../httt";
					}
				} else {
					return "redirect:../httt";
				}
			} else {
				return "redirect:../httt";
			}
		} else {
			return "redirect:../httt";
		}

	}

}
