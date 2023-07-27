package com.abc.project1.service;

import com.abc.project1.entity.Genre;
import com.abc.project1.entity.Video;
import com.abc.project1.repository.GenreRepo;
import com.abc.project1.repository.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CommonService {
   @Autowired
   VideoService vs;

   @Autowired
   VideoRepo vr;

    public void removeGenreLinkToVideos(int genreId){
        List<Video> allVideos = vs.getAllVideos();

        for(Video video: allVideos){
            Set<Genre> genres = video.getGenres();
            for(Genre genre: genres){
                if(genre.getGid() == genreId){
                    if(genres.size() == 1){
                        vs.deleteThisVideo(video.getVid());
                    }else{
                        genres.remove(genre);
                        video.setGenres(genres);
                        vr.save(video);
                    }
                    break;
                }
            }
        }
//        Genre genre = gs.getByGenreId(genreId);
//        genre.getVideos().clear();
//        System.out.println("2: "+genre);
//        gr.save(genre);
    }
}
