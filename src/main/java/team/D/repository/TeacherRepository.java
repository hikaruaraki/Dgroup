package team.D.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team.D.model.TeacherModel;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherModel, String> {
}
