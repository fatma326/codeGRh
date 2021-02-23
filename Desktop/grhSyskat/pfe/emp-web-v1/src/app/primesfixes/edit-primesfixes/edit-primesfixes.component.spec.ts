import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPrimesfixesComponent } from './edit-primesfixes.component';

describe('EditPrimesfixesComponent', () => {
  let component: EditPrimesfixesComponent;
  let fixture: ComponentFixture<EditPrimesfixesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditPrimesfixesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPrimesfixesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
