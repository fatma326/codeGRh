import { Injectable } from '@angular/core';
import {environment} from '../../environments/environment';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DepartementService {

  getParentDepUrl = environment.url + 'depList';
  constructor(private httpClient: HttpClient) {
  }
  getParentDep(){
    return this.httpClient.get(this.getParentDepUrl);
  }
}
