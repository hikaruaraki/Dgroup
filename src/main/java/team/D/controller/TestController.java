//package team.D.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import io.micrometer.common.lang.NonNull;
//import team.D.model.TestModel;
//import team.D.service.TestService;
//
//@Controller
//public class TestController{
//	
//	@Autowired
//	private TestService  TestService;
//	
//	@GetMapping("/test")
//	public String test(Model model) {
//		model.addAttribute("test",this.TestService.getTestModelList());
//		return "test/test";
//	}
//
////科目情報入力
//		@GetMapping("/test/nyuryoku")
//		public ModelAndView testnyuryoku(TestModel testmodel, ModelAndView model) {
//		model.addObject("testmodel", testmodel);
//		model.setViewName("test/nyuryoku");
//		return model;
//}
//
//		@PostMapping("/test/nyuryoku")	
//		public String testpost(@Validated @ModelAttribute @NonNull TestModel testmodel, RedirectAttributes result,
//			ModelAndView model, RedirectAttributes redirectAttributes) {
//		try {
//			this.TestService.save(testmodel);
//			redirectAttributes.addFlashAttribute("exception", "");
//		} catch (Exception e) {
//			redirectAttributes.addFlashAttribute("exception", e.getMessage());
//		}
//		return "redirect:/test";
//}
//
//   // 科目の変更フォームを表示
//	@GetMapping("/test/update")
//	public String showUpdateTestForm(@RequestParam Long id, Model model) {
//		TestModel test = TestService.getById(id);
//		model.addAttribute("test", test);
//		return "test/change";
//}
//
//// 科目情報の変更
//		@PostMapping("/test/update")
//		public String updateTest(@ModelAttribute("test") TestModel testModel) {
//		TestService.update(testModel);
//		return "redirect:/test";
//}
//
//		@GetMapping("/test/delete")
//		public String testdelete(Model model,Long id) {
//		this.TestService.delete(id);
//		return "redirect:/test";
//}
//
//}