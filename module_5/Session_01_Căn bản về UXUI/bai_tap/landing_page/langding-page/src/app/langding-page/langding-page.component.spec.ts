import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LangdingPageComponent } from './langding-page.component';

describe('LangdingPageComponent', () => {
  let component: LangdingPageComponent;
  let fixture: ComponentFixture<LangdingPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LangdingPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LangdingPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
