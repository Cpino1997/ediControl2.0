import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './componentes/menu/menu.component';
import { RegistroComponent } from './componentes/auth/registro/registro.component';
import { LoginComponent } from './componentes/auth/login/login.component';
import { httpInterceptorProviders } from './_helpers/http.interceptor';
import { HomeComponent } from './componentes/home/home.component';
import { TrabajadoresComponent } from './componentes/trabajadores/trabajadores.component';
import { AfpComponent } from './componentes/afp/afp.component';
import { SaludComponent } from './componentes/salud/salud.component';
import { BancosComponent } from './componentes/cuentas/bancos/bancos.component';
import { CuentasComponent } from './componentes/cuentas/cuentas.component';
import { TiposComponent } from './componentes/cuentas/tipos/tipos.component';
import { LiquidacionesComponent } from './componentes/liquidaciones/liquidaciones.component';
import { TrabajoComponent } from './componentes/trabajo/trabajo.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatIconModule } from '@angular/material/icon';
import { CrearLiquidacionComponent } from './componentes/liquidaciones/crear-liquidacion/crear-liquidacion.component';
import { CrearTrabajadorComponent } from './componentes/trabajadores/crear-trabajador/crear-trabajador.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    RegistroComponent,
    LoginComponent,
    HomeComponent,
    TrabajadoresComponent,
    AfpComponent,
    SaludComponent,
    BancosComponent,
    CuentasComponent,
    TiposComponent,
    LiquidacionesComponent,
    TrabajoComponent,
    CrearLiquidacionComponent,
    CrearTrabajadorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatIconModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
