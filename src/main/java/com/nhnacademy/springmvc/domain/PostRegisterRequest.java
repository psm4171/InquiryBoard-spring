package com.nhnacademy.springmvc.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Value;
import javax.validation.constraints.NotNull;

@Value
public class PostRegisterRequest {

    @NotNull
    private String accountId;

    @Size(min = 2, max = 200)
    private String title;

    private Category category;

    @NotBlank
    @Size(max = 40000)
    private String content;

    private String fileName;


    public PostRegisterRequest(String accountId, String title, Category category, String content, String fileName) {
        this.accountId = accountId;
        this.title = title;
        this.category = category;
        this.content = content;
        this.fileName = fileName;
    }
}
