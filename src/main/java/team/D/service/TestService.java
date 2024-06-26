package team.D.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import team.D.model.StudentModel;
import team.D.model.TestModel;
import team.D.repository.StudentRepository;
import team.D.repository.TestRepository;

@Service
@Transactional
public class TestService{

	@Autowired
	private TestRepository testrepository;
	@Autowired
	private StudentRepository studentrepository;

	/**
	 * アドレス帳一覧の取得
	 * @return List<AddressBook>
	 */
public List<TestModel> getTestModelList() {
	    List<TestModel> entityList = this.testrepository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  AddressBook
	 */
	public TestModel get(@NonNull Long index) {
		TestModel testmodel = this.testrepository.findById(index).orElse(new TestModel());
		return testmodel;
	}

	/**
	 * アドレス帳データの保存
	 * @param AddressBook addressBook
	 */
	public void save(@NonNull TestModel testmodel) {
		System.out.println(testmodel);
		this.testrepository.save(testmodel);
	}

	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.testrepository.deleteById(index);
	}
	
	  // 生徒情報変更メソッド
    public void update(TestModel studentModel) {
    	testrepository.save(studentModel);
    }
 
    // 生徒IDで生徒情報を取得するメソッド
    public TestModel getById(Long id) {
        Optional<TestModel> optionalStudent = testrepository.findById(id);
        return optionalStudent.orElse(null);
    }

	public List<TestModel> getAllStudentsBySchoolCd(String schoolCd) {
		return testrepository.findBySchoolCd(schoolCd);
	}

	// 成績の一覧表示
    // 学生テーブルから入学年度とクラス番号で絞り込み
    public List<StudentModel> Test(Integer entYear, String classNum){
        return studentrepository.findByEntYearAndClassNum(entYear, classNum);
    }
    
    /* 成績の登録 */
    public void saveTest(TestModel testModel) {
        testrepository.save(testModel);
    }
    
	public List<TestModel> findBySchoolCd(String schoolCd) {
		return testrepository.findBySchoolCd(schoolCd);
	}



 }

