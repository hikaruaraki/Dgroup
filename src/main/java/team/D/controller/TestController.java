package team.D.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import team.D.model.StudentModel;
import team.D.model.SubjectModel;
import team.D.model.TeacherModel;
import team.D.model.TestModel;
import team.D.service.StudentService;
import team.D.service.SubjectService;
import team.D.service.TestService;






@Controller
public class TestController{
	
	@Autowired
	private TestService  testService;
	@Autowired
	private StudentService  studentService;
	@Autowired
	private SubjectService  subjectService;	
	
	  public TestController(TestService testservice) {
		  this.testService = testservice;
	  }
	  

		  @GetMapping("/test")
		  public String getAllStudents(Model model, @AuthenticationPrincipal TeacherModel teacher, @AuthenticationPrincipal StudentModel student, @AuthenticationPrincipal SubjectModel subject) {
		      // 学校コード
		      String schoolCd = teacher.getSchoolCd();
		      List<TestModel> students = testService.getAllStudentsBySchoolCd(schoolCd);
		      model.addAttribute("students", students);
	
		    if (student != null) {
		        // Studentmodel
		        Integer entyear = student.getEntYear();
		        List<StudentModel> studentList = studentService.getStudentEntYear(entyear);
		        model.addAttribute("student", studentList);
		    }
	
		      // SubjectModel
		      List<SubjectModel> subjectModel = subjectService.getAllSubjectBySchoolCd(schoolCd);
		      System.out.println(subjectModel);
		      model.addAttribute("subjectModel", subjectModel);
		      return "test/test";
		  }

		
//		@PostMapping("/test")
//	    public String getFilteredStudents(
//	            @RequestParam(name= "entYear" , required = false) Integer entYear,
//	            @RequestParam(name= "classNum" , required = false) String classNum,
////	            @RequestParam(name= "isAttend" , required = false) Boolean isAttend,
//	            Model model) {
//			
//			if(classNum == ""){
//				classNum = null;
//			}
//		model.addAttribute("list", testService.searchStudents(entYear,classNum));
//			//controllerのline31のlistと一緒
//			//listはtemplateでもともと指定してるものに合わせるline114
//	        return "test/test";
//	    }
		

}