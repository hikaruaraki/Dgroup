package team.D.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import team.D.model.SubjectModel;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectModel, Long> {
}
