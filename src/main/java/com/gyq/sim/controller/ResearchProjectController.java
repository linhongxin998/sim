package com.gyq.sim.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.gyq.sim.dao.FiledDao;
import com.gyq.sim.entity.LeaveWord;
import com.gyq.sim.entity.ResearchProject;
import com.gyq.sim.entity.SimFiled;
import com.gyq.sim.entity.SimStudent;
import com.gyq.sim.entity.SimTeacher;
import com.gyq.sim.service.FileService;
import com.gyq.sim.service.LeaveWordService;
import com.gyq.sim.service.ResearchProjectService;
import com.gyq.sim.service.TeacherService;

@Controller
@RequestMapping("/researchproject")
public class ResearchProjectController {

	@Autowired
	private ResearchProjectService researchProjectService;

	@Autowired
	private TeacherService teacherService;

	@Autowired
	private FileService fileService;
	@Autowired
	private FiledDao filedDao;

	/**
	 * ����������Ŀ�б�
	 * 
	 * @param session
	 * @param project
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "showList.do")
	@ResponseBody
	public String showList(HttpSession session, ResearchProject project, Model model) {
		// �����ݿ��в�ѯ��project���Ƶ�������Ŀ
		Integer tid = (Integer) session.getAttribute("id");
		project.setTid(tid);
		List<ResearchProject> list = researchProjectService.showList(project);
		model.addAttribute("researchProjectList", list);
		return JSON.toJSONString(list);
	}

	/**
	 * ͨ����ʦ��������������Ŀ�б�
	 * 
	 * @param session
	 * @param project
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "showAllListByTeacherName.do")
	@ResponseBody
	public String showAllListByTeacherName(ResearchProject project, Model model, String teacherName) {
		project.setIntro(teacherName);
		// �����ݿ��в�ѯ��project���Ƶ�������Ŀ
		List<ResearchProject> list = researchProjectService.showAllListByTeacherName(project);
		model.addAttribute("researchProjectList", list);
		return JSON.toJSONString(list);
	}

	/**
	 * �������п�����Ŀ�б�
	 * 
	 * @param session
	 * @param project
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "showAllList.do")
	@ResponseBody
	public String showAllList(ResearchProject project, Model model) {
		// �����ݿ��в�ѯ��project���Ƶ�������Ŀ
		List<ResearchProject> list = researchProjectService.showList(project);
		model.addAttribute("researchProjectList", list);
		return JSON.toJSONString(list);
	}

	/**
	 * ��ת����ӿ�����Ŀҳ��
	 * 
	 * @return
	 */
	@RequestMapping("/goToAddResearchProject.do")
	public String goToAddStudent() {
		return "/teacherResearchProject/addResearchProject";
	}

	/**
	 * ��ӿ�����Ŀ�����ݿ�
	 * 
	 * @param addStudent
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addResearchProject.do")
	public String addResearchProject(HttpSession session, ResearchProject project, SimFiled simFiled,
			HttpServletRequest request) {
		Integer tid = (Integer) session.getAttribute("id");

		project.setTid(tid);
		project.setCreateTime(new Date());
		project.setUpdateTime(new Date());

		// ��ӿ�����Ŀ��Ϣ
		researchProjectService.addResearchProject(project);
		return "redirect:/login/teacherLogin.do";
	}

	/**
	 * ��ת���޸Ŀ�����Ŀҳ��
	 * 
	 * @param session
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/goToResearchproject.do")
	public String goToResearchproject(HttpSession session, Integer id, Model model) {
		ResearchProject project = new ResearchProject();
		Integer tid = (Integer) session.getAttribute("id");
		project.setTid(tid);
		project.setName("");
		project.setId(id);
		List<ResearchProject> projects = new ArrayList<ResearchProject>();
		projects = researchProjectService.showList(project);
		if (projects.size() > 0) {
			model.addAttribute("ResearchProject", projects.get(0));
		}
		return "/teacherResearchProject/editResearchproject";
	}

	/**
	 * �޸Ŀ�����Ŀ��Ϣ
	 * 
	 * @param project
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/editResearchProject.do")
	public String editResearchProject(ResearchProject project, HttpSession session, Model model) {
		// �޸���Ϣ
		Integer tid = (Integer) session.getAttribute("id");
		project.setTid(tid);
		project.setUpdateTime(new Date());
		researchProjectService.editResearchProject(project);
		// ��ѯ�������п�����Ϣ
		ResearchProject p = new ResearchProject();
		p.setTid(tid);
		p.setName("");
		List<ResearchProject> list = researchProjectService.showList(p);
		model.addAttribute("researchProjectList", list);
		return "/teacherResearchProject/teacherResearchProject";
	}

	@RequestMapping("/deleteResearchproject.do")
	@ResponseBody
	public String deleteResearchproject(Integer id) {
		ResearchProject project = new ResearchProject();
		project.setId(id);
		researchProjectService.deleteResearchproject(project);
		return "success";
	}

	/**
	 * ��ת����������ҳ��
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/ResearchprojectDetail.do")
	public String ResearchprojectDetail(Integer id, Model model) {
		// ��ȡ������Ϣ
		ResearchProject project = new ResearchProject();
		project.setId(id);
		project.setName("");
		List<ResearchProject> list = researchProjectService.showList(project);
		if (list.size() > 0) {
			model.addAttribute("researchProject", list.get(0));
			Integer tid = list.get(0).getTid();
			SimTeacher tempTeacher = new SimTeacher();
			tempTeacher.setId(tid);
			SimTeacher simTeacher = teacherService.showList(tempTeacher).get(0);
			model.addAttribute("teacherQQ", simTeacher.getQq());
			model.addAttribute("teacherQqUrl", simTeacher.getQqUrl());
			model.addAttribute("teacherQqSrc", simTeacher.getQqSrc());
		}
		return "/researchProject/ResearchprojectDetail";
	}

	/**
	 * �����б�
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/backresearchproject.do")
	public String backresearchproject(HttpSession session) {
		String identity = (String) session.getAttribute("identity");
		if ("teacher".equals(identity)) {
			return "redirect:/login/teacherLogin.do";
		} else {
			return "redirect:/login/studentAndVisitorLogin.do";
		}

	}

	@RequestMapping(value = "downPhotoById")
	public void downFileByRCode(String rCode, final HttpServletResponse response) {
		SimFiled entity = filedDao.downFileByRCode(rCode);
		byte[] data = entity.getFileData();
		String fileName = entity.getFileName() == null ? "����" : entity.getFileName();
		try {
			fileName = URLEncoder.encode(fileName, "UTF-8");
			response.reset();
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			response.addHeader("Content-Length", "" + data.length);
			response.setContentType("application/octet-stream;charset=UTF-8");
			OutputStream outputStream = new BufferedOutputStream(response.getOutputStream());
			outputStream.write(data);
			outputStream.flush();
			outputStream.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
