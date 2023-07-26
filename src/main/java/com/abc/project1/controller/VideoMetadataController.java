package com.abc.project1.controller;

import com.abc.project1.entity.Video;
import com.abc.project1.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VideoMetadataController {

    @Autowired
    VideoService vs;

    @GetMapping("/videos/{videoId}")
    @Transactional
    public String getVideoDetails(@PathVariable("videoId") int videoId){
        Video video = vs.getThisVideo(videoId);
        return video.toString();
    }

    @GetMapping("/videos")
    @Transactional
    public String getAllVideos(){
        List<Video> videos = vs.getAllVideos();
        return videos.toString();
    }
}
