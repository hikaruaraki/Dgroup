package team.D.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
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
	  
	  	//成績登録のページ
	  	@GetMapping("/test")
		public String getAllStudents(Model model, @AuthenticationPrincipal TeacherModel teacher, @AuthenticationPrincipal StudentModel student, @AuthenticationPrincipal SubjectModel subject) {
		      // 学校コード
	  		  TestModel testmodel = new TestModel();
 		      String schoolCd = teacher.getSchoolCd();
		      List<TestModel> students = testService.getAllStudentsBySchoolCd(schoolCd);
		      model.addAttribute("tests", students);
		      model.addAttribute("testmodel",testmodel);
	
		      // Studentmodel
		      List<StudentModel> studentList = studentService.getStudentEntYear(schoolCd);
		      model.addAttribute("student", studentList);
		    
		      // SubjectModel
		      List<SubjectModel> subjectCd = subjectService.getAllSubjectBySchoolCd(schoolCd);
		      model.addAttribute("subjectCd", subjectCd);
		      return "test/test";
		  }

		//検索
		@PostMapping("/test")
	    public String getFilteredStudents(
	            @RequestParam(name= "entYear" , required = false) Integer entYear,
	            @RequestParam(name= "classNum" , required = false) String classNum,
	            @RequestParam(name= "subjectCd" , required = false) String subjectCd,
	            @RequestParam(name= "no" , required = false) String no,
	            Model model) {
			System.out.println(entYear);
			System.out.println(classNum);
			System.out.println(subjectCd);	
			System.out.println(no);
			
			model.addAttribute("selectsubjectCd",subjectCd);
			model.addAttribute("selectno",no);
			model.addAttribute("test",testService.Test(entYear,classNum));
	        return "test/test";
	    }
		
		 // 成績登録
	    @PostMapping("/test/save")
	    public String saveTest(Model model, @ModelAttribute("TestModel") TestModel testModel,
	            HttpServletRequest request) {
	        // フォームから受け取った値を受け取る
	        // カンマ区切りで配列に
	        String[] studentNos = testModel.getStudentCd().split(",");
	        String[] schoolCds = testModel.getSchoolCd().split(",");
	        String[] subjectCds = testModel.getSubjectCd().split(",");
	        String[] classNums = testModel.getClassNum().split(",");
	        String[] nos = request.getParameterValues("no");
	        String[] points = request.getParameterValues("point");
	        // 配列の個数文繰り返し
	        // 配列の個数分繰り返し個別に保存 ➡ それぞれカンマ区切りのi番目を保存
	        for(int i = 0; studentNos.length > i; i++) {
	            System.out.println(i);
	            TestModel newTestModel = new TestModel();
	            newTestModel.setStudentCd(studentNos[i]);
	            newTestModel.setSchoolCd(schoolCds[i]);
	            newTestModel.setSubjectCd(subjectCds[i]);
	            newTestModel.setClassNum(classNums[i]);
	            newTestModel.setNo(Integer.parseInt(nos[i]));
	            newTestModel.setPoint(Integer.parseInt(points[i]));//intに変換
	            // 保存されるnewTestModelの確認
	            System.out.println(newTestModel);
	            testService.saveTest(newTestModel);
	        }
	        return "redirect:/complete";
	    }
	    //登録後遷移先
		  @GetMapping("/complete")
			public String index(Model model) {
				return "test/complete";
			}
		  
		//成績参照ページ
		  @GetMapping("/reference")
		  public String getAllReference(Model model, @AuthenticationPrincipal TeacherModel teacher, @AuthenticationPrincipal StudentModel student, @AuthenticationPrincipal SubjectModel subject) {
		      // 学校コード
	  		  TestModel testmodel = new TestModel();
 		      String schoolCd = teacher.getSchoolCd();
		      List<TestModel> allstudent = testService.getAllStudentsBySchoolCd(schoolCd);
		      model.addAttribute("tests", allstudent);
		      model.addAttribute("testmodel",testmodel);
	
		      // Studentmodel
		      List<StudentModel> studentList = studentService.getStudentEntYear(schoolCd);
		      model.addAttribute("student", studentList);
		    
		      // SubjectModel
		      List<SubjectModel> subjectCd = subjectService.getAllSubjectBySchoolCd(schoolCd);
		      model.addAttribute("subjectCd", subjectCd);
		      
		      System.out.println(testmodel);
		      return "test/reference";
		  }
		  
		  @PostMapping("/reference")
		  public String getReference(
		            @RequestParam(name= "entYear" , required = false) Integer entYear,
		            @RequestParam(name= "classNum" , required = false) String classNum,
		            @RequestParam(name= "subjectCd" , required = false) String subjectCd,
		            @RequestParam(name= "studentCd" , required = false) String studentCd,
		            @RequestParam(name= "point" , required = false) String point,
		            
				  Model model) {
			  System.out.println(entYear);
			  System.out.println(classNum);
			  System.out.println(subjectCd);
			  System.out.println(studentCd);
			  System.out.println(point);
			  
			  
			  model.addAttribute("studentCd",studentCd);
			  model.addAttribute("point",point);
			  model.addAttribute("studenttest",testService.Test(entYear,classNum));
			  model.addAttribute("selectsubjectCd",subjectCd);
			  return "test/reference";
		  }
		  
		  
}

