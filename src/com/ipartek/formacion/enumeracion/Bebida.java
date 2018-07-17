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
	
	float calcularPrecio(PrecioBebida p, Vaso v) {
		//TODO implementar
		float total, ccToL;
		ccToL = (float) v.getCC()/1000;
		total = p.getPrecio() * ccToL;
		return total;
	}
	
	
	
}
