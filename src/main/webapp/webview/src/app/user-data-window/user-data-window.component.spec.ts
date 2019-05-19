import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserDataWindowComponent } from './user-data-window.component';

describe('UserDataWindowComponent', () => {
  let component: UserDataWindowComponent;
  let fixture: ComponentFixture<UserDataWindowComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserDataWindowComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserDataWindowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
