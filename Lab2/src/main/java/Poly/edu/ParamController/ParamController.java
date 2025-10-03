package Poly.edu.ParamController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/param")
public class ParamController {
	@GetMapping("/form")
	public String form() {
		return "Form/Form";
	}
	
	@PostMapping("/save/{x}")
	//@PathVariable String x Để lấy giá trị từ đường dẫn URL và gán nó cho biến x trong phương thức
	//@RequestParam String y Để lấy giá trị từ tham số truy vấn y trong URL và gán nó cho biến y trong phương thức
	public String save(@PathVariable String x,@RequestParam String y, Model model) {
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		return "Form/Form";
	}
}
