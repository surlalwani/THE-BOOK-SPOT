import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HomesearchcomponentComponent } from './homesearchcomponent.component';

describe('HomesearchcomponentComponent', () => {
  let component: HomesearchcomponentComponent;
  let fixture: ComponentFixture<HomesearchcomponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HomesearchcomponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HomesearchcomponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
