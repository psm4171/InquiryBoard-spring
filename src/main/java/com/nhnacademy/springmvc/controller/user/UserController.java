package com.nhnacademy.springmvc.controller.user;

import com.nhnacademy.springmvc.domain.Post;
import com.nhnacademy.springmvc.exception.PostNotFoundException;
import com.nhnacademy.springmvc.repository.PostRepository;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    private final PostRepository postRepository;
    public UserController(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    @GetMapping
    public String userHome(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        String accountId = (String) session.getAttribute("user");

        if(!postRepository.isEmpty()){
            model.addAttribute("posts", postRepository.findAllByAccountId(accountId));
        }

        return "view/user/index";
    }

    @GetMapping("/detail/{postId}")
    public String postDetail(@PathVariable(value = "postId") long postId, Model model){

        if(!postRepository.exists(postId)){
            throw new PostNotFoundException();
        }

        Post post = postRepository.getPost(postId);
        model.addAttribute("post", post);

        return "view/user/detail";
    }
}
