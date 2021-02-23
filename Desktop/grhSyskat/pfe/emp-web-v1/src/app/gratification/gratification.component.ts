import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {HttpClient} from '@angular/common/http';
import {MatDialog} from '@angular/material/dialog';
import {EditPrimeVComponent} from '../primevariable/edit-prime-v/edit-prime-v.component';
import {EditGratifComponent} from './edit-gratif/edit-gratif.component';
import {EmployesActionRendererComponent} from '../employes-action-renderer/employes-action-renderer.component';
import {GridOptions} from 'ag-grid-community';

@Component({
  selector: 'app-gratification',
  templateUrl: './gratification.component.html',
  styleUrls: ['./gratification.component.css']
})
export class GratificationComponent implements OnInit {
  @ViewChild('agGrid') agGrid: AgGridAngular;
  private gridApi;
  public context;
  public frameworkComponents;
  public columnDefs;
  public list: any;
  public item: any;

  private url  = 'http://localhost:8080/listPrimeV';

  public submitted = false;
  private gridOptins: Partial<GridOptions>;


  public mode = 'lister'; //affichage, ajouter, modifier, supprimer


  constructor(private httpClient: HttpClient, private dialog: MatDialog) {

    this.columnDefs = [

      {headerName: 'ID', field: 'idprimeV', sortable: true, filter: true},
      {
        headerName: 'Date', field: 'date_primeVr', sortable: true, filter: true,
        cellRenderer: (data) => {
          return data.value ? (new Date(data.value)).toLocaleDateString() : '';
        }
      },
      {headerName: 'Forfait', field: 'valeur_prime', sortable: true, filter: true},

      {
        headerName: 'Action',
        cellRenderer: 'employesActionRenderer',
      },
    ];

    this.context = {componentParent: this};
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
      date_primeVr:"",
      valeur_prime:"",
    }
    const dialogRef = this.dialog.open(EditGratifComponent, {
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
    const dialogRef = this.dialog.open(EditGratifComponent, {
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
    this.httpClient.delete(this.url + '/'+this.item.idprimeV)
      .subscribe(data => {
        //this.employer = data;
        console.log("gratification a ete supprimer!!")
        this.submitted = true;
        this.mode = 'supprimer'
        this.refreshDataGrid();
      }, err => {
        this.submitted = false;
        console.log(err);
      }, );
  }

}
