package com.ipartek.formacion.herencia;
/**
 * Clase abstracta ya que tiene metodos con docigo implementado y metodos que no.
 * @author andreaPerez
 *
 */
public abstract class ObjectoGrafico {

	int x;
	int y;

	void mover(int nuevaX, int nuevaY) {
		this.x = nuevaX;
		this.y = nuevaY;
		System.out.println("Hemos movido el objeto de lugar");
	}

	public ObjectoGrafico() {
		super();
		this.x = 5;
		this.y = 5;
	}

	/**
	 * El padre no sabe como se puede dibujar los hijos, pero les va a obligar a que
	 * ellos lo hagan
	 */
	abstract void dibujar();

}
