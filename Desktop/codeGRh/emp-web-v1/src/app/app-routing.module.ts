import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {EmployesComponent} from "./employes/employes.component";
import {RechercheEmployeComponent} from "./recherche-employe/recherche-employe.component";
import {ContratsComponent} from "./type_contrats/contrats.component"
import {DepartementsComponent} from "./departements/departements.component"
import {ProfessionsComponent} from "./professions/professions.component"
import {DisplinesComponent} from "./displines/displines.component"
import {FonctionComponent} from "./fonction/fonction.component";
import {CnamComponent} from "./cnam/cnam.component";
import {ItsComponent} from "./its/its.component";
import {CnssComponent} from "./cnss/cnss.component";
import {AncienneteComponent} from "./anciennete/anciennete.component";
import {CongesComponent} from "./conges/conges.component";
import {LicenciementComponent} from "./licenciement/licenciement.component";
import {DepartementComponent} from "./departement/departement.component";
import {AccueilComponent} from "./accueil/accueil.component";
import {PointageComponent} from './pointage/pointage.component';
import {CompteComponent} from './compte/compte.component';
import {AvanceSalaireComponent} from './avance-salaire/avance-salaire.component';
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
    path:"pointage", component:PointageComponent
  }
  ,

  {
    path:"compte", component:CompteComponent
  }
  ,

  {
    path:"avance-salaire", component:AvanceSalaireComponent
  }
  ,
  {
    path:"primesfixes", component:PrimesfixesComponent
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
    path:"fonction", component:FonctionComponent
  },

  {
    path:"cnam", component:CnamComponent
  },
  {
    path:"its", component:ItsComponent

  },

  {
    path:"cnss", component:CnssComponent

  },

  {
    path:"anciennete", component:AncienneteComponent

  },

  {
    path:"accueil",component:AccueilComponent
  },


  {
    path:"recherche-employe",component:RechercheEmployeComponent
  },

  {
    path:"conges",component:CongesComponent
  },

  {
    path:"licenciement",component:LicenciementComponent
  },

  {
    path:"contrat",component:ContratsComponent
  },

  {
    path:"departement",component:DepartementComponent
  },


  {
    path:"primevariable",component:PrimevariableComponent
  },
  {
    path:"",redirectTo:"/accueil",pathMatch:'full'
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
