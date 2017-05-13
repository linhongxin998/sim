package com.gyq.sim.dao;

import java.util.List;

import com.gyq.sim.entity.ResearchProject;

public interface ResearchProjectDao {

	List<ResearchProject> getResearchProjectList(ResearchProject project);

	void addResearchProject(ResearchProject addproject);

	void editResearchProject(ResearchProject project);

	void deleteResearchproject(ResearchProject project);

	List<ResearchProject> showAllListByTeacherName(ResearchProject project);


}
