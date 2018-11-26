import { OK } from './../model/httpStatus';
import { UserModel } from './../model/user.model';
import { Component, OnInit } from '@angular/core';
import { CreateUserService } from './create-user.service';
import {Router} from '@angular/router';



@Component({
  selector: 'app-create-user',
  templateUrl: './create-user.component.html',
  styleUrls: ['./create-user.component.css'],
  providers:[CreateUserService]
})
export class CreateUserComponent implements OnInit {

  private user: UserModel;
  private isValid:boolean = true;
  private msg:String = "";

  constructor(private createUserService:CreateUserService, private router: Router) {

    if (sessionStorage.getItem("user")) {
      
      this.user = JSON.parse(sessionStorage.getItem("user"));
    } else {
      this.user = new UserModel();
    }

   }

  ngOnInit() {
  }

  public saveOrUpdate():void{
    this.createUserService.saveOrUpdate(this.user).subscribe(res=>{
      if(res.responseCode == OK){
        this.msg ="Registro guardado existosamente";
        this.isValid = true;
        this.router.navigate(['/userComponent']);
      }else{
        this.msg = res.message;
        this.isValid = false;

      }
    });
   

  }

}
