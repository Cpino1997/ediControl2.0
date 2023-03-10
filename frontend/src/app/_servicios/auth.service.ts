import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

const AUTH_API = 'http://localhost:8080/api/auth/';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(username: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'login',
      {
        username,
        password,
      },
      httpOptions
    );
  }

  registro(username: string, email: string, password: string): Observable<any> {
    return this.http.post(
      AUTH_API + 'registro',
      {
        username,
        email,
        password,
      },
      httpOptions
    );
  }

  salir(): Observable<any> {
    return this.http.post(AUTH_API + 'salir', { }, httpOptions);
  }

  refreshtoken() {
    return this.http.post(AUTH_API + 'refreshtoken', { }, httpOptions);
  }
}