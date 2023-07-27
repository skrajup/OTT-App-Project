package com.abc.project1.service;

import com.abc.project1.entity.Genre;
import com.abc.project1.entity.User;
import com.abc.project1.entity.Video;
import com.abc.project1.repository.VideoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class VideoService {
    @Autowired
    VideoRepo vr;
    @Autowired
    UserService us;
    @Autowired
    GenreService gs;
    @Autowired
    ResourceLoader loader;

    public Video addThisVideo(Video video, int uploadedById, Set<Integer> genresIds) {
        // set uploadedBy User
        User user = us.getThisByUserId(uploadedById);
        video.setUploadedBy(user);

        // add all genres
        Set<Genre> genres = new HashSet<>();
        for (int genreId: genresIds) {
            Genre genre = gs.getByGenreId(genreId);
            genres.add(genre);
        }

        video.setGenres(genres);

        return vr.save(video);
    }

    public List<Video> getAllVideos() {
        return vr.findAll();
    }

    public Video getThisVideo(int videoId) {
        return vr.findByVid(videoId);
    }

    public Video updateThisVideo(int videoId, Video details) {
        Video videoToUpdate = vr.findByVid(videoId);
        if(details.getVideoTitle() != null && details.getVideoTitle().length() != 0){
            videoToUpdate.setVideoTitle(details.getVideoTitle());
        }
        if(details.getVideoDescription() != null && details.getVideoDescription().length() != 0){
            videoToUpdate.setVideoDescription(details.getVideoDescription());
        }
        if(details.getVideoUrl() != null && details.getVideoUrl().length() != 0){
            videoToUpdate.setVideoUrl(details.getVideoUrl());
        }
        return videoToUpdate;
    }

    public void deleteThisVideo(int videoId) {
        Video video = vr.findByVid(videoId);
        vr.delete(video);
    }

    public void updateGenresOnThisVideo(int videoId, Set<Integer> genresIds) {
        Video video = vr.findByVid(videoId);

        Set<Genre> genres = new HashSet<>();
        for (int genreId: genresIds) {
            Genre genre = gs.getByGenreId(genreId);
            genres.add(genre);
        }

        video.setGenres(genres);
        vr.save(video);
    }

    public Mono<Resource> readVideo(int videoId){
        Video video = vr.findByVid(videoId);
        return Mono.fromSupplier(() -> loader.getResource(video.getVideoUrl()));
    }

}
