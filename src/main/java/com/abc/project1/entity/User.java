package com.abc.project1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter(AccessLevel.PRIVATE)
@Setter(AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE) // lombok will omit setter for this field.
    private int sid;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Email(message = "Entered email is not valid.", regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
    @NotBlank
    private String email;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    @NotBlank
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Setter(AccessLevel.NONE)
    @NotBlank
    private Date updatedAt;

    // mapping
    @OneToMany(mappedBy = "uploadedBy", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Video> videos = new HashSet<>();
}
