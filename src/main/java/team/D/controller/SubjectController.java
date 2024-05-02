package team.D.controller;


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
import team.D.model.SubjectModel;
import team.D.model.TeacherModel;
import team.D.service.SubjectService;

@Controller
public class SubjectController{
	
	@Autowired
	private SubjectService  subjectService;
	
	  public SubjectController(SubjectService subjectservice) {
		  this.subjectService = subjectservice;
				  
	  }
	
	@GetMapping("/subject")
		public String subject(Model model) {
			model.addAttribute("sub",this.subjectService.getSubjectModelList());
			return "sub/subject";
		}
	
//  科目情報入力
	@GetMapping("/subject/nyuryoku")
	public ModelAndView sub(SubjectModel subjectmodel, ModelAndView model, @AuthenticationPrincipal UserDetails user) {
	    model.addObject("subjectmodel", subjectmodel);
	    model.setViewName("sub/nyuryoku");
	    if (user instanceof TeacherModel) {
	        TeacherModel teacher = (TeacherModel) user;
	        String schoolCd = teacher.getSchoolCd();
	        model.addObject("schoolCd", schoolCd);
	    } else {
	        // ユーザーが TeacherModel でない場合の処理
	    }
	    return model;
	}

	@PostMapping("/subject/nyuryoku")
	public String complat(@Validated @ModelAttribute @NonNull SubjectModel subjectmodel, RedirectAttributes result,
			ModelAndView model, RedirectAttributes redirectAttributes) {
		try {
			this.subjectService.save(subjectmodel);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "sub/complete";
}
	
	   // 科目の変更フォームを表示
  @GetMapping("/subject/update")
  public String showUpdateSubjectForm(@RequestParam Long id, Model model) {
      SubjectModel subject = subjectService.getById(id);
      model.addAttribute("subject", subject);
      return "sub/change";
  }

  // 科目情報の変更
  @PostMapping("/subject/update")
  public String updateSubject(@ModelAttribute("subject") SubjectModel subjectModel) {
      subjectService.update(subjectModel);
      return "redirect:/subject";
  }
  
  @GetMapping("/subject/delete")
  public String delet(Model model,Long id) {
  	this.subjectService.delete(id);
  	return "sub/delete";
  }
}