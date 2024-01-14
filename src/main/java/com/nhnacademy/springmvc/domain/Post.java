package com.nhnacademy.springmvc.domain;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Post {

    private long postId;

    private String accountId;
    private String title;
    private Category category;
    private String content;
    private LocalDateTime registerDate;

    private List<String> fileList;

    private boolean answerStatus;

    public Post(String accountId, String title, Category category, String content) {
        this.accountId = accountId;
        this.title = title;
        this.category = category;
        this.content = content;
    }

    public static Post create(String accountId, String title, Category category, String content){
        return new Post(accountId, title, category, content);
    }

    public boolean isAnswerStatus(){
        return this.answerStatus;
    }


}
