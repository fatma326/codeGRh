import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplinesComponent } from './displines.component';

describe('DisplinesComponent', () => {
  let component: DisplinesComponent;
  let fixture: ComponentFixture<DisplinesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplinesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
