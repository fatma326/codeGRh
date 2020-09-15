import { Component, OnInit, ViewChild } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';
import { AgGridAngular } from 'ag-grid-angular';
import { EmployesActionRendererComponent } from '../employes-action-renderer/employes-action-renderer.component';

@Component({
  selector: 'app-professions',
  templateUrl: './professions.component.html',
  styleUrls: ['./professions.component.css']
})
export class ProfessionsComponent implements OnInit {

      //empoyees grid params
      @ViewChild('agGrid') agGrid: AgGridAngular;
      private gridApi;
      public context;
      public frameworkComponents;
      public columnDefs;
      public list: any;
      public item: any;
    
      private url  = 'http://localhost:8080/ProfessionList';
    
      public submitted = false;
    
      public mode = 'lister'; //affichage, ajouter, modifier, supprimer


  constructor(private httpClient: HttpClient, private dialog: MatDialog)  { 

    this.columnDefs = [
      {headerName: 'ID', field: 'idProfession', sortable: true, filter: true},
      {headerName: 'Nom', field: 'nom', sortable: true, filter: true },
      {headerName: 'Date Debut', field: 'date_debut', sortable: true, filter: true, 
                            cellRenderer: (data) => {
                                  return data.value ? (new Date(data.value)).toLocaleDateString() : '';
                            }
      },
      {headerName: 'Date Fin', field: 'date_fin', sortable: true, filter: true, 
                          cellRenderer: (data) => {
                                return data.value ? (new Date(data.value)).toLocaleDateString() : '';
                          }
      },
      {
        headerName: 'Action',
        cellRenderer: 'employesActionRenderer',
      },
    ];

    this.context = { componentParent: this };
    this.frameworkComponents = {
      employesActionRenderer: EmployesActionRendererComponent,
    };

  }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  onGetList() {
    this.mode = 'lister';
    this.getList();
  }
  
  getList(){
    this.httpClient.get(this.url)
    .subscribe(data => {
      this.list = data;
    }, err => {
      console.log(err);
    }, );
  }

  onBtnExport() {
    let exportParams = {
                          "fileName" : "export.csv",
                          "allColumns" : true
                      }
    this.gridApi.exportDataAsCsv(exportParams);
  }

  onGridReady(params) {
    this.gridApi = params.api;
    this.gridApi.sizeColumnsToFit();
  }

  post() {
    this.httpClient.post(this.url, this.item)
      .subscribe(data => {
        //this.employer = data;
        console.log("la profession a ete ajouter !!")
        this.submitted = true;
        this.refreshDataGrid();
      }, err => {
        console.log(err);
      }, );
  }

  refreshDataGrid(){
    this.getList();
    this.gridApi.refreshCells();
  }

  ajouter(){
    this.mode = 'ajouter'
    this.submitted = false;
    this.item = {
      nom: "",
      date_debut: null,
      date_fin: null
    }
  }

  afficher(objet) {
    this.item = objet;
    this.mode = 'afficher';
  }

  modifier(object) {
    this.item = object
    this.submitted = false;
    this.mode = 'modifier'
  }

  put() {
    this.httpClient.put(this.url + '/'+this.item.idProfession, this.item)
    .subscribe(data => {
      //this.employer = data;
      console.log("type department a ete mis a jour !!")
      this.submitted = true;
      this.refreshDataGrid();
    }, err => {
      console.log(err);
    }, );
  }

  supprimer(object) {
    this.item = object;
    this.delete()
  }

  delete() {
    this.httpClient.delete(this.url + '/'+this.item.idProfession)
    .subscribe(data => {
      //this.employer = data;
      console.log("l'object a ete supprimer !!")
      this.submitted = true;
      this.mode = 'supprimer'
      this.refreshDataGrid();
    }, err => {
      this.submitted = false;
      console.log(err);
    }, );
  }

}
