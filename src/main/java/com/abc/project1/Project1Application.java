package com.abc.project1;

import com.abc.project1.entity.Genre;
import com.abc.project1.entity.User;
import com.abc.project1.entity.Video;
import com.abc.project1.repository.GenreRepo;
import com.abc.project1.repository.UserRepo;
import com.abc.project1.repository.VideoRepo;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class Project1Application implements CommandLineRunner {

	@Autowired
	VideoRepo vr;

	@Autowired
	GenreRepo gr;

	@Autowired
	UserRepo ur;

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
//		Genre g1 = new Genre("action", "action desc");
//		Genre g2 = new Genre("romance", "romance desc");
//
//		User u1 = new User("saurabh", "77sdhjhsuhds", "saurabh@zz.com");
//
//		Video v1 = new Video("video 1 title", "video 1 desc", "www.url1.com");
////		Video v2 = new Video("video 2 title", "video 2 desc", "www.url2.com");
//
//		Set<Genre> genreSet = new HashSet<>();
//		genreSet.add(g1);
//		genreSet.add(g2);
//
//		v1.setGenres(genreSet);
//		v1.setUploadedBy(u1);
//
//		Set<Video> videoSet = new HashSet<>();
//		videoSet.add(v1);
//
//		u1.setVideos(videoSet);
//
//		for (Genre g: genreSet) {
//			g.getVideos().add(v1);
//		}
//
//		User saveduser = ur.save(u1);
//		System.out.println(saveduser.getVideos());

//		Genre saved = gr.save(g1);
//		System.out.println(saved);
//		System.out.println(gr.findByGid(saved.getGid()));


//		Video v3 = new Video("video 3 title", "video 3 desc", "www.url.com");
//		User u = ur.findByUid(9);
//		v3.setUploadedBy(u);
//
//		u.getVideos().add(v3);
//
//		Set<Genre> genres = new HashSet<>(Arrays.asList(
//				gr.findByGid(5),
//				gr.findByGid(6)
//		));
//		v3.setGenres(genres);
//		for (Genre g: genres) {
//			g.getVideos().add(v3);
//		}
//
//		vr.save(v3);
//		User u = ur.findByUid(9);
//		Set<Video> videos = u.getVideos();
////		System.out.println(u.toString());
////		System.out.println(u.getVideos());
//
//		for (Video v: videos) {
////			System.out.println(v.getUploadedBy());
//			System.out.println(v.getGenres());
//		}

//		Video v = vr.findByVid(2);
//		System.out.println(v.getGenres());
//
//		Genre g = gr.findByGid(5);
//		System.out.println(g.getVideos());

//		Set<Video> videos = ur.findByUid(9).getVideos();
////		System.out.println(videos);
//		for (Video v: videos) {
//			System.out.println(v.toString());
//		}
	}
}