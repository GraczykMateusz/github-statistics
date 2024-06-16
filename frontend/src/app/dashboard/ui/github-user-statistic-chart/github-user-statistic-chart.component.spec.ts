import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GithubUserStatisticChartComponent } from './github-user-statistic-chart.component';

describe('GithubUserStatisticChartComponent', () => {
  let component: GithubUserStatisticChartComponent;
  let fixture: ComponentFixture<GithubUserStatisticChartComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GithubUserStatisticChartComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GithubUserStatisticChartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
