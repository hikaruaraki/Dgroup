package team.D.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team.D.model.TeacherModel;

@Repository
public interface LoginRepository extends JpaRepository<TeacherModel, Long> {

	TeacherModel findByIDEquals(String ID);
	
}