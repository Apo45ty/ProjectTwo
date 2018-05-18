import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayGraphAndResultComponent } from './display-graph-and-result.component';

describe('DisplayGraphAndResultComponent', () => {
  let component: DisplayGraphAndResultComponent;
  let fixture: ComponentFixture<DisplayGraphAndResultComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DisplayGraphAndResultComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayGraphAndResultComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
