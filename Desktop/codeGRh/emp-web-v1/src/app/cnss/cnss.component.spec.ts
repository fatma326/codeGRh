import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CnssComponent } from './cnss.component';

describe('CnssComponent', () => {
  let component: CnssComponent;
  let fixture: ComponentFixture<CnssComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CnssComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CnssComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
