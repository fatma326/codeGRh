import {Component, Inject, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserService} from '../../services/user.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-edit-displines',
  templateUrl: './edit-displines.component.html',
  styleUrls: ['./edit-displines.component.css']
})
export class EditDisplinesComponent implements OnInit {
  employes: any[];
  item: any;
  employe: any[];
  submitted = false
  private url  = 'http://localhost:8080/DisplineList';

  constructor(private httpClient: HttpClient, private userService: UserService, @Inject(MAT_DIALOG_DATA,) public data: any,
              public dialogRef: MatDialogRef<EditDisplinesComponent>) { }




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
