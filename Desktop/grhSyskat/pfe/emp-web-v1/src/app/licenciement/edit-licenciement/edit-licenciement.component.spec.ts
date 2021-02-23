import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditLicenciementComponent } from './edit-licenciement.component';

describe('EditLicenciementComponent', () => {
  let component: EditLicenciementComponent;
  let fixture: ComponentFixture<EditLicenciementComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditLicenciementComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditLicenciementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
