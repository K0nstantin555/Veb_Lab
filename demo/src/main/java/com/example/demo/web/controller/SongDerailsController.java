package com.example.demo.web.controller;

import com.example.demo.model.Song;
import com.example.demo.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/song-details")
public class SongDerailsController {
    SongService songService;

    public SongDerailsController(SongService songService) {
        this.songService = songService;
    }
    @GetMapping("/{id}")
    public String getSongDetails(@PathVariable Long id, Model model){
        Song song=songService.findSongById(id);
        model.addAttribute("songTitle", song.getTitle());
        model.addAttribute("genre", song.getGenre());
        model.addAttribute("year", song.getReleaseYear());
        model.addAttribute("album", song.getAlbum().getName());
        model.addAttribute("artists", song.getPerformers());
        return "songDetails";
    }
}
