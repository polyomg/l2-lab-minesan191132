package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class Mycontroller {
  @Autowired
  ServletContext application;
  @GetMapping("/url")
  public String url(HttpSession session, HttpServletRequest rq,  HttpServletResponse rs) {
	  String fullname = rq.getParameter("Hoten");
	  rq.setAttribute("message", fullname);
      return "demo/HelloWorld";
  }
}
