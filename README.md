# End-to-End Project: Building a Video Streaming Platform Using Spring Boot
## Project Overview:-
You are tasked with building an end-to-end video streaming platform using Spring Boot that
allows users to access various genres of videos. The platform will be similar in functionality
to the ZEE5 OTT App, where users can access different types of genres and stream videos
within those genres.

### Requirements:-
1. Spring Core: Implement the core functionalities of the application using Spring Core.
   This includes managing video metadata, user authentication, and video categorization.
2. Spring MVC: Set up the RESTful endpoints using Spring MVC to handle user requests for
   accessing genres, searching for videos, and managing user preferences.
3. Spring REST API: Build RESTful APIs using Spring to support various operations, including
   fetching video details, user authentication, and updating user preferences.
4. Spring WebFlux: Implement video streaming using Spring WebFlux to enable smooth and
   efficient video delivery to users.
5. Apache Kafka Integration: Integrate Apache Kafka with the application to handle realtime events, such as user interactions, video uploads, and genre updates.
   

### Project Tasks

   **Task 1: Data Model and Database Setup**
   
   Design the data model to store video metadata, user information, and genre details. Use
   any relational database of your choice (e.g., MySQL, PostgreSQL) to persist the data. Set up
   the necessary database tables and establish a connection to the database using Spring Data
   JPA.

   **Task 2: Genre Management**
   
   Create APIs to manage video genres. The endpoints should allow administrators to add,
   update, and delete genres. Regular users can view the list of available genres.
   
**Task 3: Video Metadata Management**
   
   Build APIs to handle video metadata, such as title, description, genre, and streaming URL.
   Allow authenticated users to upload videos and associate them with appropriate genres.
   
**Task 4: Video Streaming**

   Implement video streaming using Spring WebFlux. Users should be able to stream videos
   based on the selected genre and video ID.

   **Task 5: Real-time Events with Kafka**

   Integrate Apache Kafka with the application to handle real-time events. Events such as user
   likes, comments, and video uploads should trigger appropriate actions within the system.
   
**Task 6: Frontend Development (Optional)**

   If time permits and you are familiar with frontend development, you can create a simple
   frontend using any frontend framework (e.g., React, Angular, or HTML) to interact with the
   backend APIs.

### Project Guidelines
1. Use Maven or Gradle to manage the project dependencies.
2. Write unit tests for critical functionalities using JUnit.
   BLUEPRINT:


   **Task 1: Data Model and Database Setup**
   Tables to be Created:-
1. User Table:
   - Columns: `id`, `username`, `password`, `email`, `created_at`, `updated_at`
2. Genre Table:
   - Columns: `id`, `name`, `description`
3. Video Table:
   - Columns: `id`, `title`, `description`, `url`, `genre_id`, `uploaded_by`, `uploaded_at`

**Genre Types**

For this project, you can create various genres like:

1. Action
2. Comedy
3. Drama
4. Romance
5. Thriller
6. Horror
7. Sci-Fi
8. Fantasy
9. Adventure
10. Documentary


You can get movie details of all this genres by visiting TMDB API

**Task 2: Genre Management**

**Endpoints**

1. `GET /api/genres`: Get a list of all available genres.
2. `POST /api/admin/genres`: Add a new genre (Admin only).
3. `PUT /api/admin/genres/{genreId}`: Update an existing genre (Admin only).
4. `DELETE /api/admin/genres/{genreId}`: Delete a genre (Admin only).
   
**Task 3: Video Metadata Management**

   **Endpoints**
1. `POST /api/admin/videos`: Upload a new video and associate it with a genre (Admin
   only).
2. `GET /api/videos/{videoId}`: Get details of a specific video.
3. `GET /api/videos`: Get a list of all videos.
4. `GET /api/genres/{genreId}/videos`: Get a list of videos within a specific genre.
5. `PUT /api/admin/videos/{videoId}`: Update video details (Admin only).
6. `DELETE /api/admin/videos/{videoId}`: Delete a video (Admin only).
   
**Task 4: Video Streaming**

   Implement video streaming using Spring WebFlux. For this task, you'll not need additional
   REST endpoints, as streaming will be handled by the video streaming library (e.g., Reactor
   Netty).

**Task 5: Real-time Events with Kafka**

   Integrate Apache Kafka with the application to handle real-time events. You can create
   Kafka topics for different events like:
1. User Likes
2. User Comments
3. Video Uploads
4. Genre Updates


**Kafka Topics**

1. `user_likes`
2. `user_comments`
3. `video_uploads`
4. `genre_updates`


**Task 6: Frontend Development (Optional)**

   For the frontend, you can use any frontend framework of your choice (e.g., React, Angular,
   or HTML) to interact with the backend APIs. You'll need to create frontend components for
   user registration, login, video listing, video streaming, etc.