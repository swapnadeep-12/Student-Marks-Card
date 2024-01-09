package org.jsp.Students_marks_card.service;

import java.util.List;

import org.jsp.Students_marks_card.dao.StudentDao;
import org.jsp.Students_marks_card.dto.StudentDto;
import org.jsp.Students_marks_card.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClient.ResponseSpec;

@Component
public class Student_service {
	
	@Autowired 
	StudentDao studentDao;
	
	
	
	public ResponseStructure<StudentDto> saveStudent(StudentDto studentDto) {
		double per=(studentDto.getEnglish_marks()+studentDto.getMath_marks()+studentDto.getScience_marks())/3.0;
		studentDto.setPercentage(per);
		if(per>=90)
		{
			studentDto.setResult("Distinction");
		}
		else if(per<90&&per>=60)
		{
			studentDto.setResult("Fistclass");
		}
		else {
			studentDto.setResult("Fail");
		}	
		
		
//		StudentDto studentDto2=studentDao.saveStudent(studentDto);
		ResponseStructure<StudentDto> responseStructure =new ResponseStructure<>();
		responseStructure.setMsg("data saving successfully");
		responseStructure.setStatus_code(HttpStatus.CREATED.value());
		responseStructure.setData(studentDao.saveStudent(studentDto));
		return responseStructure;
	}
	
	
	
	
	public ResponseStructure<List<StudentDto>> saveStudents(List<StudentDto> studentlist) {
		for (StudentDto studentDto : studentlist) {
			double per=(studentDto.getEnglish_marks()+studentDto.getMath_marks()+studentDto.getScience_marks())/3.0;
			studentDto.setPercentage(per);
			if(per>=90)
			{
				studentDto.setResult("Distinction");
			}
			else if(per<90&&per>=60)
			{
				studentDto.setResult("Fistclass");
			}
			else {
				studentDto.setResult("Fail");
			}
		}
		ResponseStructure<List<StudentDto>> responseStructure =new ResponseStructure<>();
		responseStructure.setMsg("data saving successfully");
		responseStructure.setStatus_code(HttpStatus.CREATED.value());
		responseStructure.setData(studentDao.saveStudents(studentlist));
		return responseStructure;
	}
	
	public ResponseStructure<StudentDto> fetchById(int sid) {
		StudentDto studentDto=studentDao.fetchById(sid);
		ResponseStructure<StudentDto> responseStructure =new ResponseStructure<>();
		if(studentDto==null)
		{
			responseStructure.setMsg("data not found");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setData(null);
		}
		else {
			responseStructure.setMsg("data found");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setData(studentDto);
		}
		
		return responseStructure;
		
	}
	
	public ResponseStructure<List<StudentDto>> fetchByMob(long mob) {
		List<StudentDto> list=studentDao.fetchByMob(mob);
		ResponseStructure<List<StudentDto>> responseStructure =new ResponseStructure<>();
		if(list.isEmpty())
		{
			responseStructure.setMsg("data not found");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setData(null);
		}
		else
		{
			responseStructure.setMsg("data found");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setData(list);
		}
		return responseStructure;
	}




	public ResponseStructure<List<StudentDto>> fetchaboveEighty() {
		List<StudentDto> list=studentDao.fetchAboveEighty();
		ResponseStructure<List<StudentDto>> responseStructure =new ResponseStructure<>();
		if(list.isEmpty())
		{
			responseStructure.setMsg("There is no Students who have 80%");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setData(null);
		}
		else
		{
			responseStructure.setMsg("data found");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setData(list);
		}
		return responseStructure;
	}




	public ResponseStructure<List<StudentDto>> fetchByNamePercentage(String sname, double percentage) {
		List<StudentDto> list=studentDao.fetchByNamePercentage(sname,percentage);
		ResponseStructure<List<StudentDto>> responseStructure =new ResponseStructure<>();
		if(list.isEmpty())
		{
			responseStructure.setMsg("There is no Students with name "+sname+" percentage "+percentage);
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setData(null);
		}
		else
		{
			responseStructure.setMsg("data found");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setData(list);
		}
		return responseStructure;
		
	}




	public ResponseStructure<List<StudentDto>> fetchAll() {
		List<StudentDto> list=studentDao.fetchAll();
		ResponseStructure<List<StudentDto>> responseStructure =new ResponseStructure<>();
		if(list.isEmpty())
		{
			responseStructure.setMsg("There is no Students");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setData(null);
		}
		else
		{
			responseStructure.setMsg("data found");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setData(list);
		}
		return responseStructure;
	}




	public ResponseStructure<List<StudentDto>> fetchByResult(String result) {
		List<StudentDto> list=studentDao.fetchByResult(result);
		ResponseStructure<List<StudentDto>> responseStructure =new ResponseStructure<>();
		if(list.isEmpty())
		{
			responseStructure.setMsg("There is no Student with "+result);
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setData(null);
		}
		else
		{
			responseStructure.setMsg("data found");
			responseStructure.setStatus_code(HttpStatus.CREATED.value());
			responseStructure.setData(list);
		}
		return responseStructure;
	}




	public ResponseStructure<StudentDto> editStudent(StudentDto studentDto) {
		double per=(studentDto.getEnglish_marks()+studentDto.getMath_marks()+studentDto.getScience_marks())/3.0;
		studentDto.setPercentage(per);
		if(per>=90)
		{
			studentDto.setResult("Distinction");
		}
		else if(per<90&&per>=60)
		{
			studentDto.setResult("Fistclass");
		}
		else {
			studentDto.setResult("Fail");
		}	
		
		
//		StudentDto studentDto2=studentDao.saveStudent(studentDto);
		ResponseStructure<StudentDto> responseStructure =new ResponseStructure<>();
		responseStructure.setMsg("data edited successfully");
		responseStructure.setStatus_code(HttpStatus.OK.value());
		responseStructure.setData(studentDao.saveStudent(studentDto));
		return responseStructure;
	}




	public ResponseStructure<StudentDto> deleteStudent(int sid) {
		ResponseStructure<StudentDto> responseStructure =new ResponseStructure<>();
		if(studentDao.deleteByid(sid))
		{
			responseStructure.setMsg("data deleted successfully");
			responseStructure.setStatus_code(HttpStatus.OK.value());
			return responseStructure;
		}
		else {
			responseStructure.setMsg("invalid id");
			responseStructure.setStatus_code(HttpStatus.OK.value());
			return responseStructure;
		}
	}




	public ResponseStructure<StudentDto> deleteAll() {
		ResponseStructure<StudentDto> responseStructure =new ResponseStructure<>();
		responseStructure.setMsg("data deleted successfully");
		responseStructure.setStatus_code(HttpStatus.OK.value());
		studentDao.deleteAll();
		return responseStructure;
	}
}
