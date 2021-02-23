import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProfessionService {

  getProfessionUrl = environment.url + 'ProfessionList';
  constructor(private httpClient: HttpClient) {
  }
  getProfession(){
    return this.httpClient.get(this.getProfessionUrl);
  }




}
