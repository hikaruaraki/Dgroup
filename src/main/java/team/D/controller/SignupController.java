package team.D.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.NonNull;
import team.D.model.TeacherModel;
import team.D.service.TeacherService;

@Controller
public class SignupController{
	
	
	@Autowired
	private TeacherService  TeacherService;
	
	@GetMapping("/signup")
	public String i(Model model) {
		model.addAttribute("signup", new TeacherModel());
		return "sign/signup";
}
	
	@PostMapping("/signup")
	public String c(@Validated @ModelAttribute @NonNull TeacherModel usermodel, BindingResult result,
			ModelAndView model, RedirectAttributes redirectAttributes) {
		try {
			this.TeacherService.save(usermodel);
			redirectAttributes.addFlashAttribute("exception", "");

		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:login";
}
}