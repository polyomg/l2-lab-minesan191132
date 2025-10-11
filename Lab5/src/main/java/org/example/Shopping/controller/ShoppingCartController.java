package org.example.Shopping.controller;

import org.example.Shopping.service.ShoppingCartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingCartController {
    @Autowired
    ShoppingCartServiceImpl cartService;

    @RequestMapping("/cart/view")
    public String view(Model model) {
        model.addAttribute("cart", cartService);
        return "cart/index";
    }

    @RequestMapping("/cart/add/{id}")
    public String add(@PathVariable("id") Integer id) {
        cartService.add(id);
        return "redirect:/cart/view"; // hiển thị giỏ hàng
    }
    @RequestMapping("/cart/remove/{id}")
    public String remove(@PathVariable("id") Integer id) {
        cartService.remove(id);
        return "redirect:/cart/view";
    }
    @RequestMapping("/cart/update/{id}")
    public String update(@PathVariable("id") Integer id,
                         @RequestParam("qty") Integer qty) {
        cartService.update(id, qty);
        return "redirect:/cart/view";
    }
    @RequestMapping("/cart/clear")
    public String clear() {
        cartService.clear();
        return "redirect:/cart/view";
    }
}
