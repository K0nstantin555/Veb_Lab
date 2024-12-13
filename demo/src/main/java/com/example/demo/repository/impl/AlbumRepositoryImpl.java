//package com.example.demo.repository.impl;
//
//import com.example.demo.bootstrap.DataHolder;
//import com.example.demo.model.Album;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class AlbumRepositoryImpl {
//    public List<Album> findAll(){
//        return DataHolder.albums;
//    }
//    public Optional<Album> findById(Long id){
//        return Optional.ofNullable(DataHolder.albums.stream().filter(x -> x.getId().equals(id)).findFirst().orElse(null));
//    }
//}
