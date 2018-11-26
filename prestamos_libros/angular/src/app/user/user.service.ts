import { UserModel } from './../model/user.model';
import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  //private users: Array<UserModel>;
  constructor(private http:HttpClient) { }

  public getUsers(): Observable<UserModel[]>{
    return this.http.get<UserModel[]>("http://localhost:8080/PrestamosAPI//alumnos");
   

  }


}
