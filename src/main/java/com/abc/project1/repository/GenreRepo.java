package com.abc.project1.repository;

import com.abc.project1.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Integer> {
    Genre findByGid(int genreId);

    Genre findByGenreName(String genreName);
}
