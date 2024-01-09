package org.jsp.Students_marks_card.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "Student")
@Component
public class StudentDto {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	int sid;
	
	String sname;
	
	
	
	 long mob;
	 
	 int math_marks;
	 
	 int science_marks;
	 
	 int english_marks;
	 
	 double percentage;
	 
	 String result;
	 
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public long getMob() {
		return mob;
	}

	public void setMob(long mob) {
		this.mob = mob;
	}

	public int getMath_marks() {
		return math_marks;
	}

	public void setMath_marks(int math_marks) {
		this.math_marks = math_marks;
	}

	public int getScience_marks() {
		return science_marks;
	}

	public void setScience_marks(int science_marks) {
		this.science_marks = science_marks;
	}

	public int getEnglish_marks() {
		return english_marks;
	}

	public void setEnglish_marks(int english_marks) {
		this.english_marks = english_marks;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	 
	
}
