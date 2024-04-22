package team.D.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team.D.model.TestModel;

@Repository
<<<<<<< HEAD
public interface TestRepository extends JpaRepository<TestModel, String> {
=======
public interface TestRepository extends JpaRepository<TestModel, Long > {
	
>>>>>>> branch 'master' of https://github.com/hikaruaraki/Dgroup.git
}
