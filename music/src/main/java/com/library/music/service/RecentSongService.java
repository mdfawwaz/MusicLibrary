package com.library.music.service;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
import com.library.music.entity.RecentSong;
import com.library.music.entity.Song;
import com.library.music.repository.RecentSongRepository;
//
//
//
//import java.util.List;
//
//@Service
//public class RecentSongService {
//
//    @Autowired
//    private RecentSongRepository recentSongRepository;
//
//    public void addSongToRecents(Song song) {
//        RecentSong recentSong = new RecentSong();
//        recentSong.setSong(song);
//        recentSongRepository.save(recentSong);
//    }
//
//    public List<RecentSong> getRecentSongs() {
//        return recentSongRepository.findAll();
//    }
//
//
//
//}



import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class RecentSongService {

    private static final int MAX_RECENT_SONGS = 10; // Maximum number of recent songs
    private List<Song> recentSongs = new ArrayList<>();

    public void addRecentSong(Song song) {
        // Check if the song is already in the recentSongs list
        int existingIndex = -1;
        for (int i = 0; i < recentSongs.size(); i++) {
            if (Objects.equals(recentSongs.get(i).getId(), song.getId())) {
                existingIndex = i;
                break;
            }
        }

        if (existingIndex != -1) {
            // If the song is already in the list, move it to the top
            recentSongs.remove(existingIndex);
        } else if (recentSongs.size() >= MAX_RECENT_SONGS) {
            // If the list is full, remove the oldest song (the last one)
            recentSongs.remove(recentSongs.size() - 1);
        }

        // Add the song to the top of the list
        recentSongs.add(0, song);
    }

    public List<Song> getRecentSongs() {
        // Ensure that the list does not exceed the maximum allowed size
        if (recentSongs.size() > MAX_RECENT_SONGS) {
            recentSongs = recentSongs.subList(0, MAX_RECENT_SONGS);
        }
        return recentSongs;
    }

    // Add other methods as needed
}



