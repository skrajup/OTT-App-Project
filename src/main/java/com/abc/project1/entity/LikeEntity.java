package com.abc.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(uniqueConstraints = @UniqueConstraint(name = "uniqueIdForLike", columnNames = {"fk_videoId", "fk_userId"}))
public class LikeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int likeId;

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

    @JsonIgnore
    public Video getVideo() {
        return video;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }
}
