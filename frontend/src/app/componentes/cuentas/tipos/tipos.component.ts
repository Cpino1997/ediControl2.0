import { Component, OnInit } from '@angular/core';
import { TipoCuenta } from 'src/app/models/tipos';
import { CuentaService } from 'src/app/_servicios/cuenta.service';

@Component({
  selector: 'app-tipos',
  templateUrl: './tipos.component.html',
  styleUrls: ['./tipos.component.css']
})
export class TiposComponent implements OnInit {
  tipos?: TipoCuenta[];
  currentTipo: TipoCuenta = {};
  id = -1;
  nombre = '';
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private cuentaService: CuentaService) { }

  ngOnInit(): void {
    this.recibirTipos();
  }

  recibirTipos(): void {
    this.cuentaService.getAllTipos()
    .subscribe({
      next: (data) => {
        this.tipos = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  refreshList(): void {
    this.recibirTipos();
    this.currentTipo = {};
    this.id = -1;
  }

  seleccionar(value: string){
    console.log(value);
    }
}