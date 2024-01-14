package com.nhnacademy.springmvc.domain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Value;
import org.jetbrains.annotations.NotNull;

@Value
public class AnswerRegisterRequest {

    @NotNull
    private long postId;

    @NotNull
    private String adminId;

    @NotBlank
    @Size(max = 40000)
    private String content;
}
