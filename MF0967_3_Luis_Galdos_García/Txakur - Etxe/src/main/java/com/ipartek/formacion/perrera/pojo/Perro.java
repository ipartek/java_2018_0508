package com.ipartek.formacion.perrera.pojo;

public class Perro {
	
	private long id;
	private String nombre;
	private String raza;
	private String img;
	
	private int edad;
	private float peso;
	private boolean esApadrinado;
	
	Chip chip;
	

	// CONSTRUCTORES
	public Perro() {
		super();
		this.id = -1;
		this.esApadrinado = false;
		this.img = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAP55Wmw1CuJIVmsh7P6Xdz8FpbDnGBZpPjrJy1xo4DEkMsL0O";
	}

	public Perro(long id, String nombre, String raza, int edad, float peso, boolean esApadrinado, Chip chip) {
		this();
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.peso = peso;
		this.esApadrinado = esApadrinado;
		this.chip = chip;
	}

	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public boolean isEsApadrinado() {
		return esApadrinado;
	}

	public void setEsApadrinado(boolean esApadrinado) {
		this.esApadrinado = esApadrinado;
	}

	public Chip getChip() {
		return chip;
	}

	public void setChip(Chip chip) {
		this.chip = chip;
	}
	
	
	
	

}
