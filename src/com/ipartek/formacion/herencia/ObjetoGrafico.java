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
		System.out.println("Hemos movido el objeto de lugar");
	}
	
	/**
	 * El padre no sabe como pueden dibujar los hijos
	 * Pero les va a obligar!
	 */
	abstract void dibujar();

}
