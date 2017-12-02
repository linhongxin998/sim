package com.gyq.sim.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyq.sim.entity.common.BaseUser;
import com.gyq.sim.service.LoginService;

/**
 * ��¼������
 * @author qiqiangvae
 *
 */
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	/**
	 * ����ҳ��ת����¼����
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping("/goToLogin.do")
	public String goToLogin(){
		return "/login/login";
	}
	
	/**
	 * �û���¼
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping("/doLogin.do")
	public String doLogin(BaseUser user,Model model,HttpSession session){
		/**
		 * ȥ���ݿ��ѯ�û����������Ƿ�ƥ�䣬��ȡ������û�
		 */
		BaseUser loginUser= loginService.doLogin(user);
		//��¼�ɹ�������룬�������µ�¼
		if (loginUser!=null) {
			model.addAttribute("loginUser",loginUser);
			model.addAttribute("msg", "�ɹ���¼");
			session.setMaxInactiveInterval(3600);
			session.setAttribute("username", loginUser.getUsername());
			session.setAttribute("id", loginUser.getId());
			session.setAttribute("identity", loginUser.getIdentity());
			//����ǹ���Ա��¼��������̨����ҳ��,���������Ŀչʾҳ��
			if ("admin".equals(loginUser.getIdentity())) {
				return "redirect:/login/adminLogin.do";
			}if ("teacher".equals(loginUser.getIdentity())) {
				return "redirect:/login/teacherLogin.do";	
			}else {
				return "redirect:/login/studentAndVisitorLogin.do";
			}
		}else {
			model.addAttribute("msg", "�û��������벻��ȷ");
			return "redirect:/login/goToLogin.do";
		}
	}
	
	/**
	 * �˳���¼
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
	 * ��ʦ��¼
	 * @return
	 */
	@RequestMapping("/teacherLogin.do")
	public String teacherLogin(){
		return "/teacherResearchProject/teacherResearchProject";
	}
	
	/**
	 * ����Ա��¼
	 * @return
	 */
	@RequestMapping("/adminLogin.do")
	public String adminLogin(){
		return "/backManage/backManage";
	}
	
	/**
	 * ѧ�����ο͵�¼
	 * @return
	 */
	@RequestMapping("/studentAndVisitorLogin.do")
	public String studentAndVisitorLogin(HttpSession session){
		return "/showResearchProject/showResearchProject";
	}
}
