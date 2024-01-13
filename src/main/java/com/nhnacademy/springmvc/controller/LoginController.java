package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Account;
import com.nhnacademy.springmvc.domain.Role;
import com.nhnacademy.springmvc.repository.AccountRepository;
import javax.security.auth.login.AccountNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.*;

@Slf4j
@Controller
public class LoginController {
    private final AccountRepository accountRepository;

    public LoginController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam(value="id") String id,
                          @RequestParam(value="password") String password,
                          HttpServletRequest request) throws AccountNotFoundException {

        log.info("LoginController - doLogin");

        if(!accountRepository.matches(id, password)){
            throw new AccountNotFoundException();
        }

        Account account = accountRepository.getAccount(id);

        HttpSession session = request.getSession();

        if(checkAdmin(account)){
            session.setAttribute("admin", account.getId());
            return "redirect:/admin";
        }

        session.setAttribute("user", account.getId());
        return "redirect:/user";
    }

    private static boolean checkAdmin(Account account){
        return account.getRole().equals(Role.Admin);
    }

}
