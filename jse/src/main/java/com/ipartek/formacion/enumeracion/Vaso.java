package com.ipartek.formacion.enumeracion;

public enum Vaso {

	KATXI(1000), VASO(333); // Tipos de Vasos disponibles

	private int cc; // Centímetros cúbicos

	Vaso(int cc) { // Nuestro constructor nos obliga a pasar un parametro cc al definir un
					// Enum<Vaso>
		this.cc = cc;
	}

	public int getCC() {
		return this.cc;
	}

} // FIN Vaso
