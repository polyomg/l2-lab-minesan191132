package org.example.Databinding.Controller;


import org.example.Databinding.Model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/staff/create")
public class StaffController {
    @GetMapping("/form")
    public String CreateForm(Model model, @ModelAttribute("staff") Staff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "StaffForm";
    }

    @PostMapping("/save")
    public String CreateSave(Model model, @ModelAttribute("staff") Staff staff, @RequestPart("photo_file") MultipartFile photoFile) {
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getName());
        }
        model.addAttribute("message", "Xin chào" + staff.getFullname());
        return "StaffForm";
    }
}
