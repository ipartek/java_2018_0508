import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  //Definicion de variables
  editoriales:string[];

  constructor(public navCtrl: NavController) {
    console.log('homePage constructor');
    
    //Inicializar las variables    
    this.editoriales=[];
    this.editoriales.push('Eny');
    this.editoriales.push('Anaya');
  }

}
