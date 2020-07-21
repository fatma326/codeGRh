import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployesComponent } from './employes/employes.component';
import { NewEmployeComponent } from './new-employe/new-employe.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import { RechercheEmployeComponent } from './recherche-employe/recherche-employe.component';
import { EditEmployeComponent } from './edit-employe/edit-employe.component';
import { DeleteEmployeComponent } from './delete-employe/delete-employe.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployesComponent,
    NewEmployeComponent,
    RechercheEmployeComponent,
    EditEmployeComponent,
    DeleteEmployeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, HttpClientModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
