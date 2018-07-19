package com.ipartek.formacion.herencia;

public abstract class ObjetoGrafico {

	int x;
	int y;

	public ObjetoGrafico() {
		super();
		this.x = 5;
		this.y = 5;
	}

	void mover(int nuevaX, int nuevaY) {
		this.x = nuevaX;
		this.y = nuevaY;
		System.out.println("Hemos movido el objeto");

	}

	/**
	 * El padre no sabe como dibujar los hijos, PERO les va a obligar!!!
	 */
	abstract void dibujar();
	
}
