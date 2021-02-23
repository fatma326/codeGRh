import {Component, Inject, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AgGridAngular} from 'ag-grid-angular';
import {EmployesActionRendererComponent} from '../employes-action-renderer/employes-action-renderer.component';
import {GridOptions} from 'ag-grid-community';
import {UserService} from '../services/user.service';


// @ts-ignore
@Component({
  selector: 'app-employes',
  templateUrl: './employes.component.html',
  styleUrls: ['./employes.component.css']
})
export class EmployesComponent implements OnInit {

  //empoyees grid params
  @ViewChild('agGrid') agGrid: AgGridAngular;
  public context;
  public frameworkComponents;
  public columnDefs;
  public employies: any;
  public employe: any;

  public item: any;
  public roles: any[];
  public role: any[];
  public roleEditMode: any[];

  public submitted = false;
  public mode = 'lister'; //affichage, ajouter, modifier, supprimer
  private gridApi;
  private gridOptins: Partial<GridOptions>;

  //
  //variable pour les roles

  constructor(private httpClient: HttpClient,
              private userService: UserService){
    this.columnDefs = [
      {headerName: 'ID', field: 'idEmploye', sortable: true, filter: true},
      {headerName: 'Nom', field: 'nom', sortable: true, filter: true},
      {headerName: 'Prenom', field: 'prenom', sortable: true, filter: true},
      {headerName: 'Contact', field: 'contact', sortable: true, filter: true},
      {headerName: 'Matricule', field: 'matricule', sortable: true, filter: true},
      {headerName: 'Titre', field: 'titre', sortable: true, filter: true},
      {headerName: 'Adresse', field: 'adresse', hide: true},
      {headerName: 'Etat', field: 'etat', hide: true},
      {headerName: 'Situation Familialle', field: 'situationFamilialle', hide: true},
      {headerName: 'Email', field: 'email', hide: true},
      {headerName: 'Genre', field: 'Genre', hide: true},
      {headerName: 'Numero de Compte', field: 'numeroCompte', hide: true},
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

      cacheBlockSize: 90,
      paginationPageSize: 5,
      pagination: true
    };
  }

  ngOnInit(): void {
    this.userService.getRoles().subscribe((value: any) => {
      this.roles = value;
    }, error => {
      console.log(error);
    })



    //this.rowData = this.httpClient.get('https://raw.githubusercontent.com/ag-grid/ag-grid/master/grid-packages/ag-grid-docs/src/sample-data/smallRowData');
  }

  // tslint:disable-next-line:typedef
  onGetEmployes() {
    this.mode = 'lister';
    this.httpClient.get('http://localhost:8080/employes')
      .subscribe(data => {
        this.employies = data;
      }, err => {
        console.log(err);
      },);
  }

  getEmployes() {
    this.httpClient.get('http://localhost:8080/employes')
      .subscribe(data => {
        this.employies = data;
      }, err => {
        console.log(err);
      },);
  }

  onBtnExport() {
    let exportParams = {
      'fileName': 'employees.csv',
      'allColumns': true
    };
    this.gridApi.exportDataAsCsv(exportParams);
  }

  onGridReady(params) {
    this.gridApi = params.api;
    this.gridApi.sizeColumnsToFit();
  }

  postEmployee() {
    debugger
    this.employe.roles= this.role;
    this.httpClient.post('http://localhost:8080/listemployes', this.employe)
      .subscribe(data => {
        //this.employer = data;
        console.log('l\'employee a ete ajouter !!');
        this.submitted = true;
        this.refreshDataGrid();
      }, err => {
        console.log(err);
      },);
  }

  ajouter() {
    this.mode = 'ajouter';
    this.submitted = false;
    this.employe = {
      'nom': '',
      'prenom': '',
      'adresse': '',
      'contact': '',
      'matricule': '',
      'etat': 1,
      'titre': '',
      'situationFamilialle': '',
      'email': '',
      'genre': 'femme',
      'numeroCompte': null,
      'nni': null,
      username: null,
      password: null
    };
   // this.employe.roles=this.role;
  }

  onRoleChanged($event){
    console.log($event)
    debugger;
  }
  afficher(employe) {
    this.employe = employe;
    this.mode = 'afficher';
  }

  modifier(employe) {
    this.employe = employe;
    this.submitted = false;
    this.mode = 'modifier';
  }

  putEmployee() {
    this.employe.roles=this.roleEditMode;
    this.httpClient.put('http://localhost:8080/listemployes/' + this.employe.idEmploye, this.employe)
      .subscribe(data => {
        //this.employer = data;
        console.log('l\'employee a ete mis a jour !!');
        this.submitted = true;
        this.refreshDataGrid();
      }, err => {
        console.log(err);
      },);
  }

  supprimer(employe) {
    this.employe = employe;
    //this.mode = 'supprimer'
    //const confirmDialog = this.dialog.open(ConfirmDialogComponent, {
    //  data: {
    //    title: 'Confimer la suppression',
    //    message: 'Etes vous sure de vouloir supprimer l\'employe ' + this.employe.nom  + ' ?'
    //  }
    //});
    //confirmDialog.afterClosed().subscribe(result => {
    //  if (result === true) {
    //    console.log("Employee delete confirmed");
    //    this.deleteEmployee()
    //  }
    //});
    this.deleteEmployee();
  }

  deleteEmployee() {
    this.httpClient.delete('http://localhost:8080/listemployes/' + this.employe.idEmploye)
      .subscribe(data => {
        //this.employer = data;
        console.log('l\'employe a ete supprimer !!');
        this.submitted = true;
        this.mode = 'supprimer';
        this.refreshDataGrid();
      }, err => {
        this.submitted = false;
        console.log(err);
      },);
  }

  refreshDataGrid() {
    this.getEmployes();
    this.gridApi.refreshCells();
  }

}
