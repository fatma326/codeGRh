import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';
import {Router} from '@angular/router';
import {JwtHelperService} from '@auth0/angular-jwt';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  jwt: string;
  username: string;
  name: string;
  roles: Array<any>;
  private loginUrl = environment.url + 'login';
  private signUpUrl = environment.url + 'signup';
  private resetUrl = environment.url + 'recover';

  constructor(private http: HttpClient, private router: Router) {
    this.loadToken();
  }

  login(user) {

    return this.http.post(this.loginUrl, user, {observe: 'response'});
  }

  signUp(user) {

    return this.http.post(this.signUpUrl, user);
  }

  saveToken(jwt: string) {
    localStorage.setItem('token', jwt);
    this.jwt = jwt;
    this.parseJWT();
  }

  parseJWT() {

    const jwtHelper = new JwtHelperService();
    const objJWT = jwtHelper.decodeToken(this.jwt);
    this.username = objJWT.sub;
    this.roles = objJWT.roles;
  }

  isAdmin() {
    if (this.roles) {
      const pos = this.roles.map((e) => e.authority).indexOf('ADMIN');
      return pos >= 0;
    } else {
      return false;
    }
  }
  isController() {
    if (this.roles) {
      const pos = this.roles.map((e) => e.authority).indexOf('Controller');
      return pos >= 0;
    } else {
      return false;
    }
  }

  getConnectedUser(){
    this.parseJWT();
    return this.username;
  }

  isAuthenticated() {
    this.jwt = localStorage.getItem('token');
    if(this.jwt) return true;
    else false;
  }

  loadToken() {

    this.jwt = localStorage.getItem('token');
    // this.jwt ? this.parseJWT() : this.logout();
    if (this.jwt) {
      this.parseJWT();
    }
  }

  async logout() {
    localStorage.clear();
    this.username = null;
    this.router.navigateByUrl('/auth/login');
  }

  getToken() {
    return this.jwt;
  }
}
