import { TestBed } from '@angular/core/testing';

import { TypeDepartementService } from './type-departement.service';

describe('TypeDepartementService', () => {
  let service: TypeDepartementService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TypeDepartementService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
