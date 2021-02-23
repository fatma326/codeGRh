import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  getUserUrl = environment.url + 'listemployes';
  getRolesUrl = environment.url + 'roles';
  constructor(private httpClient: HttpClient){
  }
  getUsers(){
    return this.httpClient.get(this.getUserUrl);
  }
  getRoles(){
    return this.httpClient.get(this.getRolesUrl);
  }
}
