package com.abc.project1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
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
    Set<Video> videos = new HashSet<>();
}
