package com.library.music.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.music.entity.Song;
import com.library.music.repository.SongRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SongService {

    @Autowired
    private SongRepository songRepository;

    // Method to add a new song
    public Song addSong(Song song) {
        return songRepository.save(song);
    }

    // Method to search for songs by name
    public List<Song> searchSongsByName(String name) {
        return songRepository.findByNameContainingIgnoreCase(name);
    }

    // Method to search for songs by artist
    public List<Song> searchSongsByArtist(String artist) {
        return songRepository.findByArtistContainingIgnoreCase(artist);
    }

    // Method to like a song
    public void likeSong(Long songId) {
        Optional<Song> optionalSong = songRepository.findById(songId);
        if (optionalSong.isPresent()) {
            Song song = optionalSong.get();
            // Implement your logic for liking a song (e.g., increment a like count)
            // song.setLikes(song.getLikes() + 1);
            songRepository.save(song);
        } else {
            throw new EntityNotFoundException("Song not found with ID: " + songId);
        }
    }
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }
    public List<Song> getSongsByAlbumid(Long albumid) {
        
        return songRepository.findByAlbumid(albumid);
    }

    // You can add more methods for additional song-related operations as needed
}

