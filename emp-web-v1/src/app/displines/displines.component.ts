import { Component, OnInit, ViewChild } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';
import { AgGridAngular } from 'ag-grid-angular';
import { EmployesActionRendererComponent } from '../employes-action-renderer/employes-action-renderer.component';

@Component({
  selector: 'app-displines',
  templateUrl: './displines.component.html',
  styleUrls: ['./displines.component.css']
})
export class DisplinesComponent implements OnInit {

  @ViewChild('agGrid') agGrid: AgGridAngular;
  private gridApi;
  public context;
  public frameworkComponents;
  public columnDefs;
  public list: any;
  public item: any;

  private url  = 'http://localhost:8181/DisplineList';

  public submitted = false;

  public mode = 'lister'; //affichage, ajouter, modifier, supprimer

  constructor(private httpClient: HttpClient, private dialog: MatDialog)  {

    this.columnDefs = [
      {headerName: 'ID', field: 'idDispline', sortable: true, filter: true},
      {headerName: 'Nom', field: 'typeDispline', sortable: true, filter: true },
      {headerName: 'Nom superviseur', field: 'nomSuperviseur', sortable: true, filter: true},
      {headerName: 'Date', field: 'date', sortable: true, filter: true,
                          cellRenderer: (data) => {
                                return data.value ? (new Date(data.value)).toLocaleDateString() : '';
                          }
      },
      {headerName: 'Description', field: 'description', sortable: true, filter: true, hide: true},
      {headerName: 'Demande d\'explication ', field: 'demande_explication', sortable: true, filter: true, hide: true},
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
        console.log("l'element a ete ajoute !!")
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
    this.httpClient.put(this.url + '/'+this.item.idDispline, this.item)
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
    this.httpClient.delete(this.url + '/'+this.item.idDispline)
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
