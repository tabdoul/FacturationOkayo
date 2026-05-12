import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormuClient } from './formu-client';

describe('FormuClient', () => {
  let component: FormuClient;
  let fixture: ComponentFixture<FormuClient>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormuClient],
    }).compileComponents();

    fixture = TestBed.createComponent(FormuClient);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
