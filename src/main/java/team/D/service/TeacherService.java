package team.D.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import team.D.model.TeacherModel;
import team.D.repository.TeacherRepository;

@Service
@Transactional
public class TeacherService {

	@Autowired
	private TeacherRepository teacherrepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * アドレス帳一覧の取得
	 * @return List<AddressBook>
	 */
	public List<TeacherModel> getTeacherModelList() {
	    List<TeacherModel> entityList = this.teacherrepository.findAll();
	    return entityList;
	}

	/**
	 * 詳細データの取得
	 * @param @NonNull Long index
	 * @return  AddressBook
	 */
	public TeacherModel get(@NonNull Long index) {
		TeacherModel addressBook = this.teacherrepository.findById(index).orElse(new TeacherModel());
		return addressBook;
	}


	/**
	 * アドレス帳データの削除
	 * @param @NonNull Long index
	 */
	public void delete(@NonNull Long index) {
		this.teacherrepository.deleteById(index);
	}
	
    public void save(@NonNull TeacherModel teacher) {
    	System.out.println(teacher);
    	teacher.setPassword(this.passwordEncoder.encode(teacher.getPassword()));
        this.teacherrepository.save(teacher);
    }
	
}
