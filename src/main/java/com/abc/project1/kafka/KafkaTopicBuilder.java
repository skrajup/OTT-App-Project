package com.abc.project1.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicBuilder {

    @Bean
    public NewTopic createVideoUploadsTopic(){
        return TopicBuilder.name("video_uploades").partitions(50).build();
    }

    @Bean
    public NewTopic createGenreUpdatesTopic(){
        return TopicBuilder.name("genre_updates").partitions(50).build();
    }

    @Bean
    public NewTopic createUserLikesTopic(){
        return TopicBuilder.name("user_likes").partitions(50).build();
    }

    @Bean
    public NewTopic createUserCommentsTopic(){
        return TopicBuilder.name("user_comments").partitions(50).build();
    }
}
