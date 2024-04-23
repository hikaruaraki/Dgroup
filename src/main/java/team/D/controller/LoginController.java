package team.D.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import team.D.model.TeacherModel;
//
//@Controller
//public class LoginController{
//	
//	@GetMapping("/login/")
//	public ModelAndView in(TeacherModel user ,ModelAndView model) {
//		model.addObject("login", user);
//		model.setViewName("login");
//		return model;
//}
//}






import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import team.D.model.TeacherModel;
import team.D.service.TeacherService;


@Controller
@RequestMapping("/")
public class LoginController {

	
	@Autowired
	private TeacherService  TeacherService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
    /**
     * ログイン画面へ遷移します.
     *
     * @return login.html
     */
    @RequestMapping(path = "/login")
 // 設定ファイルでログイン失敗時にはerror=tureを渡すようにしている。
//   ⇒コンソールに「ログインに失敗しました」と表示される。(ログイン成功時には何も表示されない。)
    public String showLogin(@RequestParam(required = false) String error, Model model) {
    	model.addAttribute("teacherModel",new TeacherModel());
        System.err.println("login error:" + error);
        if (error != null) {
            System.err.println("ログインに失敗しました。");
        }
        return "login/login";
    }	@GetMapping("/login")
	public ModelAndView in(TeacherModel teachermodel ,ModelAndView model) {
		model.addObject("login", teachermodel);
		model.setViewName("login/login");
		return model;
    }
    
    
    
//    // 先生登録ページの表示
//    @GetMapping("/signup/")
//    public String showTeacherForm(Model model) {
//        model.addAttribute("signup", new TeacherModel());
//        return "sign/signup";
//    }
// 
//    // 先生登録フォームの処理
//    @PostMapping("/signup/")
//    public String registerTeacher(@Validated @ModelAttribute @NonNull TeacherModel teacher, RedirectAttributes redirectAttributes) {
//        try {
//            // パスワードをハッシュ化してセット
////            String hashedPassword = passwordEncoder.encode(teacher.getPassword());
////            teacher.setPassword(hashedPassword);
//// 
//            this.TeacherService.save(teacher);
//            redirectAttributes.addFlashAttribute("successMessage", "先生の登録が完了しました。");
//        } catch (Exception e) {
//            redirectAttributes.addFlashAttribute("errorMessage", "先生の登録中にエラーが発生しました。");
//        }
//        return "redirect:/";
//    }
}