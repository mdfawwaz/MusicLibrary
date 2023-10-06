//package com.library.music.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.library.music.entity.Album;
//import com.library.music.repository.AlbumRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AlbumService {
//
//    @Autowired
//    private AlbumRepository albumRepository;
//
//    public List<Album> getAllAlbums() {
//        return albumRepository.findAll();
//    }
//
//    public Optional<Album> getAlbumById(Long albumId) {
//        return albumRepository.findById(albumId);
//    }
//
//    // Custom method not needed for retrieving by albumId
//}
