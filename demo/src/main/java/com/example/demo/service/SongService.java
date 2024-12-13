package com.example.demo.service;

import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    void addArtistToSong(Artist artist, Song song);
    Song findByTrackId(String trackId);
    Song findBySongId(Long id);
    void deleteSongById(Long id);
    void addNewSong(String songTitle, String trackId, String genre, int i, Album byId);

    void editSong(Long songId, String songTitle, String trackId, String genre, int i, Album byId);
}
