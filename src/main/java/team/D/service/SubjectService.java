package team.D.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import team.D.model.SubjectModel;
import team.D.repository.SubjectRepository;

@Service
@Transactional
public class SubjectService {

	@Autowired
	private SubjectRepository subjectrepository;

	/**
	 * アドレス帳一覧の取得
	 * @return List<AddressBook>
	 */
	public List<SubjectModel> getSubjectModelList() {
	    List<SubjectModel> entityList = this.subjectrepository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  AddressBook
	 */
	public SubjectModel get(@NonNull Long index) {
		SubjectModel addressBook = this.subjectrepository.findById(index).orElse(new SubjectModel());
		return addressBook;
	}

	/**
	 * アドレス帳データの保存
	 * @param AddressBook addressBook
	 */
	public void save(@NonNull SubjectModel subjectmodel) {
		System.out.println(subjectmodel);
		this.subjectrepository.save(subjectmodel);
	}

	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.subjectrepository.deleteById(index);
	}
	
	  // 生徒情報変更メソッド
    public void update(SubjectModel studentModel) {
    	subjectrepository.save(studentModel);
    }
 
    // 生徒IDで生徒情報を取得するメソッド
    public SubjectModel getById(Long id) {
        Optional<SubjectModel> optionalStudent = subjectrepository.findById(id);
        return optionalStudent.orElse(null);
    }

	public List<SubjectModel> getSubjectAll() {
		return subjectrepository.findAll();
	}

}
