package com.abc.project1.controller;

import com.abc.project1.entity.Genre;
import com.abc.project1.entity.Video;
import com.abc.project1.service.GenreService;
import com.abc.project1.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    GenreService gs;

    @Autowired
    VideoService vs;
    @PostMapping("/genres")
    public String addNewGenre(@RequestBody Genre genre){
        Genre savedGenre = gs.addThisGenre(genre);
        return savedGenre.toString();
    }

    @PostMapping("/videos")
    public String addNewVideo(@RequestBody Video video, @RequestParam("uploadedById") int uploadedById, @RequestParam("genresIds") Set<Integer> genresIds){
        Video savedVideo = vs.addThisVideo(video, uploadedById, genresIds);
        return savedVideo.toString();
    }

    @PutMapping("/genres/{genreId}")
    @Transactional
    public String updateGenre(@RequestBody Genre genreDetailsToUpdate, @PathVariable("genreId") int genreId){
        Genre updated = gs.updateThisGenre(genreId, genreDetailsToUpdate);
        return updated.toString();
    }

    @PutMapping("/videos/{videoId}")
    @Transactional
    public String updateVideo(@RequestBody Video videoDetailsToUpdate, @PathVariable("videoId") int videoId){
        Video updated = vs.updateThisVideo(videoId, videoDetailsToUpdate);
        return updated.toString();
    }

    @DeleteMapping("/genres/{genreId}")
    public String deleteGenre(@PathVariable("genreId") int genreId){
        gs.deleteThisGenre(genreId);
        return "genre deleted";
    }

    @DeleteMapping("/videos/{videoId}")
    public String deleteVideo(@PathVariable("videoId") int videoId){
        vs.deleteThisVideo(videoId);
        return "video deleted";
    }
}
