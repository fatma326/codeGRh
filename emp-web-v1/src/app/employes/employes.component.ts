import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';

// @ts-ignore
@Component({
  selector: 'app-employes',
  templateUrl: './employes.component.html',
  styleUrls: ['./employes.component.css']
})
export class EmployesComponent implements OnInit {

  public employies: any;
  public employe: any;

  public submitted = false;

  public mode = 'lister'; //affichage, ajouter, modifier, supprimer

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  onGetEmployes() {
    this.mode = 'lister';
this.httpClient.get('http://localhost:8080/employes')
  .subscribe(data => {
    this.employies = data;
  }, err => {
    console.log(err);
  }, );
  }

  postEmployee() {
    this.httpClient.post('http://localhost:8080/listemployes', this.employe)
      .subscribe(data => {
        //this.employer = data;
        console.log("employee a ete ajoute!!")
        this.submitted = true;
      }, err => {
        console.log(err);
      }, );
  }

  ajouterEmployer(){
    this.mode = 'ajouter'
    this.employe = {
      "nom" : '',
      "prenom" : '',
      "adresse" : "",
      "contact" : "",
      "etat" : 1,
      "titre" : "",
      "situationFamilialle" : "",
      "email" : "",
      "genre" : "femme",
      "numeroCompte" : null,
      "nni" : null
    }
  }

  afficherEmployer(employe) {
    this.employe = employe;
    this.mode = 'afficher';
  }

  modifierEmployer(employe) {
    this.employe = employe
    this.mode = 'modifier'
  }

  supprimerEmployer(employe) {
    this.employe = employe;
    this.mode = 'supprimer'
  }
}
