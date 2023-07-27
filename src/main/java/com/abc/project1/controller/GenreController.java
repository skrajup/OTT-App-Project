package com.abc.project1.controller;

import com.abc.project1.entity.Genre;
import com.abc.project1.entity.Video;
import com.abc.project1.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    GenreService gs;

    @GetMapping
    @Transactional
    public String getAllGenres(){
        List<Genre> genreList = gs.findAllGenres();
        return genreList.toString(); // why it was not lazyInit of videos collection, if @Transactional is not used????
        // while genreList size is fine here
    }

    @GetMapping("/{genreName}")
    @Transactional
    public String getGenreByName(@PathVariable("genreName") String genreName){
        return gs.getByGenreName(genreName).toString();
    }

    @GetMapping("/{genreId}/videos")
    @Transactional
    public String getVideosByGenre(@PathVariable("genreId") int genreId){
        Set<Video> videos = gs.getVideosByGenreId(genreId);
        return videos.toString();
    }
}
