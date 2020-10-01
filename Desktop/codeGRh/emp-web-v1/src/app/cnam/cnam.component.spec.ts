import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CnamComponent } from './cnam.component';

describe('CnamComponent', () => {
  let component: CnamComponent;
  let fixture: ComponentFixture<CnamComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CnamComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CnamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
