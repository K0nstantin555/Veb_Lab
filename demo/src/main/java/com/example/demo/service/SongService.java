package com.example.demo.service;

import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    void addArtistToSong(Artist artist, Song song);
    public Song findByTrackid(String trackId);
    
    void addNewSong(String songTitle, String trackId, String genre, int releaseYear, Album album);
    void deleteSong(Long id);
    Song findSongById(Long id);
    void editSong(Long id, String songTitle, String trackId, String genre, int releaseYear, Album album);
}
