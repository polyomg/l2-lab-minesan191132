package Poly.edu.ResultController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ResultController {
 @RequestMapping("/a")
 public String m1() {
	  return "5/a";
 }
 
 @RequestMapping("/b")
 public String m2(Model model) {
	 model.addAttribute("message", "i come form b");
	 return "5/a";
 }
 
 @RequestMapping("/c")
 public String m3 (RedirectAttributes params) {
	 params.addAttribute("message", "i come from c");
	 return "redirect:/a";
 }
 
 @ResponseBody
 @RequestMapping("/d")
 public String m4() {
	 return "i come from d";
 }
}
