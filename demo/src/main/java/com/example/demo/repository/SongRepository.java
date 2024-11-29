package com.example.demo.repository;

import com.example.demo.bootstrap.DataHolder;
import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepository {
    public List<Song> findAll(){
        return DataHolder.songs;
    }
    public Song findTrackById(String trackId){
        return DataHolder.songs.stream().filter(x->x.getTrackId().equals(trackId)).findFirst().orElse(null);
    }
    public void addArtistToSong(Artist artist, Song song){
        DataHolder.songs.stream().filter(x->x.getTrackId().equals(song.getTrackId())).findFirst().ifPresent(x->{x.getPerformers().add(artist);});
    }

    public Song findSongById(Long id) {
        return DataHolder.songs.stream().filter(x->x.getId().equals(id)).findFirst().orElse(null);
    }
    public void deleteSong(Long id) {
        DataHolder.songs.removeIf(x->x.getId().equals(id));
    }
    public int getSongIndx(Long id){
        for (int i = 0; i < DataHolder.songs.size(); i++) {
            if (DataHolder.songs.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
    public void saveSong(Song song){
        Song s=findSongById(song.getId());
        if (s==null) DataHolder.songs.add(song);
        else {
            int index=getSongIndx(song.getId());
            DataHolder.songs.set(index, song);
        }
    }
}
