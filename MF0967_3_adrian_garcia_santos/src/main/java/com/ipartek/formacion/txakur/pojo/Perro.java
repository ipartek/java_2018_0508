package com.ipartek.formacion.txakur.pojo;

public class Perro {
	
	private String nombre;
	private int edad;
	private String raza;
	private float peso;
	private boolean apadrinado;
	private Chip chip;
	private String imagen;
	
	public Perro() {
		super();
		this.nombre = "";
		this.edad = 0;
		this.raza = "milrazas";
		this.peso = 0;
		this.apadrinado = false;
		this.chip = new Chip();
		this.imagen = "https://i.pinimg.com/originals/cc/59/5b/cc595b49d2a02b353f894f15304687ae.jpg";
	}

	public Perro(String nombre, int edad, String raza, float peso, boolean apadrinado, Chip chip, String imagen) {
		this();
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = peso;
		this.apadrinado = apadrinado;
		this.chip = chip;
		this.imagen = imagen;
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

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso + ", apadrinado="
				+ apadrinado + ", chip=" + chip + ", imagen=" + imagen + "]";
	}

}
