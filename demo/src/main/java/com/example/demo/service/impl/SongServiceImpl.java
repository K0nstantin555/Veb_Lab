package com.example.demo.service.impl;

import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import com.example.demo.repository.SongRepository;
import com.example.demo.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public void addArtistToSong(Artist artist, Song song) {
        songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackid(String trackId) {
        return songRepository.findTrackById(trackId);
    }


    @Override
    public void addNewSong(String songTitle, String trackId, String genre, int releaseYear, Album album) {
        if(songTitle == null || songTitle.isEmpty() ||
        trackId==null || trackId.isEmpty() || genre==null || genre.isEmpty() || album==null)
            return;
        songRepository.saveSong(new Song(trackId, songTitle, genre, releaseYear, album));
    }
    @Override
    public void deleteSong(Long id) {
        if (id==null) return;
        songRepository.deleteSong(id);
    }

    @Override
    public Song findSongById(Long id) {
        return songRepository.findSongById(id);
    }

    @Override
    public void editSong(Long id, String songTitle, String trackId, String genre, int releaseYear, Album album) {
        if(songTitle == null || songTitle.isEmpty() ||
                trackId==null || trackId.isEmpty() || genre==null || genre.isEmpty() || album==null)
            return;
        Song newSong=findSongById(id);
        newSong.setTitle(songTitle);
        newSong.setTrackId(trackId);
        newSong.setGenre(genre);
        newSong.setReleaseYear(releaseYear);
        newSong.setAlbum(album);
        songRepository.saveSong(newSong);
    }

}
