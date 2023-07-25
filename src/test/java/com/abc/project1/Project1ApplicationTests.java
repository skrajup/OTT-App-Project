package com.abc.project1;

import com.abc.project1.entity.Genre;
import com.abc.project1.entity.User;
import com.abc.project1.entity.Video;
import com.abc.project1.repository.GenreRepo;
import com.abc.project1.repository.UserRepo;
import com.abc.project1.repository.VideoRepo;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class Project1ApplicationTests {
	@Autowired
	VideoRepo vr;

	@Autowired
	GenreRepo gr;

	@Autowired
	UserRepo ur;

	@Test
	void contextLoads() {
	}

//	@Test
//	@Transactional
//	void mytest(){
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
////		ur.save(u1);
//		Genre saved = gr.save(g1);
//		System.out.println(saved);
//		System.out.println(gr.findByGid(saved.getGid()));
//	}


}
