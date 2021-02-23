import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditDisplinesComponent } from './edit-displines.component';

describe('EditDisplinesComponent', () => {
  let component: EditDisplinesComponent;
  let fixture: ComponentFixture<EditDisplinesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditDisplinesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditDisplinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
