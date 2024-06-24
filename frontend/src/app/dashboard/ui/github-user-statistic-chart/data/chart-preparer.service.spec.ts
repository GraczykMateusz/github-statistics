import { TestBed } from '@angular/core/testing';

import { ChartPreparerService } from './chart-preparer.service';

describe('ChartPreparerService', () => {
  let service: ChartPreparerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ChartPreparerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
