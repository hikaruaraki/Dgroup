package team.D.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import team.D.model.StudentModel;
import team.D.model.TeacherModel;
import team.D.service.StudentService;





@Controller
public class MainController{
	
	@Autowired
	private StudentService  StudentService;
	
	  public MainController(StudentService studentservice) {
		  this.StudentService = studentservice;
				  
	  }
//	　トップページ表示
	  @GetMapping("/")
		public String index(Model model) {
			return "base";
		}
	  
	  //学生情報のページ表示
	  @GetMapping("/student")
	  public ModelAndView getAllStudents(ModelAndView model, @AuthenticationPrincipal TeacherModel teacher) {
	      String schoolCd = teacher.getSchoolCd();
	      List<StudentModel> students = StudentService.getAllStudentsBySchoolCd(schoolCd);
	      model.addObject("students", students);
	      model.setViewName("student");
	      return model;
	  }
		
	  //学生検索
		@PostMapping("/student")
	    public String getFilteredStudents(
	            @RequestParam(name= "entYear" , required = false) Integer entYear,
	            @RequestParam(name= "classNum" , required = false) String classNum,
	            @RequestParam(name= "isAttend" , required = false) Boolean isAttend,
	            Model model) {
			System.out.println(entYear +":"+ classNum +":"+ isAttend);
			if(classNum == ""){
				classNum = null;
			}
			model.addAttribute("students", StudentService.searchStudents(entYear,classNum, isAttend));
			//controllerのline31のlistと一緒
			//listはtemplateでもともと指定してるものに合わせるline114
	        return "student";
	    }
		
//    学生情報入力
		@GetMapping("/student/nyuryoku")
		public ModelAndView add(StudentModel studentmodel, ModelAndView model, @AuthenticationPrincipal UserDetails user) {
		    model.addObject("studentmodel", studentmodel);
		    model.setViewName("student_nyuryoku");
		    if (user instanceof TeacherModel) {
		        TeacherModel teacher = (TeacherModel) user;
		        String schoolCd = teacher.getSchoolCd();
		        model.addObject("schoolCd", schoolCd);
		    } else {
		        // ユーザーが TeacherModel でない場合の処理
		    }
		    return model;
		}

	@PostMapping("/student/nyuryoku")
	public String complate(@Validated @ModelAttribute @NonNull StudentModel studentmodel, RedirectAttributes result,
			ModelAndView model, RedirectAttributes redirectAttributes) {
		try {
			this.StudentService.save(studentmodel);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "complete";
}
	
	   // 生徒の変更フォームを表示
	@GetMapping("/student/update")
	public String showUpdateStudentForm(@RequestParam Long id, Model model, @AuthenticationPrincipal UserDetails user) {
	    // 学生IDを使用して学生情報を取得
	    StudentModel student = StudentService.getById(id);
	    model.addAttribute("student", student);
	    
	    // 教師の場合は学校コードを取得してモデルに追加
	    if (user instanceof TeacherModel) {
	        TeacherModel teacher = (TeacherModel) user;
	        String schoolCd = teacher.getSchoolCd();
	        model.addAttribute("schoolCd", schoolCd);
	    }
	    
	    return "change"; // 変更画面のビュー名を返す
	}

 
    // 生徒情報の変更
    @PostMapping("/student/update")
    public String updateStudent(@ModelAttribute("student") StudentModel studentModel) {
        StudentService.update(studentModel);
        return "redirect:/student";
    }
    
    //学生情報の削除
    @GetMapping("/student/delete")
    public String deleteStudent(Model model,StudentModel studentmodel) {
    	StudentService.delete(studentmodel.getId());
    	return "/student";
    }
    
    @PostMapping("/student/delete")
    public String delete(Model model,StudentModel studentmodel) {
    	this.StudentService.delete(studentmodel.getId());
    	return "/student";
    }
    

}