import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Route, Router } from '@angular/router';


@Component({
  selector: 'app-login-form',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
username : string = "";
password : string = "";


constructor( private authService :AuthService, private route: Router
  ){}

login() : void
{
  this.authService.login(this.username, this.password).subscribe();
  this.route.navigate(['/home']);
}
}