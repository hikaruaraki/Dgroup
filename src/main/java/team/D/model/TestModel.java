package team.D.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="testtable")
public class TestModel {
	
	 @Id
	 @Column(length = 10, nullable = true)
	 private String STUDENT_CD;
	 
	 @Column(length = 10, nullable = true)
	 private String SUBJECT_CD;
	 
	 @Column(length = 10, nullable = true)
	 private String SCHOOL_CD;
	 
	 @Column(length = 10, nullable = true)
	 private Integer NO;
	 
	 @Column(length = 10, nullable = true)
	 private Integer POINT;
	 
	 @Column(length = 10, nullable = true)
	 private String CLASS_NUM;
}