import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Liquidacion } from '../models/liquidacion';

const liquidacionUrl = 'http://localhost:8080/api/liquidaciones';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class LiquidacionesService {
  

  constructor(private http: HttpClient) { }

  /* Servicio de asistencias */
  getAllLiquidaciones(): Observable<Liquidacion[]> {
    return this.http.get<Liquidacion[]>(liquidacionUrl, httpOptions);
  }
  getLiquidaciones(id: any): Observable<Liquidacion> {
    return this.http.get<Liquidacion>(`${liquidacionUrl}/${id}`);
  }
  crearLiquidaciones(data: any): Observable<any> {
    return this.http.post(liquidacionUrl, data);
  }
  actualizarLiquidaciones(id: any, data: any): Observable<any> {
    return this.http.put(`${liquidacionUrl}/${id}`, data);
  }
  borarrLiquidacion(id: any): Observable<any> {
    return this.http.delete(`${liquidacionUrl}/${id}`);
  }
}