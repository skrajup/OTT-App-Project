package com.abc.project1.service;

import com.abc.project1.entity.Genre;
import com.abc.project1.entity.Video;
import com.abc.project1.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class GenreService {

    @Autowired
    GenreRepo gr;

    @Autowired
    CommonService commonService;

    public Genre addThisGenre(Genre genre) {
        return gr.save(genre);
    }

    public List<Genre> findAllGenres() {
        return gr.findAll();
    }

    public Genre updateThisGenre(int genreId, Genre detailsToUpdate) {
        Genre genreToUpdate = gr.findByGid(genreId);
        if(detailsToUpdate.getGenreName() != null && genreToUpdate.getGenreName().length() != 0){
            genreToUpdate.setGenreName(detailsToUpdate.getGenreName());
        }
        if(detailsToUpdate.getGenreDescription() != null && genreToUpdate.getGenreDescription().length() != 0){
            genreToUpdate.setGenreDescription(detailsToUpdate.getGenreDescription());
        }
        gr.save(genreToUpdate); // not necessary, autosave will happen because genreToUpdate didn't detached yet

        return genreToUpdate;
    }

    public void deleteThisGenre(int genreId) {
        commonService.removeGenreLinkToVideos(genreId);
        Genre genreToDelete = gr.findByGid(genreId);
        System.out.println(genreToDelete);

        gr.delete(genreToDelete);
    }

    public Genre getByGenreId(int genreId) {
        return gr.findByGid(genreId);
    }

    public Set<Video> getVideosByGenreId(int genreId) {
        Genre genre = gr.findByGid(genreId);
        return genre.getVideos();
    }

    public Genre getByGenreName(String genreName) {
        return gr.findByGenreName(genreName);
    }
}
