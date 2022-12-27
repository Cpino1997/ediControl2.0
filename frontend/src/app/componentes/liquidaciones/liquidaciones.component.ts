import { Component, OnInit } from '@angular/core';
import { Liquidacion } from 'src/app/models/liquidacion';
import { LiquidacionesService } from 'src/app/_servicios/liquidaciones.service';

@Component({
  selector: 'app-liquidaciones',
  templateUrl: './liquidaciones.component.html',
  styleUrls: ['./liquidaciones.component.css']
})
export class LiquidacionesComponent implements OnInit{
  
  /* objetos de la web */
  liquidaciones?: Liquidacion[];
  /* Variables */
  id = -1;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  mensaje?: string;
  estado?:false;

  constructor(private liquidacionService : LiquidacionesService) { }

  ngOnInit(): void {
    this.recibirLiquidaciones();
    this.buscarEstados(false);
  }
  
  recibirLiquidaciones(): void {
    this.liquidacionService.getAllLiquidaciones()
    .subscribe({
      next: (data) => {
        this.liquidaciones = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  buscarEstados(estado: any): void{
    if(!estado){
      this.mensaje="No Pagado!";
    }else{
      this.mensaje= "Pagado";
    }
  }

}
