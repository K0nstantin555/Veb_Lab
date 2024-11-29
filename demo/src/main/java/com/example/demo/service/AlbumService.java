package com.example.demo.service;

import com.example.demo.model.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> findAll();
    Album findById(Long id);
}
