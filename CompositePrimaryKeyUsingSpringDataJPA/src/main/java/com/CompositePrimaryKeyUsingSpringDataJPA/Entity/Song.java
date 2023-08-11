package com.CompositePrimaryKeyUsingSpringDataJPA.Entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Song {

    @EmbeddedId
    private SongId songId;

    private Integer duration;

    private String genre;

    private LocalDate releaseDate;

    private Integer rating;

    private String downloadUrl;

}
