package com.nhnacademy.springmvc.controller.user;

import com.nhnacademy.springmvc.domain.Category;
import com.nhnacademy.springmvc.domain.Post;
import com.nhnacademy.springmvc.domain.PostRegisterRequest;
import com.nhnacademy.springmvc.exception.NotAcceptableFileTypeException;
import com.nhnacademy.springmvc.exception.ValidationFailedException;
import com.nhnacademy.springmvc.repository.PostRepository;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Controller
@RequestMapping("/user/register")
public class PostRegisterController {

    private final PostRepository postRepository;
    private static String UPLOAD_PATH = "/Users/parkseungmin/다운로드";

    private static List<String> acceptableFileType = List.of("image/gif", "image/jpg", "image/jpeg", "image/png");

    public PostRegisterController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public String getUserRegister(Model model) {
        model.addAttribute("categories", Category.values());
        return "view/user/register";
    }

    @PostMapping
    public String doUserRegister(@Valid @ModelAttribute(value = "post") PostRegisterRequest postRegisterRequest,
                                 @RequestParam(value = "uploadFiles", required = false) MultipartFile[] uploadFiles,
                                 BindingResult bindingResult) throws IOException {

        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        List<String> fileList = new ArrayList<>();

        if (!fileEmptyCheck(uploadFiles)) {
            fileUpload(uploadFiles, fileList);
        }

        Post post = postRepository.doPost(
                postRegisterRequest.getAccountId(),
                postRegisterRequest.getTitle(),
                postRegisterRequest.getCategory(),
                postRegisterRequest.getContent()
        );

        post.setFileList(fileList);

        return "redirect:/user";

    }

    private boolean fileEmptyCheck(MultipartFile[] multipartFiles) {
        boolean isEmpty = false;

        for (MultipartFile file : multipartFiles) {
            if (file.isEmpty()) {
                isEmpty = true;
            }
        }
        return isEmpty;
    }

    private void fileUpload(MultipartFile[] multipartFiles, List<String> fileList) throws IOException {
        fileTypeCheck(multipartFiles);

        for(MultipartFile file : multipartFiles){
            String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
            fileList.add(fileName);
            file.transferTo(Paths.get(UPLOAD_PATH + fileName));
        }
    }

    private void fileTypeCheck(MultipartFile[] multipartFiles) {
        for (MultipartFile file : multipartFiles) {
            if (!acceptableFileType.contains(file.getContentType())) {
                throw new NotAcceptableFileTypeException();
            }
        }
    }
}

