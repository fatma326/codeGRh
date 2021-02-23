import {Component, Inject, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {UserService} from '../../services/user.service';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-edit-type-contrats',
  templateUrl: './edit-type-contrats.component.html',
  styleUrls: ['./edit-type-contrats.component.css']
})
export class EditTypeContratsComponent implements OnInit {
  employes: any[];
  item: any;
  employe: any[];
  submitted = false
  private url  = 'http://localhost:8080/typeConList';

  constructor(private httpClient: HttpClient, private userService: UserService, @Inject(MAT_DIALOG_DATA,) public data: any,
              public dialogRef: MatDialogRef<EditTypeContratsComponent>) { }



  ngOnInit(): void {
    this.item = this.data.item ? this.data.item : {};
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
