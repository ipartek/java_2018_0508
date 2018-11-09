import { Component } from '@angular/core';
import { NavController } from '@ionic/angular';
import { createReadStream } from 'fs';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  // Atributos
  editoriales: string[];
  nombre: string;

  constructor(public navCtrl: NavController) {
    console.log('Home Page Constructor');
    this.editoriales = [];
    this.editoriales.push('Eni');
    this.editoriales.push('Anaya');
    this.nombre = "";

    
  }

  crear (){
    console.log("Click crear " + this.nombre);
  }

  irDetalle(editorial: String) {
    console.log('Click ir al detalle de: ' + editorial);
    this.navCtrl.navigateForward('DetallePage');
  }

}
