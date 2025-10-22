package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    // Đây là trang bạn dùng để test
    @GetMapping("/admin/home")
    public String adminHome() {
        return "/admin/home"; // Trả về 1 view
    }
}