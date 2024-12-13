package com.example.demo.web.controller;

import com.example.demo.model.Artist;
import com.example.demo.model.Song;
import com.example.demo.service.ArtistService;
import com.example.demo.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/artist-form")
public class ArtistController {
    ArtistService artistService;
    SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }
    @PostMapping
    public String getAddArtistPage(@RequestParam String trackId, Model model) {
        model.addAttribute("artists", artistService.listArtists().stream()
                .filter(x->!songService.findByTrackId(trackId).getArtists().contains(x)));
        model.addAttribute("songId", trackId);
        return "artistsList";
    }
    @PostMapping("/add/{id}")
    public String addArtist(@PathVariable String id, @RequestParam Long artistId){
        Song song=songService.findByTrackId(id);
        Artist artist=artistService.findById(artistId);
        songService.addArtistToSong(artist, song);
        artistService.addSongToArtist(artist, song);
        return "redirect:/song-details/" + song.getId();
    }
}
