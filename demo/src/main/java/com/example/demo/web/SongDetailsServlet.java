package com.example.demo.web;

import com.example.demo.model.Song;
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

@WebServlet(name="SongDetails", urlPatterns = "/songDetails")
class SongDetailsServlet extends HttpServlet {
    private final SongService songService;
    private final SpringTemplateEngine springTemplateEngine;

    public SongDetailsServlet(SongService songService, SpringTemplateEngine springTemplateEngine) {
        this.songService = songService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange iWebExchange= JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
        WebContext context=new WebContext(iWebExchange);
        String songId=req.getParameter("songId");
        Song song=songService.findByTrackId(songId);
        context.setVariable("songTitle", song.getTitle());
        context.setVariable("genre", song.getGenre());
        context.setVariable("year", song.getReleaseYear());
        context.setVariable("artists", song.getArtists());
        springTemplateEngine.process("songDetails.html",context,resp.getWriter());

    }
}
