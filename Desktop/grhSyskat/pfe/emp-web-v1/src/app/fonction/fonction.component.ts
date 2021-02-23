import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from "ag-grid-angular";
import {HttpClient} from "@angular/common/http";
import {MatDialog} from "@angular/material/dialog";
import {EmployesActionRendererComponent} from "../employes-action-renderer/employes-action-renderer.component";
import {EditComponent} from '../pointage/edit/edit.component';
import {FormBuilder} from '@angular/forms';
import {EditFonctionComponent} from './edit-fonction/edit-fonction.component';
import {GridOptions} from 'ag-grid-community';

@Component({
  selector: 'app-fonction',
  templateUrl: './fonction.component.html',
  styleUrls: ['./fonction.component.css']
})
export class FonctionComponent implements OnInit {
  //empoyees grid params
  @ViewChild('agGrid') agGrid: AgGridAngular;
  private gridApi;
  public context;
  public frameworkComponents;
  public columnDefs;
  public list: any;
  public item: any;
  private gridOptins: Partial<GridOptions>;

  private url  = 'http://localhost:8080/FonctionList';

  public submitted = false;

  public mode = 'lister'; //affichage, ajouter, modifier, supprimer

  constructor(private httpClient: HttpClient, public dialog: MatDialog) {
    this.columnDefs = [
      {headerName: 'ID', field: 'idFonction', sortable: true, filter: true},
      {headerName: 'Nom', field: 'nom', sortable: true, filter: true },
      {headerName: 'Genre', field: ' genre', sortable: true, filter: true },
      {headerName: 'Date debut', field: 'date_debut', sortable: true, filter: true,

        cellRenderer: (data) => {
          return data.value ? (new Date(data.value)).toLocaleDateString() : '';
        }
      },

      {headerName: 'Date fin', field: 'date_fin', sortable: true, filter: true,
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


    this.gridOptins = {

      cacheBlockSize:90,
      paginationPageSize: 5,
      pagination: true
    }




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



  refreshDataGrid(){
    this.getList();
    this.gridApi.refreshCells();
  }

  ajouter(){
    this.mode = 'ajouter'
    this.submitted = false;
    this.item = {
      nom: "",
      genre:"",
      date_debut: null,
      date_fin: null

    }
    const dialogRef = this.dialog.open(EditFonctionComponent, {
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
    const dialogRef = this.dialog.open(EditFonctionComponent, {
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
    this.httpClient.delete(this.url + '/'+this.item.idFonction)
      .subscribe(data => {
        //this.employer = data;
        console.log("la fonction a ete supprimer !!")
        this.submitted = true;
        this.mode = 'supprimer'
        this.refreshDataGrid();
      }, err => {
        this.submitted = false;
        console.log(err);
      }, );
  }

}

