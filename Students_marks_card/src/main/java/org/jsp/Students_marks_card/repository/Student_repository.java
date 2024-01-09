package org.jsp.Students_marks_card.repository;

import java.util.List;

import org.jsp.Students_marks_card.dto.StudentDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface Student_repository extends JpaRepository<StudentDto, Integer>{

	List<StudentDto> findByMob(long mob);
	
	@Query(value = "select x from Student x where percentage>= 80")
	List<StudentDto> fetchaboveEighty();
	
	//@Query(value = "select x from Student x where x.sname=sname and x.percentage=percentage")StudentDto getBy(@Param ("sname") String sname,@Param ("percentage") Double percentage);
	@Query("select x from Student x where sname=?1 and percentage>=?2")
	List<StudentDto> findByNameandPercentage(@Param("sname") String sname,@Param ("percentage") double percentage);

	
	@Query("select x from Student x where result=?1")
	List<StudentDto> fetchByResult(String result);
	
//	@Query("select x from Student x where x.sid=sid")StudentDto getById(@Param ("sid") int sid);
//	List<StudentDto> fetchaboveEighy();
	
}
