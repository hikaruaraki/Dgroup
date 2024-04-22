package team.D.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="test")
public class TestModel {
	
	 @Id
	 @Column(name="STUDENT_CD" ,length = 10, nullable = true)
	 private String studentcd;
	 
	 @Column(name="SUBJECT_CD" ,length = 10, nullable = true)
	 private String subjectcd;
	 
	 @Column(name="SCHOOL_CD" ,length = 10, nullable = true)
	 private String schoolcd;
	 
	 @Column(name="NO" ,length = 10, nullable = true)
	 private Integer no;
	 
	 @Column(name="POINT" ,length = 10, nullable = true)
	 private Integer point;
	 
	 @Column(name="CLASS_NUM" ,length = 10, nullable = true)
	 private String classnum;
}