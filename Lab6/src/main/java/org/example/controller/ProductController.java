package org.example.controller;

import org.example.DAO.CategoryDAO;
import org.example.DAO.ProductDAO;
import org.example.entity.Category;
import org.example.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductDAO productDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @RequestMapping("/product/index")
    public String index(Model model){
        model.addAttribute("categories", categoryDAO.findAll());
        model.addAttribute("items",productDAO.findAll());
        model.addAttribute("item", new Product());
        return "product/index";
    }

    @RequestMapping("/product/sort")
    public String sort(Model model, @RequestParam("field") Optional<String> field) {
        //DESC: giảm dần
        //ASC: tăng dần
        Sort sort = Sort.by(Sort.Direction.DESC, field.orElse("price"));
        model.addAttribute("field", field.orElse("price").toUpperCase());
        List<Product> items = productDAO.findAll(sort);
        model.addAttribute("items", items);
        return "product/sort";
    }

    @RequestMapping("/product/page")
    public String page(Model model, @RequestParam("p") Optional<Integer> p, @RequestParam("field") Optional<String> field){
        Sort sort = Sort.by(Sort.Direction.ASC, field.orElse("price"));
        Pageable pageable = PageRequest.of(p.orElse(0), 5, sort);
        Page<Product> page = productDAO.findAll(pageable);
        model.addAttribute("page", page);
        return "product/page";
    }

    @RequestMapping("/product/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        // 1. LẤY SẢN PHẨM CẦN SỬA (CHO FORM)
        Product item = productDAO.findById(id).get();
        model.addAttribute("item", item);
        List<Category> categories = categoryDAO.findAll();
        model.addAttribute("categories", categories);
        List<Product> items = productDAO.findAll();
        model.addAttribute("items", items);
        return "product/page";
    }

    @RequestMapping("/product/create")
    public String create(Product item) {
        item.setId(null);
        productDAO.save(item);
        return "redirect:/product/page";
    }

    @RequestMapping("/product/update")
    public String update(Product item) {
        productDAO.save(item);
        return "redirect:/product/edit/" + item.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        productDAO.deleteById(id);
        return "redirect:/product/page";
    }

}
