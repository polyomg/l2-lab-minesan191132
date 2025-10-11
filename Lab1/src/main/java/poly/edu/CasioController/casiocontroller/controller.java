package poly.edu.CasioController.casiocontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class controller {
   
	@GetMapping("/poly/casio")
	public String casio(Model model) {
		return "Casio/ChuViDienTich";
	}
	
	@PostMapping("/casio")
	public String caculate(@RequestParam int a,@RequestParam int b,@RequestParam String pheptoan, Model model) {
		int ketqua;
		  switch (pheptoan){
			  case "Dientich":
				 ketqua = a * b;
				 break;
			  case "Chuvi":
			      ketqua = (a+b)*2;
			      break;
			  default:
			      ketqua = -1;
		  }
		  
		  
		  model.addAttribute("ketqua", ketqua);
		  return "Casio/ChuViDienTich";
	  }
}
