package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Song;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Album {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;

    @OneToMany(mappedBy = "album")
    private List<Song> songs = new ArrayList<>();

    public Album(String name, String genre, String releaseYear) {
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}