import { Component, OnInit, ViewChild } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDialogComponent } from '../confirm-dialog/confirm-dialog.component';
import { AgGridAngular } from 'ag-grid-angular';
import { EmployesActionRendererComponent } from '../employes-action-renderer/employes-action-renderer.component';
import {EditPretsComponent} from '../prets/edit-prets/edit-prets.component';
import {EditTypeContratsComponent} from './edit-type-contrats/edit-type-contrats.component';
import {GridOptions} from 'ag-grid-community';

@Component({
  selector: 'app-contrats',
  templateUrl: './contrats.component.html',
  styleUrls: ['./contrats.component.css']
})
export class ContratsComponent implements OnInit {

    //empoyees grid params
    @ViewChild('agGrid') agGrid: AgGridAngular;
    private gridApi;
    public context;
    public frameworkComponents;
    public columnDefs;
    public contrats: any;
    public contrat: any;
    public item: any;
    private gridOptins: Partial<GridOptions>;
    public submitted = false;

    public mode = 'lister'; //affichage, ajouter, modifier, supprimer
     private url  = 'http://localhost:8080/typeConList';

  constructor(private httpClient: HttpClient, private dialog: MatDialog)  {

    this.columnDefs = [
      {headerName: 'ID', field: 'id', sortable: true, filter: true},
      {headerName: 'Numero', field: 'numero', sortable: true, filter: true },
      {headerName: 'Type', field: 'type', sortable: true, filter: true },
      {
        headerName: 'Action',
        cellRenderer: 'employesActionRenderer',
      },
    ];

    this.context = { componentParent: this };
    this.frameworkComponents = {
      employesActionRenderer: EmployesActionRendererComponent,
    };

    this.gridOptins = {

      cacheBlockSize:90,
      paginationPageSize: 5,
      pagination: true
    }

  }

  ngOnInit(): void {
  }

  // tslint:disable-next-line:typedef
  onGetContrats() {
    this.mode = 'lister';
    this.getContrats();
  }

  getContrats(){
    this.httpClient.get('http://localhost:8080/typeConList')
    .subscribe(data => {
      this.contrats = data;
    }, err => {
      console.log(err);
    }, );
  }

  onBtnExport() {
    let exportParams = {
                          "fileName" : "contrats.csv",
                          "allColumns" : true
                      }
    this.gridApi.exportDataAsCsv(exportParams);
  }

  onGridReady(params) {
    this.gridApi = params.api;
    this.gridApi.sizeColumnsToFit();
  }

  post() {
    this.httpClient.post('http://localhost:8080/typeConList', this.contrat)
      .subscribe(data => {
        //this.employer = data;
        console.log("contrat a ete ajouter !!")
        this.submitted = true;
        this.refreshDataGrid();
      }, err => {
        console.log(err);
      }, );
  }

  refreshDataGrid(){
    this.getContrats();
    this.gridApi.refreshCells();
  }

  ajouter() {
    this.mode = 'ajouter'
    this.submitted = false;
    this.contrat = {
      numero: null,
      type: ""

    }


    const dialogRef = this.dialog.open(EditTypeContratsComponent, {
      data: {
        item: this.item,
        btn: 'Ajouter'
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      this.refreshDataGrid();
    });


  }


  afficher(contrat) {
    this.contrat = contrat;
    this.mode = 'afficher';
  }

  modifier(object) {
    this.contrat = object
    this.submitted = false;
    this.mode = 'modifier'
  const dialogRef = this.dialog.open(EditTypeContratsComponent, {
    data: {
      item: this.item,
      btn: 'Mettre A jour'
    }
  });

  dialogRef.afterClosed().subscribe(result => {
    this.refreshDataGrid();
  });
  }


  supprimer(object) {
    this.contrat = object;
    this.delete()
  }

  delete() {
    this.httpClient.delete('http://localhost:8080/typeConList/'+this.contrat.id)
    .subscribe(data => {
      //this.employer = data;
      console.log("le type du contrat a ete supprimer !!")
      this.submitted = true;
      this.mode = 'supprimer'
      this.refreshDataGrid();
    }, err => {
      this.submitted = false;
      console.log(err);
    }, );
  }


}
