package com.ipartek.formacion.pojo;

public  class LibroElectronico extends Libro{
	//Atributo
	private int size; //Kb

	//CONSTRUCTOR usando el contructor del padre
	public LibroElectronico() {
		super();//llamamos al padre
		this.size=0;
		
	}
	//Constructor con los datos del padre y del hijo
	public LibroElectronico(long id, String isbn, String titulo, String editoral, boolean prestado,int size) throws Exception {
		super(id, isbn, titulo, editoral, prestado);
		this.size=size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return super.toString()+"LibroElectronico [size=" + size + "]";
	}
	
}
