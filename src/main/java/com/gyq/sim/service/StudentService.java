package com.gyq.sim.service;

import java.util.List;

import com.gyq.sim.entity.SimStudent;

public interface StudentService {
	List<SimStudent> showList(SimStudent student);

	void editStudent(SimStudent addStudent);

	void deleteStudent(Integer id);

	void addStudent(SimStudent addStudent);
}
