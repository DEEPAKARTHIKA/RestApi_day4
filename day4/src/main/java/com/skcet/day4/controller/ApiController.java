package com.skcet.day4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.skcet.day4.model.Student;
import com.skcet.day4.service.ApiService;

@RestController
@RequestMapping("api/v1/student")
public class ApiController {

       @Autowired
       private ApiService apiservice;
       
       @GetMapping("/getStu")
       public ResponseEntity<List<Student>> getStuent(){
    	   return ResponseEntity.status(200).body(apiservice.getStudent());
       }
       
       @PostMapping("/addStu")
       public ResponseEntity<String> addStudent(@RequestBody Student student){
      	 boolean dataSaved=apiservice.addStudent(student);
      	 if(dataSaved) {
      		 return ResponseEntity.status(200).body("student added successfully");
      	 }
      	 else {
      		 return ResponseEntity.status(404).body("not added");
      	 }
       }
       
       @PutMapping("/updateStu")
	     public ResponseEntity<String>updateStudent(@RequestBody Student student){
	    	 boolean userData=apiservice.updateStudent(student);
	    	 if(!userData) {
	    		 return ResponseEntity.status(200).body("student updated successfully");
	    	 }
	    	 else {
	    		 return ResponseEntity.status(404).body("No record found to be updated");
	    	 }
	     }
	     @DeleteMapping("/deleteStu")
	 	public ResponseEntity<String> deleteEvent(@RequestParam Long id,@RequestBody Student student){
	 		boolean userDeleted =apiservice.deleteStudent(id,student);
	 		if(userDeleted) { 
	 			return ResponseEntity.status(200).body("User deleted successfully");
	 		} else {
	 			return ResponseEntity.status(404).body("No record found to be updated");
	 		}
	 	}
}

