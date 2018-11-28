package com.ipartek.personas.personas.pojo;

public class ResultadoVolcadoDeDatos {

	private int filasTotales;
	private int filasIntroducidas;
	private int filasEvitadas;

	public ResultadoVolcadoDeDatos() {
		super();
		this.filasIntroducidas = 0;
		this.filasEvitadas = 0;
	}

	public ResultadoVolcadoDeDatos(int totalFilas, int filasIntroducidas, int filasEvitadas) {
		super();
		this.filasTotales = totalFilas;
		this.filasIntroducidas = filasIntroducidas;
		this.filasEvitadas = filasEvitadas;
	}

	public int getFilasTotales() {
		return filasTotales;
	}

	public void setFilasTotales(int filasTotales) {
		this.filasTotales = filasTotales;
	}

	public int getFilasIntroducidas() {
		return filasIntroducidas;
	}

	public void setFilasIntroducidas(int filasIntroducidas) {
		this.filasIntroducidas = filasIntroducidas;
	}

	public int getFilasEvitadas() {
		return filasEvitadas;
	}

	public void setFilasEvitadas(int filasEvitadas) {
		this.filasEvitadas = filasEvitadas;
	}

	@Override
	public String toString() {
		return "ResultadoVolcadoDeDatos [filasTotales=" + filasTotales + ", filasIntroducidas=" + filasIntroducidas
				+ ", filasEvitadas=" + filasEvitadas + "]";
	}

}
