package com.example.demo.web.controller;

import com.example.demo.model.Song;
import com.example.demo.service.AlbumService;
import com.example.demo.service.ArtistService;
import com.example.demo.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService ;
    private final AlbumService albumService;
    private final ArtistService artistService;


    public SongController(SongService songService, AlbumService albumService, ArtistService artistService) {
        this.songService = songService;
        this.albumService = albumService;
        this.artistService = artistService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("songs", songService.listSongs());
        model.addAttribute("albums", albumService.findAll());
        model.addAttribute("error", error);
        return "listSongs";
    }

    @PostMapping("/add")
    public String saveSong(@RequestParam String songTitle,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam String releaseYear,
                           @RequestParam Long albumId) {

        songService.addNewSong(songTitle, trackId, genre, Integer.parseInt(releaseYear), albumService.findById(albumId));
        return "redirect:/songs";
    }


    @PostMapping("/edit/{songId}")
    public String editSong(@PathVariable Long songId,
                           @RequestParam String songTitle,
                           @RequestParam String trackId,
                           @RequestParam String genre,
                           @RequestParam String releaseYear,
                           @RequestParam Long albumId){
        songService.editSong(songId, songTitle, trackId, genre, Integer.parseInt(releaseYear), albumService.findById(albumId));
        return "redirect:/songs";
    }
    @PostMapping("/delete/{id}")
    public String deleteSong(@PathVariable Long id){
        artistService.removeSongFromArtists(id);
        songService.deleteSongById(id);
        return "redirect:/songs";
    }
    @GetMapping("/edit-form/{id}")
    public String getEditSongForm(@PathVariable Long id, Model model){
        model.addAttribute("albums", albumService.findAll());
        Song song=songService.findBySongId(id);
        model.addAttribute("song", song);
        model.addAttribute("songId", id);
        return "add-song";
    }
    @GetMapping("/add-form")
    public String getAddSongPage(Model model) {
        model.addAttribute("albums", albumService.findAll());
        return "add-song";
    }

}
