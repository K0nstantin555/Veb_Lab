package com.example.demo.service.impl;

import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import com.example.demo.repository.jpa.SongRepository;
import com.example.demo.service.SongService;
import jakarta.transaction.Transactional;
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
        List<Artist> artists = song.getArtists();
        artists.add(artist);
        song.setArtists(artists);
        songRepository.save(song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    public Song findBySongId(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteSongById(Long id) {
        if(id == null) return;
        songRepository.deleteById(id);
    }




    @Override
    public void addNewSong(String title, String trackId, String genre, int releaseYear, Album album) {
        if(title == null || title.isEmpty()
                || trackId == null || trackId.isEmpty()
                || genre == null || genre.isEmpty() || album == null) {
            return;
        }

        songRepository.save(new Song(trackId, title, genre, releaseYear, album));
    }
    @Override
    public void editSong(Long songId, String title, String trackId, String genre, int releaseYear, Album album) {
        if(songId == null
                || title == null || title.isEmpty()
                || trackId == null || trackId.isEmpty()
                || genre == null || genre.isEmpty() || album == null) {
            return;
        }

        Song editedSong = findBySongId(songId);
        editedSong.setTitle(title);
        editedSong.setTrackId(trackId);
        editedSong.setGenre(genre);
        editedSong.setReleaseYear(releaseYear);
        editedSong.setAlbum(album);
        songRepository.save(editedSong);
    }

}