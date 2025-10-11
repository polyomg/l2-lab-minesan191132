package Poly.edu.Product2.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Poly.edu.Product2.Model.Product;

@Controller
@RequestMapping("/product")
public class ProductController2 {
    public List<Product> items = new ArrayList<>(
            Arrays.asList(
                    new Product("A", 1.0),
                    new Product("B", 12.0)
            )

    );

    @GetMapping("/form")
    public String form(Model model) {
    	Product p = new Product();
    	p.setName("Iphone 30");
    	p.setPrice(3000.0);

    	model.addAttribute("product1", p);
        model.addAttribute("items", items);
    	return "ProductForm2/Form";
    }
    
    @PostMapping("/save")
    public String save(@ModelAttribute Product product, Model model) {
        model.addAttribute("product1", new Product("Iphone 30",3000.0));
        model.addAttribute("product2", product);
        items.add(product);
        model.addAttribute("items", items);
    	return "ProductForm2/Form";
    }

}
