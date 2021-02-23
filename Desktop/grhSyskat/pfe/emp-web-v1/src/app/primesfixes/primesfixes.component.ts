import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {HttpClient} from '@angular/common/http';
import {MatDialog} from '@angular/material/dialog';
import {EmployesActionRendererComponent} from '../employes-action-renderer/employes-action-renderer.component';
import {EditFonctionComponent} from '../fonction/edit-fonction/edit-fonction.component';
import {EditPrimesfixesComponent} from './edit-primesfixes/edit-primesfixes.component';
import {GridOptions} from 'ag-grid-community';

@Component({
  selector: 'app-primesfixes',
  templateUrl: './primesfixes.component.html',
  styleUrls: ['./primesfixes.component.css']
})
export class PrimesfixesComponent implements OnInit {

  @ViewChild('agGrid') agGrid: AgGridAngular;
  private gridApi;
  public context;
  public frameworkComponents;
  public columnDefs;
  public list: any;
  public item: any;
  private gridOptins: Partial<GridOptions>;

  private url  = 'http://localhost:8080/listPrimeF';

  public submitted = false;

  public mode = 'lister'; //affichage, ajouter, modifier, supprimer

  constructor(private httpClient: HttpClient, private dialog: MatDialog)  {

    this.columnDefs = [
      {headerName: 'ID', field: 'idprimeF', sortable: true, filter: true},
      {headerName: 'Nom Prime', field: 'nomPrime', sortable: true, filter: true },
      {headerName: 'date primefx', field: 'date_primefx', sortable: true, filter: true,
        cellRenderer: (data) => {
          return data.value ? (new Date(data.value)).toLocaleDateString() : '';
        }
      },
      {headerName: 'Code Prime', field: 'code_Prime', sortable: true, filter: true },
      {headerName: 'valeur prime', field: 'valeur_prime', sortable: true, filter: true},
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
        console.log("prime fixe  a ete ajoute !!")
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
      IdprimeF:"",
      nomPrime:"",
      date_primefx:"",
      code_Prime:"",
      valeur_prime:""
    }
    const dialogRef = this.dialog.open(EditPrimesfixesComponent, {
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
    const dialogRef = this.dialog.open(EditPrimesfixesComponent, {
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
    this.httpClient.delete(this.url + '/'+this.item.idprimeF)
      .subscribe(data => {
        //this.employer = data;
        console.log("prime fixe a ete supprimer !!")
        this.submitted = true;
        this.mode = 'supprimer'
        this.refreshDataGrid();
      }, err => {
        this.submitted = false;
        console.log(err);
      }, );
  }

}
