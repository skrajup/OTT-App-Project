package com.abc.project1.entity;

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
@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
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
    @ManyToMany
    @JoinTable(
            name = "VideoGenreLink",
            joinColumns = { @JoinColumn( name = "vid") },
            inverseJoinColumns = { @JoinColumn( name = "gid" ) }
    )
    private Set<Genre> genres = new HashSet<>();

    @ManyToOne
    private User uploadedBy;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    @NotBlank
    private Date uploadedAt;
}
