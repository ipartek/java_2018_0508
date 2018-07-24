package com.ipartek.formacion.enumeracion;

public enum PrecioBebida {

	KALIMOTXO(4.50f), CERVEZA(4.00f);
	private float precio; // Precio en euros por litro

	PrecioBebida(float precio) {
		this.precio = precio;
	}

	public float getPrecio() {
		return precio;
	}

} // FIN PrecioBebida
