package com.example.Staff.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Staff.Model.Staff;

@Controller
@RequestMapping("/staff")
public class StaffController {
  @GetMapping("/detail")
  public String detail(Model model) {
	  Staff staff = Staff.builder().id("user@gmail.com").name("Nguyen Van A").level(2).build();
	  model.addAttribute("staff", staff);
	  return "Staff";
  }
  
  @GetMapping("/list")
  public String list(Model model) {
	  List<Staff> list = List.of(
			  Staff.builder().id("user1@gmail.com").name("Nguyen Van user1").level(0).build(),
			  Staff.builder().id("user2@gmail.com").name("Nguyen Van user2").level(1).build(),
			  Staff.builder().id("user3@gmail.com").name("Nguyen Van user3").level(2).build(),
			  Staff.builder().id("user4@gmail.com").name("Nguyen Van user4").level(2).build(),
			  Staff.builder().id("user5@gmail.com").name("Nguyen Van user5").level(1).build(),
			  Staff.builder().id("user6@gmail.com").name("Nguyen Van user6").level(0).build());
			  model.addAttribute("list", list);
	  return "StaffList";
  }
  
  @GetMapping("/liststatus")
  public String listStatus(Model model) {
	  List<Staff> list = List.of(
			  Staff.builder().id("user1@gmail.com").name("Nguyen Van user1").level(0).build(),
			  Staff.builder().id("user2@gmail.com").name("Nguyen Van user2").level(1).build(),
			  Staff.builder().id("user3@gmail.com").name("Nguyen Van user3").level(2).build(),
			  Staff.builder().id("user4@gmail.com").name("Nguyen Van user4").level(2).build(),
			  Staff.builder().id("user5@gmail.com").name("Nguyen Van user5").level(1).build(),
			  Staff.builder().id("user6@gmail.com").name("Nguyen Van user6").level(0).build());
			  model.addAttribute("list", list);
	  return "StaffListStatus";
  }

    @GetMapping("/listradio")
    public String listRadio(Model model) {
        List<Staff> list = List.of(
                Staff.builder().id("user1@gmail.com").name("Nguyen Van user1").level(0).build(),
                Staff.builder().id("user2@gmail.com").name("Nguyen Van user2").level(1).build(),
                Staff.builder().id("user3@gmail.com").name("Nguyen Van user3").level(2).build(),
                Staff.builder().id("user4@gmail.com").name("Nguyen Van user4").level(2).build(),
                Staff.builder().id("user5@gmail.com").name("Nguyen Van user5").level(1).build(),
                Staff.builder().id("user6@gmail.com").name("Nguyen Van user6").level(0).build());
        model.addAttribute("list", list);
        return "StaffListRadioButton";
    }
}
