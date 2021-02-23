import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditTypeContratsComponent } from './edit-type-contrats.component';

describe('EditTypeContratsComponent', () => {
  let component: EditTypeContratsComponent;
  let fixture: ComponentFixture<EditTypeContratsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditTypeContratsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditTypeContratsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
