import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RechercheEmployeComponent } from './recherche-employe.component';

describe('RechercheEmployeComponent', () => {
  let component: RechercheEmployeComponent;
  let fixture: ComponentFixture<RechercheEmployeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RechercheEmployeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RechercheEmployeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
