package com.abc.project1.service;

import com.abc.project1.entity.LikeEntity;
import com.abc.project1.repository.LikeRepo;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LikeService {
    @Autowired
    LikeRepo lr;

    @Autowired
    EntityManager em;

    @Transactional
    public LikeEntity likeThisVideo(int videoId, LikeEntity like) {
        like.setVideoId(videoId);
        LikeEntity savedLike = lr.save(like);
        em.refresh(savedLike);

        return savedLike;
    }

    public List<LikeEntity> getAllLikesOnVideo(int videoId) {
        return lr.findAllByVideoId(videoId);
    }
}
