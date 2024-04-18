package team.D.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team.D.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
}

