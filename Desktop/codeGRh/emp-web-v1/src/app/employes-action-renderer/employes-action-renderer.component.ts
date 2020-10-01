import { Component, OnInit } from '@angular/core';
import { ICellRendererAngularComp } from 'ag-grid-angular';

@Component({
  selector: 'child-cell',
  templateUrl: './employes-action-renderer.component.html',
  styleUrls: ['./employes-action-renderer.component.css']
})
export class EmployesActionRendererComponent implements ICellRendererAngularComp {
  public params: any;

  agInit(params: any): void {
    this.params = params;
  }

  public modifier() {
    console.log(this.params);
    this.params.context.componentParent.modifier(
      this.params.data
    );
  }

  public supprimer() {
    this.params.context.componentParent.supprimer(
      this.params.data
    );
  }

  public afficher() {
    this.params.context.componentParent.afficher(
      this.params.data
    );
  }

  refresh(): boolean {
    return false;
  }
}
