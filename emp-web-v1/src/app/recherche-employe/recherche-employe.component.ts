import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';


@Component({
  selector: 'app-recherche-employe',
  templateUrl: './recherche-employe.component.html',
  styleUrls: ['./recherche-employe.component.css']
})
export class RechercheEmployeComponent implements OnInit {
  public employees: any;
  public recherche = {
                        "nom" : "",
                        "prenom" : "",
                        "nni" : ""
                      };

  public afficherResultat = false;

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    //this.getEmployes()
  }

  rechercher() {
    this.httpClient.get('http://localhost:8080/recherche-employes', {params: this.recherche})
    .subscribe(data => {
      this.employees = data;
      this.afficherResultat = true;
    }, err => {
      console.log(err);
    }, );
  }

}
