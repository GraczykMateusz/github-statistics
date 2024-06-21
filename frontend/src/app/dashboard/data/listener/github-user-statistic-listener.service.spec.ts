import { TestBed } from '@angular/core/testing';

import { GithubUserStatisticListenerService } from './github-user-statistic-listener.service';

describe('GithubUserStatisticListenerService', () => {
  let service: GithubUserStatisticListenerService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GithubUserStatisticListenerService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
