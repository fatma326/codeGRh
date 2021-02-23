import {Component, Inject, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserService} from '../../services/user.service';
import {ContratServiceService} from '../../services/contrat-service.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-edit-contrat',
  templateUrl: './edit-contrat.component.html',
  styleUrls: ['./edit-contrat.component.css']
})
export class EditContratComponent implements OnInit {
  employes: any[];
  item: any;
  employe: any[];
  typeCon: any[];
  typeCons: any[];
  submitted = false
  private url  = 'http://localhost:8080/ContratList';
  constructor(private httpClient: HttpClient, private userService: UserService,private contratServiceService: ContratServiceService, @Inject(MAT_DIALOG_DATA,) public data: any,
              public dialogRef: MatDialogRef<EditContratComponent>) { }
  ngOnInit(): void {
    this.item = this.data.item;
    this.employe = this.item.employe ? [this.item.employe] : [];
    this.typeCon =this.item.typeCon ? [this.item.typeCon] : [];

    this.contratServiceService.getTypeCont().subscribe((value: any) => {
      this.typeCons = value;
    } , error => {
      console.log(error);
    })

    this.userService.getUsers().subscribe((value: any) => {
      this.employes = value;
    }, error => {
      console.log(error);
    })
  }


  post() {
    this.item.employe = this.employe ? this.employe[0] : null;
    this.item.typeCon = this.typeCon ? this.typeCon[0] : null;
    this.httpClient.post(this.url, this.item)
      .subscribe(data => {
        this.dialogRef.close();
        this.submitted = true;
      }, err => {
        console.log(err);
      }, );
  }



}


