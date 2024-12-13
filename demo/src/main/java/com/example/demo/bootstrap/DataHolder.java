
package com.example.demo.bootstrap;

import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import com.example.demo.repository.jpa.AlbumRepository;
import com.example.demo.repository.jpa.ArtistRepository;
import com.example.demo.repository.jpa.SongRepository;
import com.example.demo.service.ArtistService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists=null;
    public static List<Song> songs=null;
    public static List<Album> albums=null;
    private final AlbumRepository albumRepository;
    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;
    private final ArtistService artistService;

    public DataHolder(AlbumRepository albumRepository, SongRepository songRepository, ArtistRepository artistRepository, ArtistService artistService) {
        this.albumRepository = albumRepository;
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
        this.artistService = artistService;
    }

    @PostConstruct
    public void init(){


        artists = new ArrayList<>();
        artists.add(new Artist("Elena", "Cruz", "Indie Pop"));
        artists.add(new Artist("Jackson", "Rivers", "Jazz Fusion"));
        artists.add(new Artist("Liam", "Patterson", "Classical"));
        artists.add(new Artist("Ava", "Nguyen", "Electronic"));
        artists.add(new Artist("Sofia", "Martinez", "Rockabilly"));
        artistRepository.saveAll(artists);
        albums=new ArrayList<>();
        albums.add(new Album("First", "Indie Pop", "2022"));
        albums.add(new Album("Second", "Jazz", "2022"));
        albums.add(new Album("Third", "Classical", "2022"));
        albums.add(new Album("Fourth", "Electronic", "2022"));
        albums.add(new Album("Fifth", "Rockabilly", "2022"));
        albumRepository.saveAll(albums);
        songs=new ArrayList<>();
        songs.add(new Song("track1", "APT", "Indie Pop", 2023, artists.subList(0, 1), albums.get(0)));
        songs.add(new Song("track2", "ASD", "Jazz Fusion", 2022, artists.subList(2, 3), albums.get(1)));
        songs.add(new Song("track3", "DSA", "Classical", 2024, artists.subList(1, 2), albums.get(2)));
        songs.add(new Song("track4", "HERE", "Electronic", 2021, artists.subList(3, 4), albums.get(3)));
        songs.add(new Song("track5", "UHM", "Rockabilly", 2023, artists.subList(4, 5), albums.get(4)));
        songRepository.saveAll(songs);
        artistService.addSongToArtist(artists.get(0), songs.get(0));
    }


}
