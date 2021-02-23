import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCompteComponent } from './edit-compte.component';

describe('EditCompteComponent', () => {
  let component: EditCompteComponent;
  let fixture: ComponentFixture<EditCompteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditCompteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditCompteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
