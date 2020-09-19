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
import { ContratsComponent } from './contrats/contrats.component';
import { DepartementsComponent } from './departements/departements.component';
import { ProfessionsComponent } from './professions/professions.component';
import { DisplinesComponent } from './displines/displines.component';
import { PointageComponent } from './pointage/pointage.component';
import { CompteComponent } from './compte/compte.component';
import { AvanceSalaireComponent } from './avance-salaire/avance-salaire.component';
import { LoginComponent } from './login/login.component';
import { PrimesfixesComponent } from './primesfixes/primesfixes.component';
import { PrimevariableComponent } from './primevariable/primevariable.component';
import { PretsComponent } from './prets/prets.component';
import {MultiSelectModule} from 'primeng/multiselect';
import { EditComponent } from './pointage/edit/edit.component';

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
    PointageComponent,
    CompteComponent,
    AvanceSalaireComponent,
    LoginComponent,
    PrimesfixesComponent,
    PrimevariableComponent,
    PretsComponent,
    EditComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,  ReactiveFormsModule, HttpClientModule, FormsModule, BrowserAnimationsModule, MatDialogModule,
    AgGridModule.withComponents([EmployesActionRendererComponent]),
    MultiSelectModule
  ],
  entryComponents: [
    ConfirmDialogComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
