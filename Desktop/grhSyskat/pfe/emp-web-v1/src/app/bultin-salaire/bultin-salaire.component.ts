import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {HttpClient} from '@angular/common/http';
import {MatDialog} from '@angular/material/dialog';
import {EmployesActionRendererComponent} from '../employes-action-renderer/employes-action-renderer.component';
import {UserService} from '../services/user.service';

@Component({
  selector: 'app-bultin-salaire',
  templateUrl: './bultin-salaire.component.html',
  styleUrls: ['./bultin-salaire.component.css']
})
export class BultinSalaireComponent implements OnInit {
  @ViewChild('agGrid') agGrid: AgGridAngular;
  private gridApi;
  public context;
  public frameworkComponents;
  public columnDefs;
  public list: any;
  public item: any;
  bl;
  employes: any[];
  employe: any[];
  date;
  error = null;

  private url  = 'http://localhost:8080/bultinSalaire';

  public submitted = false;

  public mode = 'lister'; //affichage, ajouter, modifier, supprimer

  constructor(private httpClient: HttpClient, private dialog: MatDialog,
              private userService: UserService) {
    this.columnDefs = [
      {headerName: 'totalHeures', field: 'totalHeures', sortable: true, filter: true},
      {headerName: 'heureNormale', field: 'heureNormale', sortable: true, filter: true },
      {headerName: 'heureSup', field: 'heureSup', sortable: true, filter: true },
      {headerName: 'heureSupPrix', field: 'heureSupPrix', sortable: true, filter: true },
      {headerName: 'totalAPayer', field: 'totalAPayer', sortable: true, filter: true },
      {headerName: 'cnam', field: 'cnam', sortable: true, filter: true },
      {headerName: 'sommePrime', field: 'sommePrime', sortable: true, filter: true },
      {headerName: 'salaireBrut', field: 'salaireBrut', sortable: true, filter: true },

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
    this.userService.getUsers().subscribe((value: any) => {
      this.employes = value;
    }, error => {
      console.log(error);
    })
  }

  getData(){
    let emp = this.employe[0];
    this.httpClient.post(this.url, {idEmploye: emp.idEmploye, date: this.date })
      .subscribe(value => {
      this.bl = value;
      this.error = null;
       console.log(value);
    }, error => {
        this.error = 'error ....'
      })
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

  afficher(objet) {
    this.item = objet;
    this.mode = 'afficher';
  }




}
