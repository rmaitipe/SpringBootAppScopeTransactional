package com.services;

import com.pojo.Student;

public interface ISpringService {
	
	public void update1(Student bean);
	public void update2(Student bean);
	public Student find(int studentId);
	
}
