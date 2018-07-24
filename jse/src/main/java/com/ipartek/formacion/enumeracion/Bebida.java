package com.ipartek.formacion.enumeracion;

public class Bebida {

	private Vaso vaso;
	private PrecioBebida precioBebida;

	public Bebida() {
		super();
		this.vaso = Vaso.KATXI;
		this.precioBebida = PrecioBebida.KALIMOTXO;
	}

	public Vaso getVaso() {
		return vaso;
	}

	public void setVaso(Vaso vaso) {
		this.vaso = vaso;
	}

	public PrecioBebida getPrecioBebida() {
		return precioBebida;
	}

	public void setPrecioBebida(PrecioBebida precioBebida) {
		this.precioBebida = precioBebida;
	}

	float calcularPrecio() {

		float resul;

		resul = (float) (this.getPrecioBebida().getPrecio() * (this.getVaso().getCC() / 1000));

		return resul;
	}

}
