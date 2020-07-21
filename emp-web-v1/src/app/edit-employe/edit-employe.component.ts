import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { flatten } from '@angular/compiler';

@Component({
  selector: 'app-edit-employe',
  templateUrl: './edit-employe.component.html',
  styleUrls: ['./edit-employe.component.css']
})
export class EditEmployeComponent implements OnInit {

  public employer :any;
  public submitted = false;

  constructor(private route: ActivatedRoute, private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      let employeID = +params.get('employeID');
      this.employer = this.getEmployee(employeID)

    });

  }

  getEmployee(id): any {
    this.httpClient.get('http://localhost:8080/listemployes/'+id)
    .subscribe(data => {
      this.employer = data;
    }, err => {
      console.log(err);
    }, );
  }

  putEmployee() {
    this.httpClient.put('http://localhost:8080/listemployes/'+this.employer.idEmploye, this.employer)
    .subscribe(data => {
      //this.employer = data;
      console.log("employee a ete mis a jour!!")
      this.submitted = true;
    }, err => {
      console.log(err);
    }, );
  }

}
