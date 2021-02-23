import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditPretsComponent } from './edit-prets.component';

describe('EditPretsComponent', () => {
  let component: EditPretsComponent;
  let fixture: ComponentFixture<EditPretsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditPretsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditPretsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
