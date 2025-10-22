package Poly.edu.Product.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Poly.edu.Product.Model.Product;

@Controller
@RequestMapping("/productlist")
public class ProductController {
    @GetMapping("/form")
    public String form() {
    	return "ProductForm/Form";
    }
    
    @PostMapping("/save")
    public String save(@ModelAttribute Product product, Model model) {
    	model.addAttribute("name", product.getName());
    	model.addAttribute("price", product.getPrice());
    	return "ProductForm/Form";
    }
}
