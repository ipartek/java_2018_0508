package com.ipartek.formacion.ett;

public class Contratado extends EmpresaEtt {
	private int seguridadSocial;
	String nombre;
	String dni;
	
	
	public Contratado(double salario, String nombre, String dni, int seguridadSocial){
		super(salario, nombre, dni);
		this.seguridadSocial = seguridadSocial;		
	}

	public int getSeguridadSocial() {
		return seguridadSocial;
	}

	public void setSeguridadSocial(int seguridadSocial) {
		this.seguridadSocial = seguridadSocial;
	}

	@Override
	public String toString() {
		return "Contratado [seguridadSocial=" + seguridadSocial + "]";
	}
	
	

}
