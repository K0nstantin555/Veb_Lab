
package com.example.demo.bootstrap;

import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataHolder {
    public static List<Artist> artists=null;
    public static List<Song> songs=null;
    public static List<Album> albums=null;

    @PostConstruct
    public void init(){


        artists = new ArrayList<>();
        artists.add(new Artist("Elena", "Cruz", "Indie Pop"));
        artists.add(new Artist("Jackson", "Rivers", "Jazz Fusion"));
        artists.add(new Artist("Liam", "Patterson", "Classical"));
        artists.add(new Artist("Ava", "Nguyen", "Electronic"));
        artists.add(new Artist("Sofia", "Martinez", "Rockabilly"));

        albums=new ArrayList<>();
        albums.add(new Album("First", "Indie Pop", "2022"));
        albums.add(new Album("Second", "Jazz", "2022"));
        albums.add(new Album("Third", "Classical", "2022"));
        albums.add(new Album("Fourth", "Electronic", "2022"));
        albums.add(new Album("Fifth", "Rockabilly", "2022"));

        songs=new ArrayList<>();
        songs.add(new Song("track1", "42.5", "Indie Pop", 2023, artists.stream().filter(a -> a.getFirstName().equals("Elena") || a.getFirstName().equals("Ava")).collect(Collectors.toList()), albums.get(0)));
        songs.add(new Song("track2", "33.8", "Jazz Fusion", 2022, artists.stream().filter(a -> a.getFirstName().equals("Jackson") || a.getFirstName().equals("Sofia")).collect(Collectors.toList()), albums.get(1)));
        songs.add(new Song("track3", "58.1", "Classical", 2024, artists.stream().filter(a -> a.getFirstName().equals("Sofia")).collect(Collectors.toList()), albums.get(2)));
        songs.add(new Song("track4", "45.6", "Electronic", 2021, artists.stream().filter(a -> a.getFirstName().equals("Liam") || a.getFirstName().equals("Ava")).collect(Collectors.toList()), albums.get(3)));
        songs.add(new Song("track5", "37.4", "Rockabilly", 2023, artists.stream().filter(a -> a.getFirstName().equals("Ava") || a.getFirstName().equals("Elena")).collect(Collectors.toList()), albums.get(4)));
    }


}
