package com.gyq.sim.dao;

import java.util.List;

import com.gyq.sim.entity.SimTeacher;

public interface TeacherDao {

	List<SimTeacher> getTeacherList(SimTeacher teacher);

	void addTeacher(SimTeacher addTeacher);

	void deleteTeacher(SimTeacher simTeacher);

	void editTeacher(SimTeacher editTeacher);

}
