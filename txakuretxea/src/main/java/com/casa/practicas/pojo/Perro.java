package com.casa.practicas.pojo;



public class Perro {
	
	private long id;
	private String nombre;
	private int	 edad;
	private String raza;
	private float peso;
	private Chip chipPerro;
	private boolean apadrinado;
	private String img;
	
	public Perro() {
		super();
		this.id = -1;
		this.nombre = "";
		this.edad = 0;
		this.raza = "Mil razas";
		this.peso= 0;
		this.chipPerro = new Chip();
		this.apadrinado = false;
		this.img="";
	}

	public Perro(long id, String nombre, int edad, String raza, double d, Chip chipPerro, boolean apadrinado,String img) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = (float) d;
		this.chipPerro = chipPerro;
		this.apadrinado = apadrinado;
		this.img= img;
	}

	public boolean isApadrinado() {
		return apadrinado;
	}

	public void setApadrinado(boolean apadrinado) {
		this.apadrinado = apadrinado;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

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

	public Chip getChipPerro() {
		return chipPerro;
	}

	public void setChipPerro(Chip chipPerro) {
		this.chipPerro = chipPerro;
	}
	
	
}	