package com.ipartek.formacion.enumeracion;

public enum Vaso {

	//Tipos de Vasos disponibles
	KATXI(50), VASO(33);
	
	private int cc;   //centimetros cubicos
	
	//Nuestro constructor nos obliga a pasar un parametro cc al definir un Enum<Vaso>
	Vaso(int cc){
		this.cc = cc;
	}
	
	public int getCC() {
		return this.cc;
	}
	
	
}
