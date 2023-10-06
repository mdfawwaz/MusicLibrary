package com.library.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.music.entity.Song;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    // Custom queries if needed
    List<Song> findByNameContainingIgnoreCase(String name);
    List<Song> findByArtistContainingIgnoreCase(String artist);
    
//    @Query("SELECT s FROM Song s LEFT JOIN FETCH s.category")
//    List<Song> findAllSongsWithCategory();
//    @Query("SELECT s FROM Song s LEFT JOIN FETCH s.category")
//    List<Song> findAll();

    //List<Song> findByAlbum(String albumName);
    List<Song> findByCategoryName(String categoryName);
    //List<Song> findByAlbum_Id(Long albumId);
    List<Song> findByAlbumid(Long albumid);
}












