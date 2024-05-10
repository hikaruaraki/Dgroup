package team.D.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="test")
	public class TestModel {
		
		 @Id
		 @GeneratedValue(strategy = GenerationType.IDENTITY)
		 @Column
		 private Long Id;
		
		 @Column(name="STUDENT_CD" ,length = 10, nullable = true)
		 private String studentCd;
		 
		 @Column(name="SUBJECT_CD" ,length = 10, nullable = true)
		 private String subjectCd;
		 
		 @Column(name="SCHOOL_CD" ,length = 10, nullable = true)
		 private String schoolCd;
		 
		 @Column(name="NO" ,length = 10, nullable = true)
		 private Integer no;
		 
		 @Column(name="POINT" ,length = 10, nullable = true)
		 private Integer point;
		 
		 @Column(name="CLASS_NUM" ,length = 10, nullable = true)
		 private String classNum;

		}
