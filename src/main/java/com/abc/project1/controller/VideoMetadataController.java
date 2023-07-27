package com.abc.project1.controller;

import com.abc.project1.entity.Comment;
import com.abc.project1.entity.LikeEntity;
import com.abc.project1.entity.Video;
import com.abc.project1.service.CommentService;
import com.abc.project1.service.LikeService;
import com.abc.project1.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/videos")
public class VideoMetadataController {

    @Autowired
    VideoService vs;

    @Autowired
    LikeService ls;

    @Autowired
    CommentService cs;

    @GetMapping("/{videoId}")
    @Transactional
    public String getVideoDetails(@PathVariable("videoId") int videoId){
        Video video = vs.getThisVideo(videoId);
        return video.toString();
    }

    @GetMapping
    @Transactional
    public String getAllVideos(){
        List<Video> videos = vs.getAllVideos();
        return videos.toString();
    }

    @PostMapping("/{videoId}/like")
    @Transactional
    public String likeVideo(@PathVariable("videoId") int videoId, @RequestBody LikeEntity like){
        LikeEntity savedLike = ls.likeThisVideo(videoId, like);
        return savedLike.toString();
    }

    @PostMapping("/{videoId}/comment")
    @Transactional
    public String commentOnVideo(@PathVariable("videoId") int videoId, @RequestBody Comment comment){
        Comment savedComment = cs.commentOnThisVideo(videoId, comment);
        return savedComment.toString();
    }

    @GetMapping("/{videoId}/likes")
    @Transactional
    public String getALlLikes(@PathVariable("videoId") int videoId){
        return ls.getAllLikesOnVideo(videoId).toString();
    }

    @GetMapping("/{videoId}/comments")
    @Transactional
    public String getAllComments(@PathVariable("videoId") int videoId){
        return cs.getAllCommentsOnVideo(videoId).toString();
    }
}
