package com.ipartek.formacion.ett;

public class SociosFundadores extends Persona {

	public SociosFundadores() {
		super();
	}

	public SociosFundadores(long id, String dni, String nombre, int salario) {
		super(id, dni, nombre, salario);
	}

	@Override
	public String toString() {
		return "SociosFundadores []";
	}
}
