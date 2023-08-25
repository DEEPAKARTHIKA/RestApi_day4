package com.skcet.day4.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcet.day4.model.Student;
import com.skcet.day4.service.ApiService;



@Service
public class ApiServiceImpl implements ApiService {
	
	      
		@Autowired
		private StudentRepo studentRepo;
		
		@Override
		public boolean addStudent(Student student) {
			boolean StuExists=studentRepo.existsById(student.getId());
			if(!StuExists) {
				studentRepo.save(student);
				return true;
			}
			else {
				return false;
			}
		}
		
		@Override
		public List<Student> getStudent(){
			return studentRepo.findAll();
		}

		

		@Override
		public boolean updateStudent(Student student) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean deleteStudent(Long id, Student student) {
			// TODO Auto-generated method stub
			return false;
		}
			
}
