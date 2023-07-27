package com.abc.project1.controller;

import com.abc.project1.ApiResponse.ResponseHandler;
import com.abc.project1.entity.Genre;
import com.abc.project1.entity.Video;
import com.abc.project1.service.GenreService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/genres")
public class GenreController {
    @Autowired
    GenreService gs;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllGenres(HttpServletRequest request){
        List<Genre> genreList = gs.findAllGenres();
        return ResponseHandler.generateResponse(genreList, HttpStatus.OK, "all genres fetched success.", request.getRequestURI());
    }

    @GetMapping("/{genreName}")
    public ResponseEntity<Map<String, Object>> getGenreByName(@PathVariable("genreName") String genreName, HttpServletRequest request){
         Genre genre = gs.getByGenreName(genreName);
        System.out.println(genre);
         return  ResponseHandler.generateResponse(genre, HttpStatus.OK, "genre "+genreName+" fetched success.", request.getRequestURI());
    }

    @GetMapping("/{genreId}/videos")
    public ResponseEntity<Map<String, Object>> getVideosByGenre(@PathVariable("genreId") int genreId, HttpServletRequest request){
        Set<Video> videos = gs.getVideosByGenreId(genreId);
        return ResponseHandler.generateResponse(videos, HttpStatus.OK, "all videos tagged with genreId "+genreId+" fetched success.", request.getRequestURI());
    }
}
