package com.library.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.music.entity.RecentSong;

import java.util.List;

public interface RecentSongRepository extends JpaRepository<RecentSong, Long> {
  
}
