package com.ipartek.formacion.txakuretxea.pojo;

public class Perro {
	private long id;
	private String nombre;
	private int edad;
	private String raza;
	private double peso;
	private boolean apadrinado;
	private String descripcion;
	private String imagen;
	private Chip chip;

	public Perro() {
		super();
		id = -1;
		nombre = "";
		edad = 0;
		raza = "milrazas";
		peso = 0;
		apadrinado = false;
		descripcion = "";
		setImagen("https://picsum.photos/300/?random");
		chip = new Chip();
	}
	
	public Perro(String nombre, int edad, String raza, double peso, boolean apadrinado, String descripcion, String imagen) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = peso;
		this.apadrinado = apadrinado;
		this.descripcion = descripcion;
		this.setImagen(imagen);
	}

	public Perro(String nombre, int edad, String raza, double peso, boolean apadrinado, String descripcion, String imagen, Chip chip) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = peso;
		this.apadrinado = apadrinado;
		this.descripcion = descripcion;
		this.setImagen(imagen);
		this.chip = chip;
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
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public Chip getChip() {
		return chip;
	}

	public void setChip(Chip chip) {
		this.chip = chip;
	}

	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso
				+ ", apadrinado=" + apadrinado + ", descripcion=" + descripcion + "]";
	}
}

/*
 * Un perro debe contener las siguientes características:  nombre, edad, raza (en caso de no saber 'milrazas'), 
 * peso (kg), si esta apadrinado o no. Ademas todos tiene un chip con numero de identificación con el 
 * siguiente formato DD-DDDD-AAAA ( D: numero del 0 al 9, AAAA año del chip ), en el chip 
 * también se guarda la ultima localización del perro ( latitud y longitud ).*/