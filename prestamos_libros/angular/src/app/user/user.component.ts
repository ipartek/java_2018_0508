import { UserModel } from './../model/user.model';
import { Component, OnInit } from '@angular/core';

import { UserService } from './user.service';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  providers: [UserService]
})
export class UserComponent implements OnInit {

  private users: Array<UserModel>;

  //añadiendo el userservice podemos usar todos los componentes de user.service.ts
  constructor(private userService:UserService) { }

  ngOnInit() {
    
    this.loadUser();
  }

  private loadUser() : void {
    this.userService.getUsers().subscribe(res=>{
      this.users = res;
    });

  }

}
