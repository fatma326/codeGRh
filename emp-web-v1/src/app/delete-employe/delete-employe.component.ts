import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Router} from "@angular/router"
import {HttpClient, HttpClientModule} from '@angular/common/http';

@Component({
  selector: 'app-delete-employe',
  templateUrl: './delete-employe.component.html',
  styleUrls: ['./delete-employe.component.css']
})
export class DeleteEmployeComponent implements OnInit {

  public employer :any;
  public submitted = false;

  constructor(private route: ActivatedRoute, private router: Router, private httpClient: HttpClient) { }

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

  deleteEmployee() {
    this.httpClient.delete('http://localhost:8080/listemployes/'+this.employer.idEmploye)
    .subscribe(data => {
      //this.employer = data;
      console.log("employee a ete supprimer!!")
      this.submitted = true;
      this.router.navigate(['recherche-employe'])
    }, err => {
      console.log(err);
    }, );
  }

  annuler(){
    this.router.navigate(['recherche-employe'])
  }

}
