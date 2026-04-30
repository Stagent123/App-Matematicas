import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  private urlApp="http://localhost:8080/api/login";
  
  constructor(private http: HttpClient) {}

  Login(datos){
    if datos = 
  }

}
