package com.gyq.sim.service;

import java.util.List;

import com.gyq.sim.entity.ResearchProject;
import com.gyq.sim.entity.SimStudent;

public interface ResearchProjectService {

	public List<ResearchProject> showList(ResearchProject project);

	public void addResearchProject(ResearchProject project);

	public void editResearchProject(ResearchProject project);

	public void deleteResearchproject(ResearchProject project);

	public List<ResearchProject> showAllListByTeacherName(ResearchProject project);

}
