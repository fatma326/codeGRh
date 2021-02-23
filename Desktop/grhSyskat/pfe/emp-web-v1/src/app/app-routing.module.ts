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
import {PretsComponent} from './prets/prets.component';
import {DeptsComponent} from './depts/depts.component';
import {ContsComponent} from './conts/conts.component';
import {ContratComponent} from './contrat/contrat.component';
import {BultinSalaireComponent} from './bultin-salaire/bultin-salaire.component';
import {GratificationComponent} from './gratification/gratification.component';
import {AuthentificationComponent} from './authentification/authentification.component';
import {AuthGuardService as AuthGuard} from './services/auth-guard.service';


const routes: Routes = [
  {
    path:"employes",component:EmployesComponent,
    canActivate: [AuthGuard]

  },
  {
    path:"contrats", component:ContratsComponent,
    canActivate: [AuthGuard]

  }
  ,

  {
    path:"gratification", component:GratificationComponent,
    canActivate: [AuthGuard]

  }
  ,

  {
    path:"pointage", component:PointageComponent,
    canActivate: [AuthGuard]

  }
  ,


  {
    path:"auth", component:AuthentificationComponent
  }
  ,

  {
    path:"compte", component:CompteComponent,
    canActivate: [AuthGuard]

  }
  ,

  {
    path:"avance-salaire", component:AvanceSalaireComponent,
    canActivate: [AuthGuard]

  }
  ,
  {
    path:"primesfixes", component:PrimesfixesComponent,
    canActivate: [AuthGuard]

  }
  ,

  {
    path:"departements", component:DepartementsComponent,
    canActivate: [AuthGuard]

  }
  ,
  {
    path:"bultin-salaire", component:BultinSalaireComponent,
    canActivate: [AuthGuard]

  }
  ,

  {
    path:"conts", component:ContsComponent,
    canActivate: [AuthGuard]

  }
  ,
  {
    path:"displines", component:DisplinesComponent,
    canActivate: [AuthGuard]

  }
  ,
  {
    path:"professions", component:ProfessionsComponent,
    canActivate: [AuthGuard]

  }
  ,
  {
    path:"fonction", component:FonctionComponent,
    canActivate: [AuthGuard]

  },

  {
    path:"cnam", component:CnamComponent,
    canActivate: [AuthGuard]

  },
  {
    path:"its", component:ItsComponent,
    canActivate: [AuthGuard]


  },

  {
    path:"cnss", component:CnssComponent,
    canActivate: [AuthGuard]


  },

  {
    path:"anciennete", component:AncienneteComponent,
    canActivate: [AuthGuard]


  },

  {
    path:"accueil",component:AccueilComponent,
    canActivate: [AuthGuard]

  },


  {
    path:"recherche-employe",component:RechercheEmployeComponent,
    canActivate: [AuthGuard]

  },

  {
    path:"conges",component:CongesComponent,
    canActivate: [AuthGuard]

  },

  {
    path:"licenciement",component:LicenciementComponent,
    canActivate: [AuthGuard]

  },

  {
    path:"contrat",component:ContratComponent,
    canActivate: [AuthGuard]

  },

  {
    path:"departement",component:DepartementComponent,
    canActivate: [AuthGuard]

  },

  {
    path:"depts",component:DeptsComponent,
    canActivate: [AuthGuard]

  },

  {
    path:"primevariable",component:PrimevariableComponent,
    canActivate: [AuthGuard]

  },
  {
    path:"prets",component:PretsComponent,
    canActivate: [AuthGuard]

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
