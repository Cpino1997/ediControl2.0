import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Cargo } from 'src/app/models/cargo';
import { Comuna } from 'src/app/models/comuna';
import { Contrato } from 'src/app/models/contrato';
import { Region } from 'src/app/models/region';
import { Trabajador } from 'src/app/models/trabajador';
import { PersonalService } from 'src/app/_servicios/personal.service';
import { TrabajadorService } from 'src/app/_servicios/trabajador.service';

@Component({
  selector: 'app-trabajadores',
  templateUrl: './trabajadores.component.html',
  styleUrls: ['./trabajadores.component.css']
})
export class TrabajadoresComponent implements OnInit {
 
  /* objetos de la web */
  contratos?: Contrato[];
  cargos?: Cargo[];
  regiones?: Region[];
  comunas?:Comuna[];
  comunasbyregion?:Comuna[];
  trabajadores?:Trabajador[];
  currentComuna: Comuna = {};

  /* Variables */
  id = -1;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private personalService: PersonalService, private trabajadorService : TrabajadorService) { }
  
  ngOnInit(): void {
    this.recibirRegiones();
    this.recibirContratos();
    this.recibirCargos();
    this.recibirComunas();
    this.recibirTrabajadores();
  }

  recibirContratos(): void {
    this.personalService.getAllContratos()
    .subscribe({
      next: (data) => {
        this.contratos = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }
  
  recibirRegiones(): void {
    this.personalService.getAllRegiones()
    .subscribe({
      next: (data) => {
        this.regiones = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }
  recibirCargos(): void {
    this.personalService.getAllCargos()
    .subscribe({
      next: (data) => {
        this.cargos = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }
  recibirComunas(): void {
    this.personalService.getAllComunas()
    .subscribe({
      next: (data) => {
        this.comunas = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }
  recibirComunasByRegion(id:number){
    this.personalService.getByRegion(id)
    .subscribe({
      next: (res) => {
        console.log(res);
        this.comunasbyregion = res;
      },
      error: (e) => console.error(e)
    });
  }
  recibirTrabajadores(): void {
    this.trabajadorService.getAll()
    .subscribe({
      next: (data) => {
        this.trabajadores = data;
        console.log(data);
      },
      error: (e) => console.error(e)
    });
  }

  seleccionar(value: string){
    console.log(value);
    }
  seleccionarComunas(value: string){
    console.log( parseInt(value))
    this.recibirComunasByRegion(parseInt(value))
  }
    refreshList(): void {
      this.recibirComunas();
      this.currentComuna = {};
      this.id = -1;
    }
}
