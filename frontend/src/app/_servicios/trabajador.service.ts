import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Trabajador } from '../models/trabajador';

const baseUrl = 'http://localhost:8080/api/trabajadores';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class TrabajadorService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Trabajador[]> {
    return this.http.get<Trabajador[]>(baseUrl, httpOptions);
  }

  get(id: any): Observable<Trabajador> {
    return this.http.get<Trabajador>(`${baseUrl}/${id}`);
  }

  create(data: any): Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }
  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }
}