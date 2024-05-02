package team.D.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team.D.model.TestModel;

@Repository
public interface TestRepository extends JpaRepository<TestModel, Long> {

	List<TestModel> findBySchoolCd(String schoolCd);

}