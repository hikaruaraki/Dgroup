package team.D.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import team.D.model.TeacherModel;
import team.D.repository.LoginRepository;
@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private LoginRepository LoginRepository; // ユーザモデルのRepository

	/**
	 * ユーザの検索を行う
	 */
	@Override
	public UserDetails loadUserByUsername(String ID) throws UsernameNotFoundException {
		System.out.println("serach name : " + ID);
		TeacherModel user = this.LoginRepository.findByIDEquals(ID); // emailで検索するので「EmailEquals」としている
		System.out.println(user.toString());
		return user;
	}

}
