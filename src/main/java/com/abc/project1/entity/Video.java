package com.abc.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int vid;

    @NotBlank
    private String videoTitle;

    @NotBlank
    private String videoDescription;

    @NotBlank
    private String videoUrl;

    // owning side of mapping
    // default fetch type LAZY
    @ManyToMany(cascade = CascadeType.MERGE) // to merge with already created genre while cascading
    @JoinTable(
            name = "VideoGenreLink",
            joinColumns = {@JoinColumn(name = "vid")},
            inverseJoinColumns = {@JoinColumn(name = "gid")}
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
//    @NotNull  // why its not working?
    private User uploadedBy;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    private Date uploadedAt;

    public Video(String videoTitle, String videoDescription, String videoUrl) {
        this.videoTitle = videoTitle;
        this.videoDescription = videoDescription;
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "Video{" +
                "vid=" + vid +
                ", videoTitle='" + videoTitle + '\'' +
                ", videoDescription='" + videoDescription + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", genres=" + genres.stream().map(Genre::getGenreName).toList() +  // prevent implicit toString invocation on Genre entity
                ", uploadedBy=" + uploadedBy.getUsername() +  // prevent implicit toString invocation on User entity
                ", uploadedAt=" + uploadedAt +
                '}';
    }

    public void addThisGenre(Genre genre) {
        genres.add(genre);
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    @JsonIgnore
    public User getUploadedBy() {
        return uploadedBy;
    }
}
