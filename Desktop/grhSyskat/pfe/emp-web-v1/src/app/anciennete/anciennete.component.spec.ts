import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AncienneteComponent } from './anciennete.component';

describe('AncienneteComponent', () => {
  let component: AncienneteComponent;
  let fixture: ComponentFixture<AncienneteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AncienneteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AncienneteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
