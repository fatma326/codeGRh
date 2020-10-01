import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployesActionRendererComponent } from './employes-action-renderer.component';

describe('EmployesActionRendererComponent', () => {
  let component: EmployesActionRendererComponent;
  let fixture: ComponentFixture<EmployesActionRendererComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EmployesActionRendererComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployesActionRendererComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
