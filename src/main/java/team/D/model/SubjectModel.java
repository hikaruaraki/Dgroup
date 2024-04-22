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
	
	@Column(name="SCHOOL_CD",length = 10, nullable = true)
	 private String schoolcd;
	 
<<<<<<< HEAD
	 @Column(name="CD" ,length = 10, nullable = true)
=======
	 @Column(name="CD",length = 10, nullable = true)
>>>>>>> branch 'master' of https://github.com/hikaruaraki/Dgroup.git
	 private String cd;
	 
<<<<<<< HEAD
	 @Column(name="NAME" ,length = 10, nullable = true)
=======
	 @Column(name="NAME",length = 10, nullable = true)
>>>>>>> branch 'master' of https://github.com/hikaruaraki/Dgroup.git
	 private String name;
}