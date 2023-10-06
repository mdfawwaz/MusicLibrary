import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SongService {
  playlist = { id: 1, name: 'My Playlist', songs: [] };

 
  addToPlaylist(song: any) {
    // // Check if the song is already in the playlist
    // const isSongInPlaylist = this.playlist.songs.some(s => s.id === song.id);

    // if (!isSongInPlaylist) {
    //   // Add the song to the playlist
    //  // this.playlist.songs.push(song);
    // } else {
    //   console.warn('Song is already in the playlist.');
    // }
  }


}

