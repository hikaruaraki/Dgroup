package team.D.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import team.D.model.TestModel;
import team.D.service.StudentService;
import team.D.service.TestService;






@Controller
public class TestController{
	
	@Autowired
	private TestService  TestService;
	@Autowired
	private StudentService  StudentService;
	
	  public TestController(TestService testservice) {
		  this.TestService = testservice;
				  
	  }

		@GetMapping("/test")
		public String student(Model model) {
			List<TestModel> list2 = TestService.getTestModelList();
			model.addAttribute("list2",list2);
			return "test/test";
		}
		
		@PostMapping("/test")
	    public String getFilteredStudents(
	            @RequestParam(name= "entYear" , required = false) Integer entYear,
	            @RequestParam(name= "classNum" , required = false) String classNum,
	            @RequestParam(name= "isAttend" , required = false) Boolean isAttend,
	            Model model) {
			
			if(classNum == ""){
				classNum = null;
			}
			model.addAttribute("list2", StudentService.searchStudents(entYear,classNum,isAttend));
			//controllerのline31のlistと一緒
			//listはtemplateでもともと指定してるものに合わせるline114
	        return "test/test";
	    }
		
    //成績入力
	@GetMapping("/test/nyuryoku")
	public ModelAndView add(TestModel testmodel, ModelAndView model) {
		model.addObject("testmodel", testmodel);
		model.setViewName("test_nyuryoku");
		return model;
	}
//
	@PostMapping("/test/nyuryoku")
	public String complate(@Validated @ModelAttribute @NonNull TestModel testmodel, RedirectAttributes result,
			ModelAndView model, RedirectAttributes redirectAttributes) {
		try {
			this.TestService.save(testmodel);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "complete";
}
	
//	   // 生徒の変更フォームを表示
//    @GetMapping("/student/update")
//    public String showUpdateStudentForm(@RequestParam Long id, Model model) {
//        StudentModel student = StudentService.getById(id);
//        model.addAttribute("student", student);
//        return "change";
//    }
// 
//    // 生徒情報の変更
//    @PostMapping("/test/update")
//    public String updateStudent(@ModelAttribute("student") StudentModel studentModel) {
//        StudentService.update(studentModel);
//        return "redirect:/student";
//    }
//    
//    //学生情報の削除
//    @GetMapping("/test/delete")
//    public String deleteStudent(Model model,StudentModel studentmodel) {
//    	StudentService.delete(studentmodel.getId());
//    	return "/student";
//    }
//    
//    @PostMapping("/test/delete")
//    public String delete(Model model,StudentModel studentmodel) {
//    	this.StudentService.delete(studentmodel.getId());
//    	return "/student";
//    }
    

}