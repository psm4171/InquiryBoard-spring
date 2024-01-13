package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Post;
import java.util.List;

public interface PostRepository {
    boolean exists(long postId);
    Post register(long postId, String category, String title, String content);
    Post getPost(long postNo);

    List<Post> getListByUserId(String id);
    List<Post> getListUnanswerd();
    List<Post> getSortedList(String category, String id);


}
