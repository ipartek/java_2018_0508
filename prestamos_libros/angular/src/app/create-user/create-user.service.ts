import { AlumnoModel } from './../model/alumno.model';
import { UserModel } from './../model/user.model';
import { RestResponse } from './../model/restResponse.model';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CreateUserService {



  constructor(private http:HttpClient) { }


  public saveOrUpdate(user : UserModel) :Observable<RestResponse>{
    console.log(user);
    
   
    
    
    var test = JSON.stringify(user);
    console.log(test);
    return this.http.post<RestResponse>("http://localhost:8080/PrestamosAPI/alumnos",JSON.stringify(user), {headers: {'Content-Type': 'application/json; charset=utf-8'}});

  }
}
