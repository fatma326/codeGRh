import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ContsComponent } from './conts.component';

describe('ContsComponent', () => {
  let component: ContsComponent;
  let fixture: ComponentFixture<ContsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ContsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ContsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
