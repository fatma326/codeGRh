import { Component } from '@angular/core';
import {AuthService} from './services/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'emp-web-v1';
  username;
  constructor(private authService: AuthService, private router:Router){
  }

  isAuthenticated(){
    return this.authService.isAuthenticated();
  }

  onLogout() {
    this.authService.logout();
    this.router.navigate(["/auth"])
  }

  getUsername(){
    return this.authService.getConnectedUser();
  }
}
