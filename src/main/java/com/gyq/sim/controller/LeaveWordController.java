package com.gyq.sim.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gyq.sim.entity.LeaveWord;
import com.gyq.sim.entity.ResearchProject;
import com.gyq.sim.service.LeaveWordService;
import com.gyq.sim.service.ResearchProjectService;

/**
 * ���Թ���controller
 * 
 * @author qiqiangvae
 *
 */
@RequestMapping("/leaveword")
@Controller
public class LeaveWordController {

	@Autowired
	private LeaveWordService leaveWordService;
	@Autowired
	private ResearchProjectService researchProjectService;

	/**
	 * �û��ظ�����
	 * 
	 * @param forResearchId
	 * @param forResearchName
	 * @return
	 */
	@RequestMapping("/addLeaveWordByUser.do")
	@ResponseBody
	public String addLeaveWordByUser(LeaveWord leaveWord, HttpSession session,Model model) {
		Integer tid = (Integer) session.getAttribute("id");
		String byUserName = (String) session.getAttribute("username");
		String userIdentity = (String) session.getAttribute("identity");
		leaveWord.setCreateTime(new Date());
		leaveWord.setByUserId(tid);
		leaveWord.setByUserName(byUserName);
		leaveWord.setUserIdentity(userIdentity);
		leaveWordService.saveLeaveWord(leaveWord);
		return "success";
	}
	
	/**
	 * ��ȡ�����µ�������Ϣ
	 */
	@RequestMapping("/listLeaveWord.do")
	@ResponseBody
	public String listLeaveWord(Integer id) {
		LeaveWord leaveWord=new LeaveWord();
		leaveWord.setForResearchId(id);
		List<LeaveWord> leaveWordlist= leaveWordService.getLeaveWord(leaveWord);
		return JSON.toJSONString(leaveWordlist);
	}
	
	/**
	 * ��ת����������ҳ��
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/leaveWordDetail.do")
	public String ResearchprojectDetail(Integer id,Model model){
		//��ȡ������Ϣ
		ResearchProject project = new ResearchProject();
		project.setId(id);
		project.setName("");
		List<ResearchProject> list=researchProjectService.showList(project);
		if (list.size()>0) {
			model.addAttribute("researchProject", list.get(0));
		}
		return "/leaveWordManage/leaveWordDetail";
	}
	
	/**
	 * ɾ������
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteLeaveWord.do")
	public String deleteLeaveWord(Integer id){
		LeaveWord leaveWord=new LeaveWord();
		leaveWord.setId(id);
		leaveWordService.deleteLeaveWord(leaveWord);
		return "success";
		
	}
}
