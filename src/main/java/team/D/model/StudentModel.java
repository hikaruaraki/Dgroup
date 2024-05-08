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
@Table(name="studenttable")
public class StudentModel{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column
	 private Long Id;
	 
	 @Column(name="NO",length = 10, nullable = true)
	 private String no;
	 
	 @Column(name="NAME",length = 10, nullable = true)
	 private String name;
	 
	 @Column(name="ENT_YEAR",length = 10, nullable = true)
	 private Integer entYear;
	 
	 @Column(name="CLASS_NUM",length = 3, nullable = true)
	 private String classNum;
	 
	 @Column(name="IS_ATTEND",nullable = true)
	 private Boolean isAttend;
	 
	 @Column(name="SCHOOL_CD",length = 3, nullable = true)
	 public String schoolCd;

	 }
	 

