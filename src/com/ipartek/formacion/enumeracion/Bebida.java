package com.ipartek.formacion.enumeracion;

public class Bebida {

	private final int MEDIDA = 100; //cc
	private Vaso vaso;
	private PrecioBebida precioBebida;

	public Bebida() {
		super();
		this.vaso = Vaso.KATXI;
		this.precioBebida = PrecioBebida.KALIMOTXO;
	}

	public Bebida(Vaso v, PrecioBebida p) {
		this();
		this.setVaso(v);
		this.setPrecioBebida(p);
	}

	public Vaso getVaso() {
		return vaso;
	}

	public void setVaso(Vaso vaso) {
		if (vaso == Vaso.VASO || vaso == Vaso.KATXI) {
			this.vaso = vaso;
		}
	}

	public PrecioBebida getPrecioBebida() {
		return precioBebida;
	}

	public void setPrecioBebida(PrecioBebida precioBebida) {
		if (precioBebida == PrecioBebida.CERVEZA || precioBebida == PrecioBebida.KALIMOTXO) {
			this.precioBebida = precioBebida;
		}
	}

	float calcularPrecio() {
		return this.precioBebida.getPrecio() * ((float) this.vaso.getCC() / MEDIDA);

	}

}
