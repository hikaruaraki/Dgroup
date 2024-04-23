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
<<<<<<< HEAD
@Table(name = "STUDENTTABLE")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
=======
@Table(name="studenttable")
public class StudentModel{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column
	 private Long ID;
	 
	 @Column(length = 10, nullable = true)
	 private String NO;
	 
	 @Column(length = 10, nullable = true)
	 private String NAME;
	 
	 @Column(name="ENT_YEAR",length = 10, nullable = true)
	 private Integer entYear;
	 
	 @Column(name="CLASS_NUM",length = 3, nullable = true)
	 private String classNum;
	 
	 @Column(name="IS_ATTEND",nullable = true)
	 private Boolean isAttend;
	 
	 @Column(name="SCHOOL_CD",length = 3, nullable = true)
	 private String schoolCd;
>>>>>>> branch 'master' of https://github.com/hikaruaraki/Dgroup.git

    @Column(name = "NO", nullable = false, length = 10, unique = true)
    private String no;

    @Column(name = "NAME", length = 10)
    private String name;

    @Column(name = "ENT_YEAR")
    private Integer entyear;

    @Column(name = "CLASS_NUM", length = 3)
    private String classnum;

    @Column(name = "IS_ATTEND")
    private Boolean isattend;

    @Column(name = "SCHOOL_CD", length = 3)
    private String schoolCd;

 // ゲッターとセッター
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEntYear() {
        return entyear;
    }

    public void setEntYear(Integer entyear) {
        this.entyear = entyear;
    }

    public String getClassNum() {
        return classnum;
    }

    public void setClassNum(String classnum) {
        this.classnum = classnum;
    }

    public Boolean getIsAttend() {
        return isattend;
    }

    public void setIsAttend(Boolean isattend) {
        this.isattend = isattend;
    }

    public String getSchoolCd() {
        return schoolCd;
    }

    public void setSchoolCd(String schoolcd) {
        this.schoolCd = schoolcd;
    }

}
