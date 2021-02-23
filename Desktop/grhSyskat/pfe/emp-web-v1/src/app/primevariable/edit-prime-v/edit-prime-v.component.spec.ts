import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPrimeVComponent } from './edit-prime-v.component';

describe('EditPrimeVComponent', () => {
  let component: EditPrimeVComponent;
  let fixture: ComponentFixture<EditPrimeVComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditPrimeVComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPrimeVComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
