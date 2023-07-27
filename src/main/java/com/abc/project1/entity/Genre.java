package com.abc.project1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(uniqueConstraints = @UniqueConstraint(name = "uniqueNameForGenre", columnNames = "genreName"))
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Setter(AccessLevel.NONE)
    private int gid;

    @NotBlank
    private String genreName;

    @NotBlank
    private String genreDescription;

    @ManyToMany(mappedBy = "genres")
    // default fetch type LAZY
    private Set<Video> videos = new HashSet<>();

    public Genre(String genreName, String genreDescription) {
        this.genreName = genreName;
        this.genreDescription = genreDescription;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "gid=" + gid +
                ", genreName='" + genreName + '\'' +
                ", genreDescription='" + genreDescription + '\'' +
                ", videos=" + videos.size() + " videos" +
                '}';
    }

    @JsonIgnore
    public Set<Video> getVideos() {
        return videos;
    }
}
