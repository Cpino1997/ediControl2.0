import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { StorageService } from 'src/app/_servicios/storage.service';
import { TrabajadorService } from 'src/app/_servicios/trabajador.service';

@Component({
  selector: 'app-crear-trabajador',
  templateUrl: './crear-trabajador.component.html',
  styleUrls: ['./crear-trabajador.component.css']
})
export class CrearTrabajadorComponent {
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];
 
  constructor(private formBuilder: FormBuilder,private storageService: StorageService, private trabajadorService : TrabajadorService) {}
  
  submitted = false;
    form =  new FormGroup({
    nombre: new FormControl('',[Validators.required,Validators.minLength(6),Validators.maxLength(40)]),
    rut: new FormControl('',[Validators.required,Validators.minLength(8),Validators.maxLength(9)]),
    correo: new FormControl('',[Validators.required, Validators.email]),
    direccion: new FormControl('',[Validators.required,Validators.minLength(10),Validators.maxLength(60)]),
    telefono: new FormControl('',[Validators.required,Validators.minLength(9),Validators.maxLength(9)]),
    idComuna:new FormControl('',[Validators.required]),
    idAfp:new FormControl('',[Validators.required]),
    idSalud:new FormControl('',[Validators.required]),
    idCuenta:new FormControl('',[Validators.required]),
    idContrato:new FormControl('',[Validators.required]),
    activo:new FormControl(false),
  });

  ngOnInit(): void {
    if (this.storageService.isLoggedIn()) {
      this.isLoggedIn = true;
      this.roles = this.storageService.getUser().roles;
    }
  }

  get f(){
    return this.form.controls;
  }

  onSubmit(): void {
    this.submitted = true;
    if (this.form.invalid) {
      return;
    }
    this.trabajadorService.create(this.form.value)
        .subscribe({
          next: (res) => {
            console.log(res);
            this.submitted = true;
          },
          error: (e) => console.error(e)
        });
    }

  onReset(): void {
    this.submitted = false;
    this.form.reset();
  }
}