package com.abc.project1.repository;

import com.abc.project1.entity.LikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepo extends JpaRepository<LikeEntity, Integer> {
    LikeEntity findByLikeId(int likeId);

    List<LikeEntity> findAllByVideoId(int videoId);
}
