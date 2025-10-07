package org.example.DataValidation.Controller;


import jakarta.validation.Valid;
import org.example.DataValidation.Model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/staff/createvalidate")
public class StaffControllervalidation {
    @GetMapping("/form")
    public String CreateForm(Model model, @ModelAttribute("staff") Staff staff) {
        model.addAttribute("staff", new Staff());
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "StaffFormValidation";
    }

    @PostMapping("/save")
    public String CreateSave(Model model, @RequestPart("photo_file") MultipartFile photoFile
            , @Valid @ModelAttribute("staff") Staff staff, Errors errors) {
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getOriginalFilename());
        }
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "dữ liệu đã nhập đúng!");
        }
        return "StaffFormValidation";
    }
}
