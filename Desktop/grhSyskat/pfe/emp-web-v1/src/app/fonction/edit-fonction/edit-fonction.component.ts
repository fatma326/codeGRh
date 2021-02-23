import {Component, Inject, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material/dialog';
import {UserService} from '../../services/user.service';

@Component({
  selector: 'app-edit-fonction',
  templateUrl: './edit-fonction.component.html',
  styleUrls: ['./edit-fonction.component.css']
})
export class EditFonctionComponent implements OnInit {
  employes: any[];
  item: any;
  employe: any[];
  submitted = false
  private url  = 'http://localhost:8080/FonctionList';

  constructor(private httpClient: HttpClient, private userService: UserService, @Inject(MAT_DIALOG_DATA,) public data: any,
  public dialogRef: MatDialogRef<EditFonctionComponent>) { }

  ngOnInit(): void {
    this.item = this.data.item;
    this.employe = this.item.employe ? [this.item.employe] : [];
    this.userService.getUsers().subscribe((value: any) => {
      this.employes = value;
    }, error => {
      console.log(error);
    })
  }


  post() {
    this.httpClient.post(this.url, this.item)
      .subscribe(data => {
        this.dialogRef.close();
        this.submitted = true;
      }, err => {
        console.log(err);
      }, );
  }



}
