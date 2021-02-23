import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from "ag-grid-angular";
import {HttpClient} from "@angular/common/http";
import {MatDialog} from "@angular/material/dialog";
import {EmployesActionRendererComponent} from "../employes-action-renderer/employes-action-renderer.component";
import {EditComponent} from '../pointage/edit/edit.component';
import {EditContratComponent} from './edit-contrat/edit-contrat.component';
import {GridOptions} from 'ag-grid-community';

@Component({
  selector: 'app-contrat',
  templateUrl: './contrat.component.html',
  styleUrls: ['./contrat.component.css']
})
export class ContratComponent implements OnInit {

  @ViewChild('agGrid') agGrid: AgGridAngular;
  private gridApi;
  public context;
  public frameworkComponents;
  public columnDefs;
  public list: any;
  public item: any;
  private gridOptins: Partial<GridOptions>;

  private url  = 'http://localhost:8080/ContratList';

  public submitted = false;

  public mode = 'lister'; //affichage, ajouter, modifier, supprimer
  constructor(private httpClient: HttpClient, private dialog: MatDialog) {

    this.columnDefs = [
      {headerName: 'ID', field: 'idContrats', sortable: true, filter: true},
      {headerName: 'EMP', field: 'employe.nom', sortable: true, filter: true},
      {headerName: 'Type contrat', field: 'typeCon.type', sortable: true, filter: true},
      {headerName: 'date_emabauche', field: 'date_emabauche', sortable: true, filter: true,
        cellRenderer: (data) => {
          return data.value ? (new Date(data.value)).toLocaleDateString() : '';
        }
      },


      {headerName: 'mode_reglement', field: 'mode_reglement', sortable: true, filter: true, hide: true},
      {headerName: 'salaire_base', field: 'salaire_base', sortable: true, filter: true, hide: true},


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



  refreshDataGrid(){
    this.getList();
    this.gridApi.refreshCells();
  }

  ajouter(){
    this.mode = 'ajouter'
    this.submitted = false;
    this.item = {
      date_emabauche: null,
      mode_reglement: "",
      salaire_base:""

    };
    const dialogRef = this.dialog.open(EditContratComponent, {
      data: {
        item: this.item,
        btn: 'Ajouter'
      }
    });

    dialogRef.afterClosed().subscribe(result => {
      this.refreshDataGrid();
    });
  }

  afficher(objet) {
    this.item = objet;
    this.mode = 'afficher';
  }

  modifier(object) {
    this.item = object
    this.submitted = false;
    this.mode = 'modifier'
    const dialogRef = this.dialog.open(EditContratComponent, {
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
    this.item = object;
    this.delete()
  }

  delete() {
    this.httpClient.delete(this.url + '/'+this.item.idContrats)
      .subscribe(data => {
        //this.employer = data;
        console.log("contrat a ete supprimer !!")
        this.submitted = true;
        this.mode = 'supprimer'
        this.refreshDataGrid();
      }, err => {
        this.submitted = false;
        console.log(err);
      }, );
  }





}
