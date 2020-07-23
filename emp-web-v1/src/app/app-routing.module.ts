import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployesComponent} from "./employes/employes.component";
import {RechercheEmployeComponent} from "./recherche-employe/recherche-employe.component";

const routes: Routes = [
  {
    path:"employes",component:EmployesComponent
  },

  {
    path:"recherche-employe",component:RechercheEmployeComponent
  },

  {
    path:"",redirectTo:"/employes",pathMatch:'full'
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
