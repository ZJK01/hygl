package com.example.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Meeting;
import com.example.demo.service.MeetingService;
import com.example.demo.service.serviceImpl.EmployeeServiceImpl;

@Controller
@RequestMapping("/demanager")
public class DemanagerController {

	@Resource(name = "EmployeeServiceImpl")
	private EmployeeServiceImpl employeeServiceImpl;

	@Resource(name = "MeetingServiceImpl")
	private MeetingService meetingService;


	@GetMapping("/zc")
	public String zcc() {
		return "/demanager/reg";
	}

	@PostMapping("httt")
	public String htt() {
		return "/demanager/ht";
	}

	// 分页
	@GetMapping("/pagefy/{id}")
	public String huiyi(@RequestParam(defaultValue = "0",name="id") Integer id,Model model) {

		Integer count = employeeServiceImpl.count();// 总行数
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
		Page<Employee> list = employeeServiceImpl.fy(pagecurrent, pageCount);
		model.addAttribute("list", list);
		model.addAttribute("pagecurrent", pagecurrent);
		model.addAttribute("pages", pages);

		return "/demanager/pagefy";

	}

	// 登陆进入预约页面
	@PostMapping("/yuyue")
	public String managerlogin(HttpServletRequest request, Model model, @ModelAttribute Employee employee,
			HttpSession session) {
		String error = "账号或者密码错误";
		session.setAttribute("user1", employee);
		if (null != employee) {
			model.addAttribute("user1", employee);
			return "/demanager/yuyue";
		} else {
			model.addAttribute("error", error);
			return "/demanager/login";

		}
	}


	// 注册用户
	@PostMapping("reg")
	public String adduser(@ModelAttribute Employee employee, HttpSession session, Model model) {
		if (!employee.getEmployeeName().equals("")) {
			if (employee.getEmployeePassword() != "") {
				if (employee.getEmployeeEmail() != "") {
					if (employee.getPower() != "") {
						employeeServiceImpl.add(employee);
						return "/demanager/zc";
					} else {
						return "redirect:zc";
					}
				} else {
					return "redirect:zc";
				}
			} else {
				return "redirect:zc";
			}
		} else {
			return "redirect:zc";
		}
	}
	

	// 预定会议
	@PostMapping("/ht1")
	public String ht(@ModelAttribute Meeting meeting, Model model) {

		if (meeting.getReservationtime() !=null) {
			if (meeting.getStarttime() !=null) {
				if (meeting.getBroomid() !=null) {
					if (meeting.getMeetingstas() != "") {
						if (meeting.getEndtime()!=null) {
							meetingService.add(meeting);
							return "/demanager/sucess_send";
						} else {
							return "redirect:httt";
						}
					} else {
						return "redirect:httt";
					}
				} else {
					return "redirect:httt";
				}
			} else {
				return "redirect:httt";
			}
		} else {
			return "redirect:httt";
		}

	}

}
