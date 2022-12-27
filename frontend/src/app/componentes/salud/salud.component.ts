import { Component, OnInit } from '@angular/core';
import { Salud } from 'src/app/models/salud';
import { DescuentoService } from 'src/app/_servicios/descuento.service';

@Component({
  selector: 'app-salud',
  templateUrl: './salud.component.html',
  styleUrls: ['./salud.component.css']
})
export class SaludComponent implements OnInit {
    saluds?: Salud[];
    currentSalud: Salud = {};
    id = -1;
    nombre = '';
    isLoggedIn = false;
    isLoginFailed = false;
    errorMessage = '';
    roles: string[] = [];

    constructor(private descuentoService: DescuentoService) { }
  
    ngOnInit(): void {
      this.recibirSalud();
    }

    recibirSalud(): void {
      this.descuentoService.getAllSalud()
      .subscribe({
        next: (data) => {
          this.saluds = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
    }

    refreshList(): void {
      this.recibirSalud();
      this.currentSalud = {};
      this.id = -1;
    }

    seleccionar(value: string){
      console.log(value);
      }
  }