import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BultinSalaireComponent } from './bultin-salaire.component';

describe('BultinSalaireComponent', () => {
  let component: BultinSalaireComponent;
  let fixture: ComponentFixture<BultinSalaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BultinSalaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BultinSalaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
