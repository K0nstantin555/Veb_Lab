package com.example.demo.web;

import com.example.demo.service.ArtistService;
import com.example.demo.service.SongService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.stream.Collectors;

@WebServlet(name = "ArtistServlet", urlPatterns = "/artists")
class ArtistServlet extends HttpServlet {
    private final SongService song;
    private final ArtistService artist;
    private final SpringTemplateEngine springTemplateEngine;

    public ArtistServlet(SongService song, ArtistService artist, SpringTemplateEngine springTemplateEngine) {
        this.song = song;
        this.artist = artist;
        this.springTemplateEngine = springTemplateEngine;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange exchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);

        WebContext context = new WebContext(exchange);
        String songId = req.getParameter("songId");
        context.setVariable("artists", artist.listArtists().stream().filter(x-> !song.findByTrackid(songId).getPerformers().contains(x)).collect(Collectors.toList()));
        context.setVariable("songId", songId);
        springTemplateEngine.process("artistsList.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long artistid=Long.parseLong(req.getParameter("artistId"));
        String songId=req.getParameter("songId");
        song.addArtistToSong(artist.findById(artistid), song.findByTrackid(songId));
        if (songId!=null && !songId.isEmpty()){
            resp.sendRedirect("/songDetails?songId="+songId);
        }
        else resp.sendRedirect("/artist?songId=" +songId);
    }
}
