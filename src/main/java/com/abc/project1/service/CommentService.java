package com.abc.project1.service;

import com.abc.project1.entity.Comment;
import com.abc.project1.repository.CommentRepo;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepo cr;

    @Autowired
    EntityManager em;

    @Transactional
    public Comment commentOnThisVideo(int videoId, Comment comment) {
        comment.setVideoId(videoId);
        Comment savedComment = cr.save(comment);
        em.refresh(savedComment);

        return savedComment;
    }

    public List<Comment> getAllCommentsOnVideo(int videoId) {
        return cr.findAllByVideoId(videoId);
    }
}
