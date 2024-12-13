package com.example.demo.service;

import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    Artist findById(Long id);
    List<Artist> listArtists();
    void addSongToArtist(Artist artist, Song song);
    void removeSongFromArtists(Long id);
}
