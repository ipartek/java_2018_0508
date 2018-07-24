package com.ipartek.formacion.herencia;

/**
 * Las clases abstractas no se pueden instanciar.
 * 
 * @author Curso
 *
 */
public abstract class ObjetoGrafico {

	int x;
	int y;

	public ObjetoGrafico() {
		super();
		this.x = 0;
		this.y = 0;
	}

	void mover(int nuevaX, int nuevaY) {

		this.x = nuevaX;
		this.y = nuevaY;

		System.out.println("Hemos movido el objeto de lugar.");
	}

	/**
	 * El padre no sabe cómo se deben dibujar los hijos, pero les va a obligar.
	 */
	abstract void dibujar();

}
