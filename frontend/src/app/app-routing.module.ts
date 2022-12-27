import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './componentes/auth/login/login.component';
import { RegistroComponent } from './componentes/auth/registro/registro.component';
import { HomeComponent } from './componentes/home/home.component';
import { CrearLiquidacionComponent } from './componentes/liquidaciones/crear-liquidacion/crear-liquidacion.component';
import { LiquidacionesComponent } from './componentes/liquidaciones/liquidaciones.component';
import { CrearTrabajadorComponent } from './componentes/trabajadores/crear-trabajador/crear-trabajador.component';
import { TrabajadoresComponent } from './componentes/trabajadores/trabajadores.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'registro', component: RegistroComponent },
  { path: 'trabajadores', component: TrabajadoresComponent },
  { path: 'liquidaciones', component: LiquidacionesComponent },
  { path: 'crear-liquidacion', component: CrearLiquidacionComponent },
  { path: 'crear-trabajador', component: CrearTrabajadorComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
