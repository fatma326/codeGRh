import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimevariableComponent } from './primevariable.component';

describe('PrimevariableComponent', () => {
  let component: PrimevariableComponent;
  let fixture: ComponentFixture<PrimevariableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrimevariableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrimevariableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
