import { Component } from '@angular/core';
import { NavController } from '../../../node_modules/@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
 
})
export class HomePage {

  editoriales : String[];
  nombre:string;
  constructor(public navCtrl:NavController){

    this.nombre='';
    console.log('homePage')
    this.editoriales = [];
    this.editoriales.push('Any');
    this.editoriales.push('anaya');
  }

  crear(){
    console.log('    click crear'+ this.nombre);
  }

  irDetalle(editorial :string){
    console.log('    click Id detalle'+ editorial);
    this.navCtrl
  }
 
}
