import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ItsComponent } from './its.component';

describe('ItsComponent', () => {
  let component: ItsComponent;
  let fixture: ComponentFixture<ItsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ItsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ItsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
