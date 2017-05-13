package com.gyq.sim.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gyq.sim.entity.ResearchProject;

public interface ResearchProjectDao {

	List<ResearchProject> getResearchProjectList(ResearchProject project);

	@Transactional
	void addResearchProject(ResearchProject addproject);

	void editResearchProject(ResearchProject project);

	void deleteResearchproject(ResearchProject project);

	List<ResearchProject> showAllListByTeacherName(ResearchProject project);


}
