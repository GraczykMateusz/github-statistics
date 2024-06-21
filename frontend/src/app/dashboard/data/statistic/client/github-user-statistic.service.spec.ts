import { TestBed } from '@angular/core/testing';

import { GithubUserStatisticService } from './github-user-statistic.service';

describe('GithubUserStatisticService', () => {
  let service: GithubUserStatisticService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GithubUserStatisticService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
