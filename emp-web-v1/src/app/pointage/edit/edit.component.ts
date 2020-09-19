import {Component, Inject, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserService} from "../../services/user.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  employes: any[];
  item: any;
  employe: any[];
  private url = 'http://localhost:8181/listPointee';

  constructor(private httpClient: HttpClient, private userService: UserService, @Inject(MAT_DIALOG_DATA,) public data: any,
              public dialogRef: MatDialogRef<EditComponent>) {
  }

  ngOnInit(): void {
    this.item = this.data.item;
    this.employe = this.item.employe ? [this.item.employe] : [];
    this.userService.getUsers().subscribe((value: any) => {
      this.employes = value;
    }, error => {
      console.log(error);
    })
  }


  save() {
    this.item.employe = this.employe ? this.employe[0] : null;
    this.httpClient.post(this.url, this.item)
      .subscribe(data => {
        //this.employer = data;
        this.dialogRef.close();
        console.log("il a ete mis a jour !!")
      }, err => {
        console.log(err);
      },);
  }

}
