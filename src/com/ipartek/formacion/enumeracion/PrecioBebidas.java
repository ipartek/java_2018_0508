package com.ipartek.formacion.enumeracion;

public enum PrecioBebidas {
	KALIMOTXO(4.50f), CERVEZA(4.00f);
	private float precio;   //precio en euros por litro
	
	
	PrecioBebidas(float precio){
		this.precio = precio;
	}

	public float getPrecio() {
		return precio;
	}

}
