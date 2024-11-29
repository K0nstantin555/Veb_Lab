package com.example.demo.repository;

import com.example.demo.bootstrap.DataHolder;
import com.example.demo.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArtistRepository {
    public List<Artist> findAll(){
        return DataHolder.artists;
    }
    public Artist findById(Long id){
        return DataHolder.artists.stream().filter(x->x.getId().equals(id)).findFirst().orElse(null);
    }
}
