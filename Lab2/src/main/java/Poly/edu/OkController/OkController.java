package Poly.edu.OkController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ctrl") //base url
public class OkController {
	@GetMapping("/home")
	public String ok() {
		return "Ok/Ok";
	}

	@PostMapping("/ok")
	public String m1(Model model) {
		model.addAttribute("kq", "OK1") ;
		return "Ok/Ok";
	}

	@GetMapping("/ok")
	public String m2(Model model) {
		model.addAttribute("kq", "OK2");
		return "Ok/Ok";
	}

	@PostMapping(value = "/ok", params = "x")
	public String m3(Model model) {
		model.addAttribute("kq", "OK3");
		return "Ok/Ok";
	}
}
