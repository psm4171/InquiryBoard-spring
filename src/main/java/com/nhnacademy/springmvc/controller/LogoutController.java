package com.nhnacademy.springmvc.controller;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @GetMapping("/logout")
    public String doLogout(HttpServletRequest request){
        HttpSession session = request.getSession();

        if(Objects.nonNull(session.getAttribute("admin"))){
            session.removeAttribute("admin");
        }

        if(Objects.nonNull(session.getAttribute("user"))){
            session.removeAttribute("user");
        }

        return "view/index";
    }
}
