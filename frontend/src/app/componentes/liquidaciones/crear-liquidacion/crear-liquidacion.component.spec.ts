import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearLiquidacionComponent } from './crear-liquidacion.component';

describe('CrearLiquidacionComponent', () => {
  let component: CrearLiquidacionComponent;
  let fixture: ComponentFixture<CrearLiquidacionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CrearLiquidacionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CrearLiquidacionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
