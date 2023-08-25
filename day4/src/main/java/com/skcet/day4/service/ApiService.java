package com.skcet.day4.service;

import java.util.List;

import com.skcet.day4.model.Student;

public interface ApiService {

	public boolean addStudent(Student student);
	public List<Student> getStudent();
	public boolean deleteStudent(Long id,Student student);
	public boolean updateStudent(Student student);

}
