import {Component, OnInit, ViewChild} from '@angular/core';
import {AgGridAngular} from 'ag-grid-angular';
import {HttpClient} from '@angular/common/http';
import {MatDialog} from '@angular/material/dialog';
import {EmployesActionRendererComponent} from '../employes-action-renderer/employes-action-renderer.component';
import {FormBuilder, FormGroup} from '@angular/forms';
import {EditComponent} from './edit/edit.component';

@Component({
  selector: 'app-pointage',
  templateUrl: './pointage.component.html',
  styleUrls: ['./pointage.component.css']
})
export class PointageComponent implements OnInit {

  @ViewChild('agGrid') agGrid: AgGridAngular;
  public context;
  public frameworkComponents;
  public columnDefs;
  public list: any;
  public item: any;
  public submitted = false;
  public mode = 'lister'; //affichage, ajouter, modifier, supprimer
  employes: any[];
  private gridApi;
  private url = 'http://localhost:8181/listPointee';


  constructor(private httpClient: HttpClient,
              private fb: FormBuilder, public dialog: MatDialog) {
    this.columnDefs = [
      {headerName: 'ID', field: 'idPointage', sortable: true, filter: true},
      {headerName: 'employe', field: 'employe.nom', sortable: true, filter: true},
      {headerName: 'heures_entree', field: 'heures_entree', sortable: true, filter: true},
      {headerName: 'heures_sortie', field: 'heures_sortie', sortable: true, filter: true},
      {
        headerName: 'Date_Pointage', field: 'date_Pointage', sortable: true, filter: true,
        cellRenderer: (data) => {
          return data.value ? (new Date(data.value)).toLocaleDateString() : '';
        }
      },
      {headerName: 'absence', field: 'absence', sortable: true, filter: true},
      {headerName: 'type_absence ', field: 'type_absence', sortable: true, filter: true},
      {headerName: 'weekend', field: 'weekend', sortable: true, filter: true, hide: true},
      {headerName: 'ferier', field: 'ferier', sortable: true, filter: true, hide: true},

      {
        headerName: 'Action',
        cellRenderer: 'employesActionRenderer',
      },
    ];

    this.context = {componentParent: this};
    this.frameworkComponents = {
      employesActionRenderer: EmployesActionRendererComponent,
    };

  }

  ngOnInit(): void {}


  onGetList() {
    this.mode = 'lister';
    this.getList();
  }

  getList() {
    this.httpClient.get(this.url)
      .subscribe(data => {
        this.list = data;
      }, err => {
        console.log(err);
      },);
  }

  onBtnExport() {
    let exportParams = {
      "fileName": "export.csv",
      "allColumns": true
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
      },);
  }

  refreshDataGrid() {
    this.getList();
    this.gridApi.refreshCells();
  }

  ajouter() {
    this.mode = 'ajouter'
    this.submitted = false;
    this.item = {
      heures_entree: "",
      heures_sortie: "",
      Date_Pointage: "",
      absence: "",
      type_absence: "",
      weekend: "",
      ferier: "",
      employe: null
    };
    const dialogRef = this.dialog.open(EditComponent, {
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
    const dialogRef = this.dialog.open(EditComponent, {
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
    this.httpClient.delete(this.url + '/' + this.item.idPointage)
      .subscribe(data => {
        //this.employer = data;
        console.log("l'object a ete supprimer !!")
        this.submitted = true;
        this.mode = 'supprimer'
        this.refreshDataGrid();
      }, err => {
        this.submitted = false;
        console.log(err);
      },);
  }

}
