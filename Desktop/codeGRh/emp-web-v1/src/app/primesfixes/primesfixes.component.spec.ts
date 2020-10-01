import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimesfixesComponent } from './primesfixes.component';

describe('PrimesfixesComponent', () => {
  let component: PrimesfixesComponent;
  let fixture: ComponentFixture<PrimesfixesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrimesfixesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrimesfixesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
