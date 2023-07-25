package com.abc.project1.service;

import com.abc.project1.entity.Genre;
import com.abc.project1.entity.Video;
import com.abc.project1.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class GenreService {

    @Autowired
    GenreRepo gr;

    public Genre addThisGenre(Genre genre) {
        return gr.save(genre);
    }

    public List<Genre> findAllGenres() {
        return gr.findAll();
    }

    @Transactional
    public Genre updateThisGenre(int genreId, Genre details) {
        Genre genreToUpdate = gr.findByGid(genreId);
//        System.out.println(genreToUpdate.toString());
//        System.out.println(genreToUpdate.videosGetter());
//        Set<Video> lis = genreToUpdate.videosGetter();
//        System.out.println(lis);
        genreToUpdate.setGenreName(details.getGenreName());
        genreToUpdate.setGenreDescription(details.getGenreDescription());

//        return gr.save(genreToUpdate);
        return genreToUpdate;
    }

    public void deleteThisGenre(int genreId) {
        Genre genreToDelete = gr.findByGid(genreId);
        gr.delete(genreToDelete);
    }
}
