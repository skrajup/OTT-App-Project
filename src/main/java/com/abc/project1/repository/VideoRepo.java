package com.abc.project1.repository;

import com.abc.project1.entity.Genre;
import com.abc.project1.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepo extends JpaRepository<Video, Integer> {
    Video findByVid(int videoId);
}
