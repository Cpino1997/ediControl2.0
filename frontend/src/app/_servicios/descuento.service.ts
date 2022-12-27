import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AFP } from '../models/afp';
import { Salud } from '../models/salud';

const afpUrl = 'http://localhost:8080/api/afps';
const saludUrl = 'http://localhost:8080/api/saluds';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class DescuentoService {

  constructor(private http: HttpClient) { }

  getAllAFP(): Observable<AFP[]> {
    return this.http.get<AFP[]>(afpUrl, httpOptions);
  }
  getAFP(id: any): Observable<AFP> {
    return this.http.get<AFP>(`${afpUrl}/${id}`);
  }
  getAllSalud(): Observable<Salud[]> {
    return this.http.get<AFP[]>(saludUrl, httpOptions);
  }
  getSalud(id: any): Observable<Salud> {
    return this.http.get<AFP>(`${saludUrl}/${id}`);
  }
}
