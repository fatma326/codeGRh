import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../services/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-authentification',
  templateUrl: './authentification.component.html',
  styleUrls: ['./authentification.component.css']
})
export class AuthentificationComponent implements OnInit {

  public employer = {
    username: '',
    password: ''
  };

  submitted = false;

  constructor(private httpClient: HttpClient, private authService: AuthService, private router: Router) {

  }

  ngOnInit(): void { }

  login() {
    this.authService.login(this.employer).subscribe(res => {
      this.authService.saveToken(res.headers.get('authorization'));
      this.router.navigateByUrl('/accueil');
    });
  }

}
