package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Post {

    long postId;

    String writeTime;
    String writerId;
    String category;
    String title;
    String content;
    Post reply;

    public Post(long postId, String category, String title, String content) {
        this.postId = postId;
        this.category = category;
        this.title = title;
        this.content = content;
    }
}
