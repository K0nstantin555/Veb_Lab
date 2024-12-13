//package com.example.demo.repository.impl;
//
//import com.example.demo.bootstrap.DataHolder;
//import com.example.demo.model.Artist;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class ArtistRepositoryImpl {
//    public List<Artist> findAll(){
//        return DataHolder.artists;
//    }
//    public Optional<Artist> findById(Long id){
//        return Optional.ofNullable(DataHolder.artists.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null));
//    }
//}
