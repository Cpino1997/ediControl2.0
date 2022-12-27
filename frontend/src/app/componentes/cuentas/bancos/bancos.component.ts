import { Component, OnInit } from '@angular/core';
import { Banco } from 'src/app/models/banco';
import { CuentaService } from 'src/app/_servicios/cuenta.service';

@Component({
  selector: 'app-bancos',
  templateUrl: './bancos.component.html',
  styleUrls: ['./bancos.component.css']
})
export class BancosComponent implements OnInit {
  bancos?: Banco[];
  currentBanco: Banco = {};
  id = -1;
  nombre = '';
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private cuentaService: CuentaService) { }

  ngOnInit(): void {
    this.recibirBancos();
  }

  recibirBancos(): void {
    this.cuentaService.getAllBancos()
    .subscribe({
      next: (data) => {
        this.bancos = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  refreshList(): void {
    this.recibirBancos();
    this.currentBanco = {};
    this.id = -1;
  }

  seleccionar(value: string){
    console.log(value);
    }
}