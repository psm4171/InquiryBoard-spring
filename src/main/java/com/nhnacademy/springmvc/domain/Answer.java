package com.nhnacademy.springmvc.domain;

import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class Answer {
    long postId;

    String adminId;

    String content;

    LocalDateTime answerDate;

    public Answer(long postId, String adminId, String content) {
        this.postId = postId;
        this.adminId = adminId;
        this.content = content;
        this.answerDate = LocalDateTime.now();
    }

    public static Answer create(long postId, String adminId, String content){
        return new Answer(postId, adminId, content);
    }
}
