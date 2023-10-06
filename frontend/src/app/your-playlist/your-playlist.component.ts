import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SongService } from '../song.service';

@Component({
  selector: 'app-your-playlist',
  templateUrl: './your-playlist.component.html',
  styleUrls: ['./your-playlist.component.css']
})
export class YourPlaylistComponent  implements OnInit {

  currentSong: any;

  isPlaying: boolean | undefined;



  albumId: string | undefined;

  album: any;

  songs: any[] = []; // List of songs

  http: any;

  iconStyles: { color: string; } | undefined;

  constructor(private route: ActivatedRoute ,private songService : SongService) { }


  ngOnInit() {

    this.route.paramMap.subscribe(params => {

      const id = params.get('id');
      this.loadAlbum();

    });

  }



  loadAlbum() {

    this.album = { name: 'Album Name' };

    this.songs = [

      { name: 'Kun Faya Kun', isPlaying: false, },

      { name: 'Tinak Dhin Na', isPlaying: false },

      { name: 'Main Raasta', isPlaying: false },

      { name: 'Pasoori', isPlaying: false },

      { name: 'Hukum', isPlaying: false },

      { name: 'Chaleya', isPlaying: false },

      { name: 'Pyar Hota Kayi Baar Hai', isPlaying: false },


    ];

  }

  toggleLike(song: any): void {

    song.isLiked = !song.isLiked;

    if (song.isLiked) {


    } else {

    }

  }

  handleButtonClick(): void {
    this.iconStyles = {
      'color': 'red'
    };
  }

  togglePlayPause(song: any): void {
    // Toggle the isPlaying property of the clicked song
    song.isPlaying = !song.isPlaying;

    // Pause other songs when one is played

    this.songs.forEach((s) => {

      if (s !== song) {

        s.isPlaying = false;

      }

    });

  }

  selectedPlaylistId: number = 1; // Replace with your actual logic to determine the playlist

  removeFromPlaylist(song: any) {
    // // Check if a playlist is selected (you can have your own logic to handle this)
    // if (this.selectedPlaylistId) {
    //   // Call the PlaylistService to add the song to the selected playlist
    //   this.songService.addToPlaylist(this.selectedPlaylistId, song).subscribe(
    //     response => {
    //       // Handle success, e.g., show a success message
    //       console.log(`Song ${song.name} added to the playlist.`);
    //     },
    //     error => {
    //       // Handle error, e.g., show an error message
    //       console.error(`Error adding song to the playlist: ${error}`);
    //     }
    //   );
    // } else {
    //   // Handle case where no playlist is selected
    //   console.warn('No playlist selected.');
    // }
  }
}

