package com.ipartek.formacion.txakuretxea.pojo;

public class Perro {
	private String nombre;
	private int edad;
	private String raza;
	private double peso;
	private boolean apadrinado;
	private Chip chip;
	
	public Perro(String nombre, int edad, String raza, double peso, boolean apadrinado, Chip chip) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = peso;
		this.apadrinado = apadrinado;
		this.chip = chip;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean isApadrinado() {
		return apadrinado;
	}
	public void setApadrinado(boolean apadrinado) {
		this.apadrinado = apadrinado;
	}
	public Chip getChip() {
		return chip;
	}
	public void setChip(Chip chip) {
		this.chip = chip;
	}
	
	

}
