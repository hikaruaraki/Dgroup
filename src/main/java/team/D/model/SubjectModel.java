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
@Table(name="subjecttable")
public class SubjectModel {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column
	 private Long ID;
	
	@Column(length = 10, nullable = true)
	 private String SCHOOL_CD;
	 
	 @Column(length = 10, nullable = true)
	 private String CD;
	 
	 @Column(length = 10, nullable = true)
	 private String NAME;
}