package org.jsp.Students_marks_card.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.Students_marks_card.dto.StudentDto;
import org.jsp.Students_marks_card.repository.Student_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {

	@Autowired
	Student_repository student_repository;
	
	public StudentDto saveStudent(StudentDto studentDto) {
		StudentDto studentDto2=student_repository.save(studentDto);
		return studentDto2;
	}

	public List<StudentDto> saveStudents(List<StudentDto> studentlist) {
		List<StudentDto> studentlist1=student_repository.saveAll(studentlist);
		return studentlist1;
	}
	
	public StudentDto fetchById(int sid) {
		Optional<StudentDto> optional=student_repository.findById(sid);
		if(optional.isEmpty())
		{
			return optional.get();
		}
		else {
			 StudentDto studentDto=optional.get();
			 return studentDto;
		}
	}

	public List<StudentDto> fetchByMob(long mob) {
		List<StudentDto> list=student_repository.findByMob(mob);
		if(list.isEmpty())
		{
			return list;
		}
		else {
			return list;
		}
	}

	public List<StudentDto> fetchAboveEighty() {
		List<StudentDto> list =student_repository.fetchaboveEighty();
		if(list.isEmpty())
		{
			return list;
		}
		else {
			return list;
		}
		
	}

	public List<StudentDto> fetchByNamePercentage(String sname, double percentage) {
		List<StudentDto> list= student_repository.findByNameandPercentage(sname,percentage);
		if(list.isEmpty())
		{
			return list;
		}
		else {
			return list;
		}
		
	}

	public List<StudentDto> fetchAll() {
		// TODO Auto-generated method stub
		List<StudentDto> list=student_repository.findAll();
		
		if(list.isEmpty())
		{
			return list;
		}
		else {
			return list;
		}
	}

	public List<StudentDto> fetchByResult(String result) {
		List<StudentDto> list=student_repository.fetchByResult(result);
		
		if(list.isEmpty())
		{
			return list;
		}
		else {
			return list;
		}
	}

	public boolean deleteByid(int sid) {
	Optional<StudentDto> studentDto=student_repository.findById(sid);
	if(studentDto.isEmpty())
	{
		return false;
	}
	else {
		 student_repository.deleteById(sid);
		return true;
	}

	
}

	public void deleteAll() {
		student_repository.deleteAll();
		
	}
}
