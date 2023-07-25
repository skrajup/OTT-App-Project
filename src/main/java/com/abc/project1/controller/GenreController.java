package com.abc.project1.controller;

import com.abc.project1.entity.Genre;
import com.abc.project1.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GenreController {

    @Autowired
    GenreService gs;

    @GetMapping("/genres")
    public String getAllGenres(){
        List<Genre> genreList = gs.findAllGenres();
        return genreList.toString();
    }

    @PostMapping("/admin/genres")
    public String addNewGenre(@RequestBody Genre genre){
        Genre savedGenre = gs.addThisGenre(genre);
        System.out.println(savedGenre);
        return savedGenre.toString();
    }

    @PutMapping("/admin/genres/{genreId}")
    public String updateExistingGenre(@PathVariable("genreId") int genreId, @RequestBody Genre genreDetailsToUpdate){
        Genre updated = gs.updateThisGenre(genreId, genreDetailsToUpdate);
        return updated.toString();
    }

    @DeleteMapping("/admin/genres/{genreId}")
    public String deleteAGenre(@PathVariable("genreId") int genreId){
        gs.deleteThisGenre(genreId);
        return "a genre deleted";
    }
}
