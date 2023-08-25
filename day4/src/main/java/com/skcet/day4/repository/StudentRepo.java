package com.skcet.day4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skcet.day4.model.Student;



public interface StudentRepo extends JpaRepository<Student, Integer>{
	     

		

	

	public boolean existsById(int id);
}
