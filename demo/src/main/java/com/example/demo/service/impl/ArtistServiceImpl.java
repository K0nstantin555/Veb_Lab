package com.example.demo.service.impl;

import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import com.example.demo.repository.jpa.ArtistRepository;
import com.example.demo.service.ArtistService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    @Override
    public void addSongToArtist(Artist artist, Song song) {
        artist.getSongs().add(song);
        artistRepository.save(artist);
    }

    @Override
    public void removeSongFromArtists(Long id) {
        artistRepository.findAll().forEach(artist -> {
            artist.getSongs().removeIf(song -> song.getId().equals(id));
            artistRepository.save(artist);
        });
    }

}