package team.D.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team.D.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
	 List<StudentModel> findByEntYearAndClassNumAndIsAttend(Integer entYear, String classNum, Boolean isAttend);

	    List<StudentModel> findByClassNumAndIsAttend(String classNum, Boolean isAttend);

	    List<StudentModel> findByClassNum(String classNum);

	    List<StudentModel> findByEntYearAndClassNum(Integer entYear, String classNum);

	    List<StudentModel> findByEntYearAndIsAttend(Integer entYear, Boolean isAttend);

	    List<StudentModel> findByEntYear(Integer entYear);

	    List<StudentModel> findByIsAttend(Boolean isAttend);

		List<StudentModel> findBySchoolCd(String schoolCd);
		

}

