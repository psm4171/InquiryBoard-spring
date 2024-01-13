package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Category;
import com.nhnacademy.springmvc.domain.Post;
import java.util.List;

public interface PostRepository {
    boolean exists(long postId);

    boolean isEmpty();
    Post doPost(String accountId, String title, Category category, String content);
    Post getPost(long postId);
    List<Post> findAllByAccountId(String accountId);
    List<Post> findAllByCategoryId(Category category);

    List<Post> findByAnswerStatusFalse();

}
