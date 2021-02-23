import { TestBed } from '@angular/core/testing';

import { ContratServiceService } from './contrat-service.service';

describe('ContratServiceService', () => {
  let service: ContratServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ContratServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
