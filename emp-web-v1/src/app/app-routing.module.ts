import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployesComponent} from "./employes/employes.component";
import {NewEmployeComponent} from "./new-employe/new-employe.component";
import {RechercheEmployeComponent} from "./recherche-employe/recherche-employe.component";
import {EditEmployeComponent} from "./edit-employe/edit-employe.component";
import {DeleteEmployeComponent} from "./delete-employe/delete-employe.component";

const routes: Routes = [
  {
    path:"employes",component:EmployesComponent
  },

  {
    path:"new-employe",component:NewEmployeComponent
  },

  {
    path:"recherche-employe",component:RechercheEmployeComponent
  },

  {
    path:"edit-employe/:employeID",component:EditEmployeComponent
  },

  {
    path:"delete-employe/:employeID",component:DeleteEmployeComponent
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
