import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AlbumService {
  private apiUrl = 'http://localhost:8080/api/music'; // Replace with your actual API URL

constructor(private http: HttpClient) { }

getAllAlbums(): Observable<string[]> {
  return this.http.get<string[]>(`${this.apiUrl}/home`);
}
}
