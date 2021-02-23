import {Component, Inject, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DepartementService} from '../../services/departement.service';
import {TypeDepartementService} from '../../services/type-departement.service';
import { ProfessionService } from '../../services/profession.service';

import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-edit-departement',
  templateUrl: './edit-departement.component.html',
  styleUrls: ['./edit-departement.component.css']
})
export class EditDepartementComponent implements OnInit {
  item: any;
  ParentDep: any[];
  ParentDeps: any[];
  TypeDepartement: any[];
  TypeDepartements: any[];
  Profession: any[];
  Professions: any[];
  employes:any[];
  employe:any[];
  submitted = false
  private url  = 'http://localhost:8080/depList';

  constructor(private httpClient: HttpClient, private departementService : DepartementService,private typeDepartementService : TypeDepartementService,private professionService : ProfessionService,private userService: UserService, @Inject(MAT_DIALOG_DATA,) public data: any,
              public dialogRef: MatDialogRef<EditDepartementComponent>) { }

  ngOnInit(): void {
    this.item = this.data.item;
    this.ParentDep =this.item.ParentDep ? [this.item.ParentDep] : [];
    this.departementService.getParentDep().subscribe((value: any) => {
      this.ParentDeps = value;
    } , error => {
      console.log(error);
    })


    this.TypeDepartement =this.item.TypeDepartement ? [this.item.TypeDepartement] : [];
    this.typeDepartementService.getTypeDepartement().subscribe((value: any) => {
      this.TypeDepartements = value;
    } , error => {
      console.log(error);
    })


    this.Profession =this.item.Profession ? [this.item.Profession] : [];
    this.professionService.getProfession().subscribe((value: any) => {
      this.Professions = value;
    } , error => {
      console.log(error);
    })

    this.employe = this.item.employe ? [this.item.employe] : [];
    this.userService.getUsers().subscribe((value: any) => {
      this.employes = value;
    }, error => {
      console.log(error);
    })

  }


  post() {
    this.item.ParentDep = this.ParentDep ? this.ParentDep[0] : null;
    this.item.TypeDepartement = this.TypeDepartement ? this.TypeDepartement[0] :null;
    this.item.Profession = this.Profession ? this.Profession[0] : null;
    this.httpClient.post(this.url, this.item)
      .subscribe(data => {
        this.dialogRef.close();
        this.submitted = true;
      }, err => {
        console.log(err);
      }, );
  }



}




