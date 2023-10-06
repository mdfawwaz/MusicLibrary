import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoriesComponent } from './categories/categories.component';
import { FavoritesComponent } from './favorites/favorites.component';
import { HomeComponent } from './home/home.component';
import { RecentComponent } from './recent/recent.component';
import { SearchComponent } from './search/search.component';
import { SongListComponent } from './song-list/song-list.component';
import { YourPlaylistComponent } from './your-playlist/your-playlist.component';
import { LoginComponent } from './login/login.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  //{ path: '',redirectTo : '/home',pathMatch : 'full'},
  { path: 'login', component: LoginComponent },
  { path: 'song-list', component: SongListComponent },
  { path: 'search', component: SearchComponent }, // Create a SearchComponent
  { path: 'recent', component: RecentComponent }, // Create a RecentComponent
  { path: 'categories', component: CategoriesComponent }, // Create a CategoriesComponent
  { path: 'favorites', component: FavoritesComponent }, // Create a FavoritesComponent
  { path: 'your-playlist', component: YourPlaylistComponent } // Create a YourPlaylistComponent
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
