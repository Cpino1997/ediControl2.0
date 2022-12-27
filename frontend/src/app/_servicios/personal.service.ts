import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cargo } from '../models/cargo';
import { Comuna } from '../models/comuna';
import { Contrato } from '../models/contrato';
import { Region } from '../models/region';

const contratosUrl = 'http://localhost:8080/api/contratos';
const cargosUrl = 'http://localhost:8080/api/cargos';
const regionUrl = 'http://localhost:8080/api/regiones';
const comunaUrl = 'http://localhost:8080/api/comunas';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class PersonalService {

  constructor(private http: HttpClient) { }

  /* Servicio de contratos */
  getAllContratos(): Observable<Contrato[]> {
    return this.http.get<Contrato[]>(contratosUrl, httpOptions);
  }
  getContrato(id: any): Observable<Contrato> {
    return this.http.get<Contrato>(`${contratosUrl}/${id}`);
  }
  crearContrato(data: any): Observable<any> {
    return this.http.post(contratosUrl, data);
  }
  actualizarContrato(id: any, data: any): Observable<any> {
    return this.http.put(`${contratosUrl}/${id}`, data);
  }
  borrarContrato(id: any): Observable<any> {
    return this.http.delete(`${contratosUrl}/${id}`);
  }

  /* servicio cargos */
  getAllCargos(): Observable<Cargo[]> {
    return this.http.get<Cargo[]>(cargosUrl, httpOptions);
  }
  getOneCargo(id: any): Observable<Cargo> {
    return this.http.get<Cargo>(`${cargosUrl}/${id}`);
  }
  crearCargo(data: any): Observable<any> {
    return this.http.post(cargosUrl, data);
  }
  actualizarCargo(id: any, data: any): Observable<any> {
    return this.http.put(`${cargosUrl}/${id}`, data);
  }
  borrarCargo(id: any): Observable<any> {
    return this.http.delete(`${cargosUrl}/${id}`);
  }

  /* servicio Regiones */
  getAllRegiones(): Observable<Region[]> {
    return this.http.get<Region[]>(regionUrl, httpOptions);
  }
  getOneRegion(id: any): Observable<Region> {
    return this.http.get<Region>(`${regionUrl}/${id}`);
  }
  crearRegion(data: any): Observable<any> {
    return this.http.post(regionUrl, data);
  }
  actualizarRegion(id: any, data: any): Observable<any> {
    return this.http.put(`${regionUrl}/${id}`, data);
  }
  borrarRegion(id: any): Observable<any> {
    return this.http.delete(`${regionUrl}/${id}`);
  }

    /* servicio Comunas */
    getAllComunas(): Observable<Comuna[]> {
      return this.http.get<Comuna[]>(comunaUrl, httpOptions);
    }
    getByRegion(id: any): Observable<Comuna[]> {
      return this.http.get<Comuna[]>(`${comunaUrl}/reg/${id}`);
    }
    getOneComuna(id: any): Observable<Comuna> {
      return this.http.get<Comuna>(`${comunaUrl}/${id}`);
    }
    crearComuna(data: any): Observable<any> {
      return this.http.post(comunaUrl, data);
    }
    actualizarComuna(id: any, data: any): Observable<any> {
      return this.http.put(`${comunaUrl}/${id}`, data);
    }
    borrarComuna(id: any): Observable<any> {
      return this.http.delete(`${comunaUrl}/${id}`);
    }
}
