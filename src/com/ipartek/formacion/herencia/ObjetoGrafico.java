package com.ipartek.formacion.herencia;

public abstract class ObjetoGrafico {
	/*NOS HEMOS SALTADO TODOS LOS PASOS NORMALES*/
	int x;
	int y;
	
	public ObjetoGrafico() {
		super();
		this.x=5;
		this.y=5;
	}

	void mover(int nuevaX,int nuevaY) {
		this.x=nuevaX;
		this.y=nuevaY;
		System.out.println("Hemos movido el objeto lugar");
	}
	/*
	 * El padre no sabe como se pueden dibujar los hijos pero les va ha obligar
	 */
	abstract void dibujar();
	
}
