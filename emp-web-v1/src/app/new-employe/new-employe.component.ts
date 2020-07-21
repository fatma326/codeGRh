import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';

@Component({
  selector: 'app-new-employe',
  templateUrl: './new-employe.component.html',
  styleUrls: ['./new-employe.component.css']
})
export class NewEmployeComponent implements OnInit {
  public employer = {
    "nom" : '',
    "prenom" : '',
    "adresse" : "",
    "contact" : "",
    "etat" : 1,
    "titre" : "",
    "situationFamilialle" : "",
    "email" : "",
    "genre" : "femelle",
    "numeroCompte" : null,
    "nni" : null
  };

  submitted = false;

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
  }

  postEmployee() {
      this.httpClient.post('http://localhost:8080/listemployes', this.employer)
        .subscribe(data => {
          //this.employer = data;
          console.log("employee a ete ajoute!!")
          this.submitted = true;
        }, err => {
          console.log(err);
        }, );
  }


  ajoutetNouveau(){
      this.employer =  {
        nom : '',
        prenom : '',
        adresse : '',
        contact : null,
        "etat" : null,
        "titre" : "",
        "situationFamilialle" : "",
        "email" : "",
        "genre" : "",
        "numeroCompte" : null,
        "nni" : null
    }

    this.submitted = false;
  }

}
