package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.exception.LoginFailedException;
import com.nhnacademy.springmvc.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {
    private final UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    
    @GetMapping("/login")
    public String login(){
     return "view/login";
    }
    
    @PostMapping("/login")
    public ModelAndView doLogin(@RequestParam(value = "id") String id,
                                @RequestParam(value = "passowrd")String password,
                                HttpServletResponse response,
                                ModelAndView modelAndView) throws LoginFailedException {

        log.info("doLogin request");

        if(userRepository.matches(id, password)) {
            Cookie cookie = new Cookie("LoginSession", id);
            response.addCookie(cookie);

            modelAndView.setViewName("view/login");
        }else {
            throw new LoginFailedException();
        }

        return modelAndView;
    }
}
