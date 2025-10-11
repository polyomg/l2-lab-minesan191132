package org.example.Controller;

import org.example.Service.cookieService;
import org.example.Service.paramService;
import org.example.Service.sessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class accountController {
    @Autowired
    cookieService cookieService;
    @Autowired
    paramService paramService;
    @Autowired
    sessionService sessionService;

    @GetMapping("/account/login")
    public String login1(){
        return "account/login";
    }

    @PostMapping("/account/login")
    public String login2(){
        String un = paramService.getString("username","");
        String pwd = paramService.getString("password","");
        boolean rm = paramService.getBoolean("rm",false);

        if(un.equals("poly") && pwd.equals("123")) {
            sessionService.set("username", un);


            if (rm) {
                cookieService.add("poly", un, 24);

            } else {
                cookieService.remove("poly");
            }

            sessionService.remove("error");
            sessionService.set("yesir", "Bạn đã đăng nhập thành công!");
        }else {
            sessionService.remove("yesir");
            sessionService.set("error", "Sai tên đăng nhập hoặc mật khẩu!");
        }


        return "account/login";
    }


}
