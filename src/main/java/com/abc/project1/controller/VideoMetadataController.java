package com.abc.project1.controller;

import com.abc.project1.entity.Video;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class VideoMetadataController {
    @PostMapping("/admin/videos")
    public String uploadNewVideo(@RequestBody Video video){
        return "upload new video";
    }

    @GetMapping("/videos/{videoId}")
    public String getVideoDetails(){
        return "get video details";
    }

    @GetMapping("/videos")
    public String getAllVideos(){
        return "get all videos";
    }

    @GetMapping("/genres/{genreId}/videos")
    public String getAllVideosOfGenre(){
        return "get all videos of a genre";
    }

    @PutMapping("/admin/videos/{videoId}")
    public String updateVideoDetails(){
        return "update video details";
    }

    @DeleteMapping("/admin/videos/{videoId}")
    public String deleteAVideo(){
        return "delete a video";
    }
}
