package com.ipartek.formacion.herencia;

public abstract class ObjetoGrafico {
	int x;
	int y;
	
	void mover(int nuevaX,int nuevaY) {
		this.x = nuevaX;
		this.y = nuevaY;
		
		System.out.println("Hemos movido el objeto de sitio");
	}

	public ObjetoGrafico() {
		super();
		this.x = 5;
		this.y = 5;
	}
	
	/**
	 * El padre no sabe como se pueden dibujar los hijos, pero les obliga
	 */
	abstract void dibujar();
	
}
