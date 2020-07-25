import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';

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

  public mode = 'lister'; // affichage, ajouter, modifier, supprimer

  constructor(private httpClient: HttpClient, private dialog: MatDialog) { }

  ngOnInit(): void {
  }


  // tslint:disable-next-line:typedef
  onGetEmployes() {
    this.mode = 'lister';
    this.httpClient.get('http://localhost:8181/employes')
  .subscribe(data => {
    this.employies = data;
  }, err => {
    console.log(err);
  }, );
  }

  postEmployee() {
    this.httpClient.post('http://localhost:8181/listemployes', this.employe)
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
    this.submitted = false;
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
    this.employe = employe;';'
    this.submitted = false;
    this.mode = 'modifier'
  }

  putEmployee() {
    this.httpClient.put('http://localhost:8181/listemployes/'+this.employe.idEmploye, this.employe)
    .subscribe(data => {
      //this.employer = data;
      console.log("employee a ete mis a jour!!")
      this.submitted = true;
    }, err => {
      console.log(err);
    }, );
  }

  supprimerEmployer(employe) {
    this.employe = employe;
    //this.mode = 'supprimer'
    const confirmDialog = this.dialog.open(ConfirmDialogComponent, {
      data: {
        title: 'Confimer la suppression',
        message: 'Etes vous sure de vouloir supprimer l\'employe ' + this.employe.nom  + ' ?'
      }
    });
    confirmDialog.afterClosed().subscribe(result => {
      if (result === true) {
        console.log("Employee delete confirmed");
        this.deleteEmployee()
      }
    });

  }

  deleteEmployee() {
    this.httpClient.delete('http://localhost:8181/listemployes/'+this.employe.idEmploye)
    .subscribe(data => {
      //this.employer = data;
      console.log("employee a ete supprimer!!")
      this.submitted = true;
      this.mode = 'supprimer'
    }, err => {
      this.submitted = false;
      console.log(err);
    }, );
  }


}
