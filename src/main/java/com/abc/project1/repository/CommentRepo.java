package com.abc.project1.repository;

import com.abc.project1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
    Comment findByCommentId(int commentId);

    List<Comment> findAllByVideoId(int videoId);
}
