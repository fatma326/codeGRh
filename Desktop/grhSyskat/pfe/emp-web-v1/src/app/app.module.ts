import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployesComponent } from './employes/employes.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { RechercheEmployeComponent } from './recherche-employe/recherche-employe.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ConfirmDialogComponent } from './confirm-dialog/confirm-dialog.component';
import { MatDialogModule } from '@angular/material/dialog';
import { AgGridModule } from 'ag-grid-angular';
import { EmployesActionRendererComponent } from './employes-action-renderer/employes-action-renderer.component';
import { ContratsComponent } from './type_contrats/contrats.component';
import { DepartementsComponent } from './departements/departements.component';
import { ProfessionsComponent } from './professions/professions.component';
import { DisplinesComponent } from './displines/displines.component';
import { FonctionComponent } from './fonction/fonction.component';
import { CnamComponent } from './cnam/cnam.component';
import { ItsComponent } from './its/its.component';
import { AncienneteComponent } from './anciennete/anciennete.component';
import { CnssComponent } from './cnss/cnss.component';
import { CongesComponent } from './conges/conges.component';
import { LicenciementComponent } from './licenciement/licenciement.component';
import { ContratComponent } from './contrat/contrat.component';
import { DepartementComponent } from './departement/departement.component';
import { AccueilComponent } from './accueil/accueil.component';
import { PointageComponent } from './pointage/pointage.component';
import { EditComponent } from './pointage/edit/edit.component';
import { PretsComponent } from './prets/prets.component';
import { CompteComponent } from './compte/compte.component';
import { AvanceSalaireComponent } from './avance-salaire/avance-salaire.component';
import { PrimesfixesComponent } from './primesfixes/primesfixes.component';
import { PrimevariableComponent } from './primevariable/primevariable.component';


import {MultiSelectModule} from 'primeng/multiselect';
import { EditFonctionComponent } from './fonction/edit-fonction/edit-fonction.component';
import { EditAvanceSalaireComponent } from './avance-salaire/edit-avance-salaire/edit-avance-salaire.component';
import { EditPretsComponent } from './prets/edit-prets/edit-prets.component';
import { EditContratComponent } from './contrat/edit-contrat/edit-contrat.component';
import { DeptsComponent } from './depts/depts.component';
import { ContsComponent } from './conts/conts.component';
import { EditPrimeVComponent } from './primevariable/edit-prime-v/edit-prime-v.component';
import { EditTypeContratsComponent } from './type_contrats/edit-type-contrats/edit-type-contrats.component';
import { EditPrimesfixesComponent } from './primesfixes/edit-primesfixes/edit-primesfixes.component';
import { EditCompteComponent } from './compte/edit-compte/edit-compte.component';
import { EditCongesComponent } from './conges/edit-conges/edit-conges.component';
import { BultinSalaireComponent } from './bultin-salaire/bultin-salaire.component';
import { GratificationComponent } from './gratification/gratification.component';
import { EditGratifComponent } from './gratification/edit-gratif/edit-gratif.component';
import { EditDisplinesComponent} from './displines/edit-displines/edit-displines.component';
import { EditLicenciementComponent } from './licenciement/edit-licenciement/edit-licenciement.component';
import { EditDepartementComponent } from './departement/edit-departement/edit-departement.component';
import {NgxPrintModule} from 'ngx-print';
import { AuthentificationComponent } from './authentification/authentification.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployesComponent,
    RechercheEmployeComponent,
    ConfirmDialogComponent,
    EmployesActionRendererComponent,
    ContratsComponent,
    DepartementsComponent,
    ProfessionsComponent,
    DisplinesComponent,
    FonctionComponent,
    CnamComponent,
    ItsComponent,
    AncienneteComponent,
    CnssComponent,
    CongesComponent,
    LicenciementComponent,
    ContratComponent,
    DepartementComponent,
    AccueilComponent,
    PointageComponent,
    PretsComponent,
    EditComponent,
    CompteComponent,
    AvanceSalaireComponent,
    PrimesfixesComponent,
    PrimevariableComponent,
    EditFonctionComponent,
    EditAvanceSalaireComponent,
    EditPretsComponent,
    EditContratComponent,
    EditDisplinesComponent,
    DeptsComponent,
    ContsComponent,
    EditPrimeVComponent,
    EditTypeContratsComponent,
    EditPrimesfixesComponent,
    EditCompteComponent,
    EditCongesComponent,
    BultinSalaireComponent,
    GratificationComponent,
    EditGratifComponent,
    EditLicenciementComponent,
    EditDepartementComponent,
    AuthentificationComponent,
  ],
  imports: [
    NgxPrintModule,
    BrowserModule,
    ReactiveFormsModule,
    MultiSelectModule,
    AppRoutingModule, HttpClientModule, FormsModule, BrowserAnimationsModule, MatDialogModule,
    AgGridModule.withComponents([EmployesActionRendererComponent])
  ],
  exports: [MatDialogModule],
  entryComponents: [
    EditFonctionComponent,
    ConfirmDialogComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
