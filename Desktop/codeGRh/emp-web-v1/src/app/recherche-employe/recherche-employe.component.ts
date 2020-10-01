import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';


@Component({
  selector: 'app-recherche-employe',
  templateUrl: './recherche-employe.component.html',
  styleUrls: ['./recherche-employe.component.css']
})
export class RechercheEmployeComponent implements OnInit {

  public afficherResultat = false;

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    //this.getEmployes()
  }



}
