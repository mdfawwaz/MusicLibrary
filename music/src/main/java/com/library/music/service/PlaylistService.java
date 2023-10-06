package com.library.music.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.music.entity.Playlist;
import com.library.music.entity.Song;
import com.library.music.repository.PlaylistRepository;
import com.library.music.repository.SongRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private SongRepository songRepository;

    // Method to create a new playlist
    public Playlist createPlaylist(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    // Method to add a song to a playlist
    public void addSongToPlaylist(Long playlistId, Long songId) {
        Optional<Playlist> optionalPlaylist = playlistRepository.findById(playlistId);
        Optional<Song> optionalSong = songRepository.findById(songId);

        if (optionalPlaylist.isPresent() && optionalSong.isPresent()) {
            Playlist playlist = optionalPlaylist.get();
            Song song = optionalSong.get();

            // Check if the song is not already in the playlist
            if (!playlist.getSongs().contains(song)) {
                playlist.getSongs().add(song);
                playlistRepository.save(playlist);
            }
        } else {
            throw new EntityNotFoundException("Playlist or Song not found");
        }
    }

    // Method to retrieve a playlist by ID
    public Playlist getPlaylistById(Long playlistId) {
        return playlistRepository.findById(playlistId)
                .orElseThrow(() -> new EntityNotFoundException("Playlist not found with ID: " + playlistId));
    }

    // You can add more methods for additional playlist-related operations as needed
}
