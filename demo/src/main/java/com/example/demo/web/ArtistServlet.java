//package com.example.demo.web;
//
//import com.example.demo.model.Artist;
//import com.example.demo.service.ArtistService;
//import com.example.demo.service.SongService;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@WebServlet(name = "ArtistServlet", urlPatterns = "/artists")
//class ArtistServlet extends HttpServlet {
//    private final SongService song;
//    private final ArtistService artists;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public ArtistServlet(SongService song, ArtistService artist, SpringTemplateEngine springTemplateEngine) {
//        this.song = song;
//        this.artists = artist;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange exchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);
//
//        WebContext context = new WebContext(exchange);
//        String songId = req.getParameter("songId");
//        context.setVariable("artists", artists.findAll().stream().filter(x-> !song.findByTrackId(songId)
//                .getArtists().contains(x)).collect(Collectors.toList()));
//        context.setVariable("songId", songId);
//        springTemplateEngine.process("artistsList.html",context,resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        long artistid=Long.parseLong(req.getParameter("artistId"));
//        String songId=req.getParameter("songId");
//        Optional<Artist> artist1=artists.findById(artistid);
//        song.addArtistToSong(artist1.orElse(null), song.findByTrackId(songId));
//        if (songId!=null && !songId.isEmpty()){
//            resp.sendRedirect("/songDetails?songId="+songId);
//        }
//        else resp.sendRedirect("/artist?songId=" +songId);
//    }
//}
