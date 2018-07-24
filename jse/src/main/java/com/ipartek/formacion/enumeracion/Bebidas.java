package com.ipartek.formacion.enumeracion;

import java.util.Scanner;

public class Bebidas {
	static Scanner sc = null;
	private Vaso vaso;
	private PrecioBebidas precioBebida;

	public Bebidas() {
		super();
		this.vaso = Vaso.KATXI;
		this.precioBebida = PrecioBebidas.KALIMOTXO;
	}

	public Vaso getVaso() {
		return vaso;
	}

	public void setVaso(Vaso vaso) {
		this.vaso = vaso;
	}

	public PrecioBebidas getPrecioBebida() {
		return precioBebida;
	}

	public void setPrecioBebida(PrecioBebidas precioBebida) {
		this.precioBebida = precioBebida;
	}

	float calcularPrecio() {

		

		return -1;
	}

}
