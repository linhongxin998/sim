package com.gyq.sim.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyq.sim.entity.BaseUser;
import com.gyq.sim.service.LoginService;

/**
 * 登录控制器
 * @author qiqiangvae
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * 从首页跳转到登录界面
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/goToLogin.do")
	public String goToLogin(){
		return "/login/login";
	}
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping("/doLogin.do")
	public String doLogin(BaseUser user,Model model,HttpSession session){
		/**
		 * 去数据库查询用户名和密码是否匹配，并取出这个用户
		 */
		BaseUser loginUser= loginService.doLogin(user);
		//登录成功，则进入，否则重新登录
		if (loginUser!=null) {
			model.addAttribute("loginUser",loginUser);
			model.addAttribute("msg", "成功登录");
			session.setMaxInactiveInterval(3600);
			session.setAttribute("username", loginUser.getUsername());
			session.setAttribute("id", loginUser.getId());
			session.setAttribute("identity", loginUser.getIdentity());
			//如果是管理员登录，则进入后台管理页面,否则进入项目展示页面
			if ("admin".equals(loginUser.getIdentity())) {
				return "redirect:/login/adminLogin.do";
			}if ("teacher".equals(loginUser.getIdentity())) {
				return "redirect:/login/teacherLogin.do";	
			}else {
				return "redirect:/login/studentAndVisitorLogin.do";
			}
		}else {
			model.addAttribute("msg", "用户名或密码不正确");
			return "redirect:/login/goToLogin.do";
		}
	}
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping("/dropLogin.do")
	public String dropLogin(HttpSession session){
		session.removeAttribute("loginUser");
		session.removeAttribute("id");
		session.removeAttribute("identity");
		return "redirect:/login/goToLogin.do";
	}
	
	/**
	 * 教师登录
	 * @return
	 */
	@RequestMapping("/teacherLogin.do")
	public String teacherLogin(){
		return "/teacherResearchProject/teacherResearchProject";
	}
	
	/**
	 * 管理员登录
	 * @return
	 */
	@RequestMapping("/adminLogin.do")
	public String adminLogin(){
		return "/backManage/backManage";
	}
	
	/**
	 * 学生或游客登录
	 * @return
	 */
	@RequestMapping("/studentAndVisitorLogin.do")
	public String studentAndVisitorLogin(HttpSession session){
		return "/showResearchProject/showResearchProject";
	}
}
