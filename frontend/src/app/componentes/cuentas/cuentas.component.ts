import { Component, OnInit } from '@angular/core';
import { Cuenta } from 'src/app/models/cuenta';
import { CuentaService } from 'src/app/_servicios/cuenta.service';

@Component({
  selector: 'app-cuentas',
  templateUrl: './cuentas.component.html',
  styleUrls: ['./cuentas.component.css']
})
export class CuentasComponent implements OnInit {
  cuentas?: Cuenta[];
  currentCuenta: Cuenta = {};
  id = -1;
  nombre = '';
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private cuentaService: CuentaService) { }

  ngOnInit(): void {
    this.recibirCuentas();
  }

  recibirCuentas(): void {
    this.cuentaService.getAllCuentas()
    .subscribe({
      next: (data) => {
        this.cuentas = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  refreshList(): void {
    this.recibirCuentas();
    this.currentCuenta = {};
    this.id = -1;
  }

  seleccionar(value: string){
    console.log(value);
    }
}