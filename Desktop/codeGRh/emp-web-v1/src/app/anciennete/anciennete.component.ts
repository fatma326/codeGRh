import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from "ag-grid-angular";
import {HttpClient} from "@angular/common/http";
import {MatDialog} from "@angular/material/dialog";
import {EmployesActionRendererComponent} from "../employes-action-renderer/employes-action-renderer.component";

@Component({
  selector: 'app-anciennete',
  templateUrl: './anciennete.component.html',
  styleUrls: ['./anciennete.component.css']
})
export class AncienneteComponent implements OnInit {
  @ViewChild('agGrid') agGrid: AgGridAngular;
  private gridApi;
  public context;
  public frameworkComponents;
  public columnDefs;
  public list: any;
  public item: any;

  private url  = 'http://localhost:8080/AncienneteList';

  public submitted = false;

  public mode = 'lister'; //affichage, ajouter, modifier, supprimer

  constructor(private httpClient: HttpClient, private dialog: MatDialog) {


    this.columnDefs = [
      {headerName: 'ID', field: 'id', sortable: true, filter: true},
      {headerName: 'pourcentage', field: 'pourcentage', sortable: true, filter: true },
      {headerName: 'debut_tranche', field: 'debut_tranche', sortable: true, filter: true },
      {headerName: 'fin_tranche', field: 'fin_tranche', sortable: true, filter: true },
      {headerName: 'plafondSalarial', field: 'plafondSalarial', sortable: true, filter: true },
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
        console.log("Anciennete a ete ajouter !!")
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
      pourcentage: "",
      debut_tranche:"",
      fin_tranche: "",
      plafondSalarial: ""

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
    this.httpClient.put(this.url + '/'+this.item.id, this.item)
      .subscribe(data => {
        //this.employer = data;
        console.log("Anciennete a ete mis a jour !!")
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
    this.httpClient.delete(this.url + '/'+this.item.id)
      .subscribe(data => {
        //this.employer = data;
        console.log("Anciennete a ete supprimer !!")
        this.submitted = true;
        this.mode = 'supprimer'
        this.refreshDataGrid();
      }, err => {
        this.submitted = false;
        console.log(err);
      }, );
  }
















}
