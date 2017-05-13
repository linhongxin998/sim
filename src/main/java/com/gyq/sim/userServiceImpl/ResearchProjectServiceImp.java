package com.gyq.sim.userServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyq.sim.dao.FiledDao;
import com.gyq.sim.dao.ResearchProjectDao;
import com.gyq.sim.entity.ResearchProject;
import com.gyq.sim.entity.SimFiled;
import com.gyq.sim.entity.SimStudent;
import com.gyq.sim.service.FileService;
import com.gyq.sim.service.ResearchProjectService;

@Service
public class ResearchProjectServiceImp implements ResearchProjectService {

	@Autowired
	private ResearchProjectDao researchProjectDao;
	@Autowired
	private FiledDao filedDao;

	/**
	 * 搜索科研项目
	 */
	@Override
	public List<ResearchProject> showList(ResearchProject project) {
		List<ResearchProject> list = researchProjectDao.getResearchProjectList(project);
		return list;
	}

	/**
	 * 添加科研项目信息
	 */
	@Override
	public void addResearchProject(ResearchProject addproject) {
		// 判存
		ResearchProject project = new ResearchProject();
		project.setrCode(addproject.getrCode());
		project.setTid(addproject.getTid());
		List<ResearchProject> list = researchProjectDao.getResearchProjectList(project);
		if (list.size() == 0) {
			researchProjectDao.addResearchProject(addproject);
		}
		try {
			InputStream is = addproject.getFile().getInputStream();
			byte[] fileData = new byte[(int) addproject.getFile().getSize()];
			is.read(fileData);
			String fileName = addproject.getFile().getOriginalFilename();
			SimFiled filed = new SimFiled();
			filed.setFileData(fileData);
			filed.setFileName(fileName);
			filed.setId(addproject.getrCode());
			filedDao.saveFile(filed);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新科研项目信息
	 */
	@Override
	public void editResearchProject(ResearchProject project) {
		// 转码
		try {
			String name = new String(project.getName().getBytes("ISO-8859-1"), "UTF-8");
			String intro = new String(project.getIntro().getBytes("ISO-8859-1"), "UTF-8");
			String content = new String(project.getContent().getBytes("ISO-8859-1"), "UTF-8");
			project.setName(name);
			project.setIntro(intro);
			project.setContent(content);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		researchProjectDao.editResearchProject(project);
	}

	/**
	 * 从数据库中删除项目
	 */
	@Override
	public void deleteResearchproject(ResearchProject project) {
		project = researchProjectDao.getResearchProjectList(project).get(0);
		filedDao.deletePhotoByRcode(project.getrCode());
		researchProjectDao.deleteResearchproject(project);
	}

	/**
	 * 通过老师姓名查询科研项目
	 */
	@Override
	public List<ResearchProject> showAllListByTeacherName(ResearchProject project) {
		List<ResearchProject> list = researchProjectDao.showAllListByTeacherName(project);
		return list;
	}

}
