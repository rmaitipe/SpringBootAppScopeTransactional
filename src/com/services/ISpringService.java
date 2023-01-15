package com.services;

import com.pojo.Student;

import java.util.List;

public interface ISpringService {
	
	public void update1(Student bean);
	public void update2(Student bean);
	public Student find(int studentId);
	public List<Student> findAll();
	
}
