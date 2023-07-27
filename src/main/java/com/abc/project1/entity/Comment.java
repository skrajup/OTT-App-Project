package com.abc.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int commentId;

    @NotBlank
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_videoId", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Video video;
    @Column(name = "fk_videoId")
    private int videoId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_userId", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;
    @Column(name = "fk_userId")
    private int userId;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    @JsonIgnore
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    @JsonIgnore
    private Date updatedAt;

    @JsonIgnore
    public Video getVideo() {
        return video;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }
}
