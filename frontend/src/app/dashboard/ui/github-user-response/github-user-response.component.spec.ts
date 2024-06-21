import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GithubUserResponseComponent } from './github-user-response.component';

describe('GithubUserResponseComponent', () => {
  let component: GithubUserResponseComponent;
  let fixture: ComponentFixture<GithubUserResponseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GithubUserResponseComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GithubUserResponseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
