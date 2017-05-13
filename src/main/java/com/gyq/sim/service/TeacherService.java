package com.gyq.sim.service;

import java.util.List;

import com.gyq.sim.entity.SimTeacher;

public interface TeacherService {

	List<SimTeacher> showList(SimTeacher teacher);

	void addTeacher(SimTeacher addTeacher);

	void deleteTeacher(Integer id);

	void editTeacher(SimTeacher editTeacher);

}
