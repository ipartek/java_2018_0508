import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  //Atributos. Declaracion de variables
  editoriales : string[];
  nombre: string;

  //Implementacion de variables
  constructor(public navCtrl: NavController) {
    console.log('Home Page Constructor');

    this.nombre = '';

    this.editoriales = [];
    this.editoriales.push('Any');
    this.editoriales.push('Anaya');
  }

  crear(){
    console.log('Click Crear ' + this.nombre);
  }

  idDetalle(editorial:string){
    console.log('Click Ver ' + editorial);
    this.navCtrl.push('DetallePage');
  }

}
