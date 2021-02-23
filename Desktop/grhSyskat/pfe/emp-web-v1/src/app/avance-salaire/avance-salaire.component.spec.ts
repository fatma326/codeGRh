import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AvanceSalaireComponent } from './avance-salaire.component';

describe('AvanceSalaireComponent', () => {
  let component: AvanceSalaireComponent;
  let fixture: ComponentFixture<AvanceSalaireComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AvanceSalaireComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AvanceSalaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
