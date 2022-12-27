import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Banco } from '../models/banco';
import { Cuenta } from '../models/cuenta';
import { TipoCuenta } from '../models/tipos';

const bancoUrl = 'http://localhost:8080/api/bancos';
const tiposUrl = 'http://localhost:8080/api/tipos';
const cuentaurl = 'http://localhost:8080/api/cuentas';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class CuentaService {

  constructor(private http: HttpClient) { }

  /* Servicio de Bancos */ 
  getAllBancos(): Observable<Banco[]> {
    return this.http.get<Banco[]>(bancoUrl, httpOptions);
  }
  getBanco(id: any): Observable<Banco> {
    return this.http.get<Banco>(`${bancoUrl}/${id}`);
  }

  /* Servicio de Tipos de cuenta */ 
  getAllTipos(): Observable<TipoCuenta[]> {
    return this.http.get<TipoCuenta[]>(tiposUrl, httpOptions);
  }
  getTipo(id: any): Observable<Banco> {
    return this.http.get<TipoCuenta>(`${tiposUrl}/${id}`);
  }

  /* Servicio de cuentas */ 
  getAllCuentas(): Observable<Cuenta[]> {
    return this.http.get<Cuenta[]>(cuentaurl, httpOptions);
  }
  getCuenta(id: any): Observable<Cuenta> {
    return this.http.get<Cuenta>(`${cuentaurl}/${id}`);
  }
  crearCuenta(data: any): Observable<any> {
    return this.http.post(cuentaurl, data);
  }
  actualizarCuenta(id: any, data: any): Observable<any> {
    return this.http.put(`${cuentaurl}/${id}`, data);
  }
  borrarCuenta(id: any): Observable<any> {
    return this.http.delete(`${cuentaurl}/${id}`);
  }
}
