package com.nhnacademy.springmvc.controller;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model){
        HttpSession session = request.getSession(false);

        if(Objects.nonNull(session)){
            model.addAttribute("id", true);
        }

        return "view/login";
    }
}
