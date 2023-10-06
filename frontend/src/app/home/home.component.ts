import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AlbumService } from '../album.service';
import { SongService } from '../song.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  albums: any[] = [];

  constructor(private albumService: AlbumService,private router : Router) { }

  ngOnInit() {
    this.albumService.getAllAlbums().subscribe(
      albums => this.albums = albums,
      error => console.error('Error fetching albums', error)
    );
  }

  onAlbumClick(id : number) {
    this.router.navigate(['/song-list',{id:id}]);
  }
}















