package com.library.music.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.music.entity.Category;
import com.library.music.entity.Playlist;
import com.library.music.entity.RecentSong;
import com.library.music.entity.Song;
import com.library.music.repository.SongRepository;
import com.library.music.service.CategoryService;
import com.library.music.service.PlaylistService;
import com.library.music.service.RecentSongService;
import com.library.music.service.SongService;

@RestController
@CrossOrigin
@RequestMapping("/api/music")
public class MusicController {

    @Autowired
    private SongService songService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PlaylistService playlistService;

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private RecentSongService recentSongService;

    // Search for songs by name
    @GetMapping("/songs")
    public List<Song> searchSongsByName(@RequestParam(name = "name") String name) {
        return songService.searchSongsByName(name);
    }

    // @GetMapping("/songs/all")
    // public List<Song> getAllSongsWithCategory() {
    // return songRepository.findAllSongsWithCategory();
    // }
    @GetMapping("/songs/all")
    public List<Song> getAllSongsWithAlbumAndCategory() {
        return songRepository.findAll();
    }

    // Search for songs by artist
    @GetMapping("/songs/artist")
    public List<Song> searchSongsByArtist(@RequestParam(name = "artist") String artist) {
        return songService.searchSongsByArtist(artist);
    }

    // Like a song
    @PostMapping("/songs/{songId}/like")
    public void likeSong(@PathVariable Long songId) {
        songService.likeSong(songId);
    }

    // Retrieve all categories
    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    // Create a new playlist
    @PostMapping("/playlists")
    public Playlist createPlaylist(@RequestBody Playlist playlist) {
        return playlistService.createPlaylist(playlist);
    }

    // Add a song to a playlist
    @PostMapping("/playlists/{playlistId}/add-song/{songId}")
    public void addSongToPlaylist(
            @PathVariable Long playlistId,
            @PathVariable Long songId) {
        playlistService.addSongToPlaylist(playlistId, songId);
    }

    // Retrieve a playlist by ID
    @GetMapping("/playlists/{playlistId}")
    public Playlist getPlaylistById(@PathVariable Long playlistId) {
        return playlistService.getPlaylistById(playlistId);
    }

    @GetMapping("/songs/category/{categoryname}/all")
    public List<Song> getSongsByCategory(@PathVariable String categoryname) {
        return songRepository.findByCategoryName(categoryname);
    }

    @PostMapping("/recents/add")
    public ResponseEntity<String> addSongToRecents(@RequestBody Song song) {
        recentSongService.addRecentSong(song);
        return ResponseEntity.ok("Song added to Recents");
    }

    @GetMapping("/recents")
    public List<Song> getRecentlyPlayedSongs() {
        List<Song> recentSongs = recentSongService.getRecentSongs();
        return recentSongs;
    }

    @GetMapping("songs/{albumid}/all")
    public List<Song> getAllSongsByAlbumid(@PathVariable Long albumid) {
        return songService.getSongsByAlbumid(albumid);
    }

    @GetMapping("/home")
    public Set<String> getAllAlbums() {
        List<Song> songs = songService.getAllSongs();
        Set<String> albumNames = new HashSet<>();
        for (Song song : songs) {
            albumNames.add(song.getAlbum());
        }
        return albumNames;
    }

}
