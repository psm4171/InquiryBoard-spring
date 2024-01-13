package com.nhnacademy.springmvc.controller;

import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class HomeController {
    @GetMapping("/")
    public String index(HttpServletRequest request){

        log.info("HomeController - index");
        HttpSession session = request.getSession();

        if(Objects.nonNull(session.getAttribute("admin"))){
            return "view/admin/index";
        }

        if(Objects.nonNull(session.getAttribute("user"))){
            return "view/user/index";
        }

        return "view/index";
    }
}
