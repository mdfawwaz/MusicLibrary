import { Component } from '@angular/core';
import { SongService } from '../song.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent{ searchTerm: string = '';
searchResults: any[] = [];

constructor(private songService: SongService) {}

search() {
  // if (this.searchTerm.trim() !== '') {
  //   this.songService.searchSongsByName(this.searchTerm).subscribe(
  //     (results) => {
  //       this.searchResults = results;
  //     },
  //     (error) => {
  //       console.error('Error fetching search results:', error);
  //     }
  //   );
  // } else {
  //   this.searchResults = [];
  // }
}
}
