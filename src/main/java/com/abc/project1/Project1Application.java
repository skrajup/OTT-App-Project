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
//		Genre g = gr.findByGid(2);
//		System.out.println(g.toString());

//		System.out.println(gr.findAll());

//		Set<Video> videos = ur.findByUid(9).getVideos();
////		System.out.println(videos);
//		for (Video v: videos) {
//			System.out.println(v.toString());
//		}


//TODO: insert Testing
		// save the user
//		User u = new User("saurabh2002", "dghshdsud78ds7usdgud", "skrajenf32@gmail.com");
//		ur.save(u);

		// add some generes
//		Genre g1 = new Genre("Horror", "Darna jaroori hai");
//		Genre g2 = new Genre("Romance", "Love is life");
//		Genre g3 = new Genre("Comedy", "Laugh is the best medicin");
//		Genre g4 = new Genre("Action", "Only fights");
//
//		gr.save(g1);
//		gr.save(g2);
//		gr.save(g3);
//		gr.save(g4);

		// user will add the video
//		Video v1 = new Video("Kisi Ka Bhai Kisi Ki Jaan", "Salman Khan Movie", "www.url.com");
//		Video v2 = new Video("Conjuring", "Hila dala na", "www.conjuring.com");
//		// set uploadedBy
//		v1.setUploadedBy(ur.findByUid(1));
//		v2.setUploadedBy(ur.findByUid(1));
//		// set genres
//		v1.setGenres(new HashSet<>(Arrays.asList(
//				gr.findByGid(2),
//				gr.findByGid(3),
//				gr.findByGid(4)
//		)));
//
//		v2.setGenres(new HashSet<>(Arrays.asList(
//				gr.findByGid(1),
//				gr.findByGid(4)
//		)));
//
//		vr.save(v1);
//		vr.save(v2);

//		// lets check if video is in user's videos & if video is in genres videos list
//		System.out.println("user videos: "+ur.findByUid(1).getVideos()); // 2 vids expected
//		System.out.println("horror videos: "+gr.findByGid(1).getVideos());// 1 vid expected
//		System.out.println("romance videos: "+gr.findByGid(2).getVideos());// 1 vid expected
//		System.out.println("comedy videos: "+gr.findByGid(3).getVideos());// 1 vid expected
//		System.out.println("action movies: "+gr.findByGid(4).getVideos());// 2 vids expected

		// everything is working fine

//TODO: delete video testing

// delete video 2: expected, video deleted and removed from user and genre's list
//		vr.delete(vr.findByVid(2));

//		// check genres videos list
//		System.out.println("horror videos: "+gr.findByGid(1).getVideos());
//		System.out.println("action videos: "+gr.findByGid(4).getVideos());
//
//		// check users video list
//		System.out.println("users videos: "+ur.findByUid(1).getVideos());

//todo: working perfectly

//TODO: delete genre testing
		// delete genre 2: expected, genre deleted and removed from video list
//		gr.delete(gr.findByGid(2));

//		// check if removed from video genres
//		System.out.println(vr.findByVid(1).getGenres());

	}
}