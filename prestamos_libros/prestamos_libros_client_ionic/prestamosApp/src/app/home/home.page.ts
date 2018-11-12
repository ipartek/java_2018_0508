import { Component } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  //Atributos
  editoriales: string[];
  nombre: string;

  constructor(public navCtrl: NavController){
    console.log('Home page constructor');
    this.editoriales = [];
    this.editoriales.push('Eni');
    this.editoriales.push('Anaya');
    this.nombre = '';
  }

  crear(){
    console.log('    click crear' + this.nombre);
    this.editoriales.push(this.nombre);
  }

  irDetalle(editorial:string){
    console.log('    click Detalle de ' + editorial);
    this.navCtrl.navigateForward('DetallePage');
  }

}
