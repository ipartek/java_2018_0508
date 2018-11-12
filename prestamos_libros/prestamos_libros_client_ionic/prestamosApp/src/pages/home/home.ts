import { Component } from '@angular/core';
import { NavController } from 'ionic-angular';

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  //atributos
  editoriales: string[];
  nombre: string;

  constructor(public navCtrl: NavController) {
     console.log('HomePage constructor');
     this.nombre = '';

     this.editoriales = [];
     this.editoriales.push('Any');
     this.editoriales.push('Anaya');
  }

  crear(){
    console.log('    click crear ' + this.nombre);
  }

  irDetalle( editorial: string ){
    console.log('    click ir detalle ' + editorial);
    this.navCtrl.push('DetallePage');
  }

}
