package team.D.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team.D.model.TestModel;

@Repository
public interface TestRepository extends JpaRepository<TestModel, Long> {

}