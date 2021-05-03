package com.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mongoRepo.StudentRepository;
import com.pojo.Student;

@Service
public class SpringService implements ISpringService {
	
	@Autowired
	StudentRepository repo;
	
	@Transactional
	public void update1(Student student){
		student.setDescription("update1 Modified using Autowired service");
		student.setModified(true);
		repo.save(student);
	}
	
	@SuppressWarnings("null")
	@Transactional
	public void update2(Student student){
		student.setDescription("update2 Modified using Autowired service");
		student.setModified(true);
		repo.save(student);
		String s1 = null;
		System.out.println(s1.length());
	}

	public Student find(int studentId){
		Optional<Student> opt =repo.findById(studentId);
		if (opt.isPresent()) {
			return repo.findById(studentId).get();
		} else {
			return null;
		}
	}
}
