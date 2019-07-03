import { TestBed } from '@angular/core/testing';

import { SolarseriveService } from './solar.service';

describe('SolarseriveService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SolarseriveService = TestBed.get(SolarseriveService);
    expect(service).toBeTruthy();
  });
});
