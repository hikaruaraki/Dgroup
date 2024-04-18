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
	 private Long id;
	
	@Column(length = 10, nullable = true)
	 private String schoolcd;
	 
	 @Column(length = 10, nullable = true)
	 private String pw;
	 
	 @Column(length = 10, nullable = true)
	 private String name;
}