package com.ipartek.formacion.enumeracion;

public enum PrecioBebida {

	KALIMOTXO(9.0f), CERVEZA(5.00f);
	private float precio;   //precio en euros por litro
	
	
	PrecioBebida(float precio){
		this.precio = precio;
	}

	public float getPrecio() {
		return precio;
	}

	
}
