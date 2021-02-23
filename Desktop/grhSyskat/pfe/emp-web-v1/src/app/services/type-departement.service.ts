import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TypeDepartementService {
  getTypeDepartementUrl = environment.url + 'typeDepList';
  constructor(private httpClient: HttpClient) {
  }
  getTypeDepartement(){
    return this.httpClient.get(this.getTypeDepartementUrl);
  }

}
