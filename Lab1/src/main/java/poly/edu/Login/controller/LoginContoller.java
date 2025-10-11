package poly.edu.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import poly.edu.Login.model.User;
import poly.edu.Login.service.LoginService;

@Controller
@RequestMapping("/poly")
public class LoginContoller {
	
    @Autowired
    private LoginService logs;
    
    
	@GetMapping("/login")
	public String loginform(Model model) {
		model.addAttribute("user", new User());
		return "Login/LoginForm";
	}
	
	@PostMapping("/login")
	public String Login(@ModelAttribute User user, Model model) {
		String result = logs.checkLogin(user.getUsername(),user.getPassword());
		
		if("Dang Nhap Thanh Cong".equals(result)) {
			return "Login/hello";
		}else {
		  model.addAttribute("error", result);
		  return "Login/LoginForm";
		}
	}
}
