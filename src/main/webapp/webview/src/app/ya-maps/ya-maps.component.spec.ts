import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { YaMapsComponent } from './ya-maps.component';

describe('YaMapsComponent', () => {
  let component: YaMapsComponent;
  let fixture: ComponentFixture<YaMapsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ YaMapsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(YaMapsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
