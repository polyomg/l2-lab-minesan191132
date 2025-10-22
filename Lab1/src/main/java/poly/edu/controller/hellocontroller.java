package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class hellocontroller {
	
	@GetMapping("/poly/HelloWorld")
	public String Myhello(Model model) {
		return "demo/HelloWorld";

	}
}
