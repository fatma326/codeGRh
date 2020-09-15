import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployesComponent} from "./employes/employes.component";
import {RechercheEmployeComponent} from "./recherche-employe/recherche-employe.component";
import {ContratsComponent} from "./contrats/contrats.component"
import {DepartementsComponent} from "./departements/departements.component"
import {ProfessionsComponent} from "./professions/professions.component"
import {DisplinesComponent} from "./displines/displines.component"
import {CompteComponent} from './compte/compte.component';
import {PointageComponent} from './pointage/pointage.component';
import {AvanceSalaireComponent} from './avance-salaire/avance-salaire.component';
import {LoginComponent} from './login/login.component';
import {PretsComponent} from './prets/prets.component';
import {PrimesfixesComponent} from './primesfixes/primesfixes.component';
import {PrimevariableComponent} from './primevariable/primevariable.component';


const routes: Routes = [
  {
    path:"employes",component:EmployesComponent
  },
  {
    path:"contrats", component:ContratsComponent
  }
  ,
  {
    path:"departements", component:DepartementsComponent
  }
  ,
  {
    path:"displines", component:DisplinesComponent
  }
  ,
  {
    path:"professions", component:ProfessionsComponent
  }
  ,
  {
    path:"recherche-employe",component:RechercheEmployeComponent
  },

  {
    path:"comptes",component:CompteComponent
  },

  {
    path:"pointages",component:PointageComponent
  },
  {
    path:"prets",component: PretsComponent

  },

  {
    path:"login",component:LoginComponent
  },
  {
    path:"",redirectTo:"/recherche-employe",pathMatch:'full'
  },
  {
    path:"avances",component:AvanceSalaireComponent
  },
  {
    path:"primesf",component:PrimesfixesComponent
  },
  {
    path:"primesv",component:PrimevariableComponent
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
