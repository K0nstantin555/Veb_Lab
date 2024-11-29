package com.example.demo.repository;

import com.example.demo.bootstrap.DataHolder;
import com.example.demo.model.Album;
import com.example.demo.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepository {
    public List<Album> findAll(){
        return DataHolder.albums;
    }
    public Album findById(Long id){
        return DataHolder.albums.stream().filter(x->x.getId().equals(id)).findFirst().orElse(null);
    }
}
