import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditAvanceSalaireComponent } from './edit-avance-salaire.component';

describe('EditAvanceSalaireComponent', () => {
  let component: EditAvanceSalaireComponent;
  let fixture: ComponentFixture<EditAvanceSalaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditAvanceSalaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditAvanceSalaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
