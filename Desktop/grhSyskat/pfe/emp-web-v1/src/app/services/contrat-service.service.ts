import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ContratServiceService {
  getContUrl = environment.url + 'typeConList';
  constructor(private httpClient: HttpClient) {
  }
    getTypeCont(){
      return this.httpClient.get(this.getContUrl);
    }

}

