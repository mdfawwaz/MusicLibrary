package com.library.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.music.entity.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    // Custom queries if needed
}
