package org.jsp.Students_marks_card.controller;

import java.util.List;

import org.jsp.Students_marks_card.dto.StudentDto;
import org.jsp.Students_marks_card.helper.ResponseStructure;
import org.jsp.Students_marks_card.repository.Student_repository;
import org.jsp.Students_marks_card.service.Student_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Student_controller {
	
	@Autowired
	Student_service student_service;
	
	
	
	@PostMapping("student")
	@ResponseBody
	public ResponseStructure<StudentDto> savestudent(@RequestBody StudentDto studentDto) 
	{
//		return studentDto;
		ResponseStructure<StudentDto> responseStructure=student_service.saveStudent(studentDto);
		return responseStructure;
		
	}
	
	
	
	
	@PostMapping("students")
	@ResponseBody
	public ResponseStructure<List<StudentDto>> savestudents(@RequestBody List<StudentDto> studentlist) 
	{

		
		return student_service.saveStudents(studentlist);
		
	}
	
	@GetMapping("student/{sid}")
	@ResponseBody
	public ResponseStructure<StudentDto> fetchById(@PathVariable  ("sid")int sid) {
		return student_service.fetchById(sid);
	}
	
	@GetMapping("student/mobile/{mob}")
	@ResponseBody
	public ResponseStructure<List<StudentDto>> fetchbyMob(@PathVariable ("mob") long mob) {
		return student_service.fetchByMob(mob);
	}
	
	@GetMapping("student/per")
	@ResponseBody
	public ResponseStructure<List<StudentDto>> percentage()
	{
		return student_service.fetchaboveEighty();
	}
	
	@GetMapping("student/{sname}/{percentage}")
	@ResponseBody
	public ResponseStructure<List<StudentDto>> name(@PathVariable ("sname") String sname,@PathVariable ("percentage") double percentage) {
		return student_service.fetchByNamePercentage(sname,percentage);
	}
	
	@GetMapping("Allstudents")
	@ResponseBody
	public ResponseStructure<List<StudentDto>> fetchAll()
	{
		return student_service.fetchAll();
	}
	
	@GetMapping("student/result/{result}")
	@ResponseBody
	public ResponseStructure<List<StudentDto>> fetchByResult(@PathVariable ("result") String result)
	{
		return student_service.fetchByResult(result);
	}
	
	@PutMapping("student/editt")
	@ResponseBody
	public ResponseStructure<StudentDto> edit(@RequestBody StudentDto studentDto)
	{
		return student_service.editStudent(studentDto);
	}
	@DeleteMapping("student/delete/{sid}")
	@ResponseBody
	public ResponseStructure<StudentDto> update(@PathVariable ("sid") int sid)
	{
		return student_service.deleteStudent(sid);
	}
	
	@DeleteMapping("student/deleteAll")
	@ResponseBody
	public ResponseStructure<StudentDto> name() {
		return student_service.deleteAll();
	}
}
