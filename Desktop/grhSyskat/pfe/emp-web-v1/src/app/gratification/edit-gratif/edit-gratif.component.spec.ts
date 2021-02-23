import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditGratifComponent } from './edit-gratif.component';

describe('EditGratifComponent', () => {
  let component: EditGratifComponent;
  let fixture: ComponentFixture<EditGratifComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditGratifComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditGratifComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
