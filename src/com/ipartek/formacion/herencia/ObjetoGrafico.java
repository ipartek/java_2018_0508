package com.ipartek.formacion.herencia;

public abstract class ObjetoGrafico {

	int x;
	int y;

	public ObjetoGrafico() {
		super();
		this.x = 0;
		this.y = 0;
	}

	void mover(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Hemos movido el objeto de lugar");
	}

	/**
	 * El padre no sabe como dibujar los hijos pero les va a obligar
	 */
	abstract void dibujar();

}
