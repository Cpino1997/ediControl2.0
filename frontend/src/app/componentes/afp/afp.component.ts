import { Component, OnInit } from '@angular/core';
import { AFP } from 'src/app/models/afp';
import {  DescuentoService } from 'src/app/_servicios/descuento.service';

@Component({
  selector: 'app-afp',
  templateUrl: './afp.component.html',
  styleUrls: ['./afp.component.css']
})
export class AfpComponent implements OnInit {
    afps?: AFP[];
    currentAfp: AFP = {};
    id = -1;
    nombre = '';
    isLoggedIn = false;
    isLoginFailed = false;
    errorMessage = '';
    roles: string[] = [];

    constructor(private descuentoService: DescuentoService) { }
  
    ngOnInit(): void {
      this.recibirAfp();
    }

    recibirAfp(): void {
      this.descuentoService.getAllAFP()
      .subscribe({
        next: (data) => {
          this.afps = data;
          console.log(data);
        },
        error: (e) => console.error(e)
      });
    }

    refreshList(): void {
      this.recibirAfp();
      this.currentAfp = {};
      this.id = -1;
    }

    seleccionar(value: string){
      console.log(value);
      }
  }