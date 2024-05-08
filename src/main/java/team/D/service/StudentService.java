package team.D.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import team.D.model.StudentModel;
import team.D.repository.StudentRepository;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentRepository studentrepository;

	/**
	 * アドレス帳一覧の取得
	 * @return List<AddressBook>
	 */
	public List<StudentModel> getStudentModelList() {
	    List<StudentModel> entityList = this.studentrepository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  AddressBook
	 */
	public StudentModel get(@NonNull Long index) {
		StudentModel addressBook = this.studentrepository.findById(index).orElse(new StudentModel());
		return addressBook;
	}

	/**
	 * アドレス帳データの保存
	 * @param AddressBook addressBook
	 */
	@Transactional
	public void save(@NonNull StudentModel studentmodel) {
		System.out.println(studentmodel);
		this.studentrepository.save(studentmodel);
	}

	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.studentrepository.deleteById(index);
	}
	
	  // 生徒情報変更メソッド
    public void update(StudentModel studentModel) {
        studentrepository.save(studentModel);
    }
 
    // 生徒IDで生徒情報を取得するメソッド
    public StudentModel getById(Long id) {
        Optional<StudentModel> optionalStudent = studentrepository.findById(id);
        return optionalStudent.orElse(null);
    }
    
    public List<StudentModel> searchStudents(Integer entYear, String classNum, Boolean isAttend) {
        if (entYear != null && classNum != null && isAttend != null) {
        	System.out.println(entYear + classNum + isAttend);
            return this.studentrepository.findByEntYearAndClassNumAndIsAttend(entYear, classNum, isAttend); // 全ての条件を指定
        } if (entYear != null && classNum != null) {
            return this.studentrepository.findByEntYearAndClassNum(entYear, classNum); // 入学年度とクラス番号を指定
        } else if (entYear != null && isAttend != null) {
            return this.studentrepository.findByEntYearAndIsAttend(entYear, isAttend); // 入学年度と出席状況を指定
        } else if (classNum != null && isAttend != null) {
            return this.studentrepository.findByClassNumAndIsAttend(classNum, isAttend); // クラス番号と出席状況を指定
        } else if (entYear != null) {
            return this.studentrepository.findByEntYear(entYear); // 入学年度のみを指定
        } else if (classNum != null) {
            return this.studentrepository.findByClassNum(classNum); // クラス番号のみを指定
        } else if (isAttend != null) {
            return this.studentrepository.findByIsAttend(isAttend); // 出席状況のみを指定
        } else {
            return this.studentrepository.findAll(); // すべての学生を取得
        }
    }


	public List<StudentModel> getAllStudentsBySchoolCd(String schoolCd) {
		return studentrepository.findBySchoolCd(schoolCd);
	}

	public List<StudentModel> getStudentEntYear(String schoolCd) {
		return studentrepository.findBySchoolCd(schoolCd);
	}

}
