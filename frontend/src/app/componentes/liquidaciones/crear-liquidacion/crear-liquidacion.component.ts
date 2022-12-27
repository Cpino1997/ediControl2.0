import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Liquidacion } from 'src/app/models/liquidacion';
import { Trabajador } from 'src/app/models/trabajador';
import { LiquidacionesService } from 'src/app/_servicios/liquidaciones.service';
import { StorageService } from 'src/app/_servicios/storage.service';
import { TrabajadorService } from 'src/app/_servicios/trabajador.service';

@Component({
  selector: 'app-crear-liquidacion',
  templateUrl: './crear-liquidacion.component.html',
  styleUrls: ['./crear-liquidacion.component.css']
})
export class CrearLiquidacionComponent implements OnInit{

  trabajadores?:Trabajador[];

  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
  newLiquidacion?:any;
 
  constructor(private formBuilder: FormBuilder,private storageService: StorageService, private trabajadorService : TrabajadorService, private liquidacionService : LiquidacionesService) {}
  
  submitted = false;
    form =  new FormGroup({
    idTrabajador: new FormControl('',[Validators.required]),
    asistencias: new FormControl('',[Validators.required]),
    ausencias: new FormControl('',[Validators.required]),
  });

  ngOnInit(): void {
    this.recibirTrabajadores();
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.roles = this.storageService.getUser().roles;
  }
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
  

  get f(){
    return this.form.controls;
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    this.liquidacionService.crearLiquidaciones(this.form.value)
        .subscribe({
          next: (res) => {
            this.submitted = true;
            this.newLiquidacion = res;
          },
          error: (e) => console.error(e)
        });
    }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
  }
}
