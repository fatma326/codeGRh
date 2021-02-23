import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {HttpClient} from '@angular/common/http';
import {MatDialog} from '@angular/material/dialog';
import {EmployesActionRendererComponent} from '../employes-action-renderer/employes-action-renderer.component';
import {GridOptions} from 'ag-grid-community';
import {MatPaginator} from '@angular/material/paginator';
import {EditAvanceSalaireComponent} from '../avance-salaire/edit-avance-salaire/edit-avance-salaire.component';
import {EditCompteComponent} from './edit-compte/edit-compte.component';

@Component({
  selector: 'app-compte',
  templateUrl: './compte.component.html',
  styleUrls: ['./compte.component.css']
})
export class CompteComponent implements OnInit {
  @ViewChild('agGrid') agGrid: AgGridAngular;
  @ViewChild(MatPaginator) paginator: MatPaginator;
  private gridApi;
  public context;
  public frameworkComponents;
  public columnDefs;
  public list: any;
  public item: any;
  private gridOptins: Partial<GridOptions>;

  public submitted = false;

  public mode = 'lister'; //affichage, ajouter, modifier, supprimer

  private url  = 'http://localhost:8080/listDsCmpts';


  constructor(private httpClient: HttpClient, private dialog: MatDialog) {
    this.columnDefs = [
      {headerName: 'idCmpte', field: 'idCmpte', sortable: true, filter: true},
      {headerName: 'numerCmpte', field: 'numerCmpte', sortable: true, filter: true },
      {headerName: 'nomBanque', field: 'nomBanque', sortable: true, filter: true },
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

  post() {
    this.httpClient.post(this.url, this.item)
      .subscribe(data => {
        //this.employer = data;
        console.log("compte a ete ajoute !!")
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
      numerCmpte: "",
      nomBanque: null
    }
    const dialogRef = this.dialog.open(EditCompteComponent, {
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
    const dialogRef = this.dialog.open(EditCompteComponent, {
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
    this.httpClient.delete(this.url + '/'+this.item.idCmpte)
      .subscribe(data => {
        //this.employer = data;
        console.log("compte a ete supprimer !!")
        this.submitted = true;
        this.mode = 'supprimer'
        this.refreshDataGrid();
      }, err => {
        this.submitted = false;
        console.log(err);
      }, );
  }


}
