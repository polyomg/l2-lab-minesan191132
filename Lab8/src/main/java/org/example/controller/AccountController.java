package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/account/edit-profile")
    public String editProfile() {
        return "/profile/edit";
    }

    @GetMapping("/account/change-password")
    public String changePass() {
        return "/profile/change-pass";
    }
}