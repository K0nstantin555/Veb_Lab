package com.example.demo.web;

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

@WebServlet(name = "SongListServlet", urlPatterns = "/listSongs")
class SongListServlet extends HttpServlet {
    private final SongService song;
    private final SpringTemplateEngine springTemplateEngine;

    public SongListServlet(SongService song, SpringTemplateEngine springTemplateEngine) {
        this.song = song;
        this.springTemplateEngine = springTemplateEngine;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange exchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(req, resp);

        WebContext context = new WebContext(exchange);
        context.setVariable("songs", song.listSongs());
        springTemplateEngine.process("listSongs.html",context,resp.getWriter());
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String songid = req.getParameter("song");

        if (songid != null && !songid.isEmpty()) {
            resp.sendRedirect("/artists?songId="+songid);
        } else {
            resp.sendRedirect("/listSongs");
        }
    }
}
