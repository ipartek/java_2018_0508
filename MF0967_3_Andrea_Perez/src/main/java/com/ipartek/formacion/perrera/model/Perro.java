package com.ipartek.formacion.perrera.model;

/*
 * Un perro debe contener las siguientes características:  nombre, edad, raza (en caso de no saber 'milrazas'), 
 * peso (kg), si esta apadrinado o no.
 *  Ademas todos tiene un chip con numero de identificación con el siguiente formato DD-DDDD-AAAA ( D: numero del 0 al 9, AAAA año del chip ),
 *   en el chip también se guarda la ultima localización del perro ( latitud y longitud ).*/
public class Perro {

	private static final String RAZA_DESCONOCIDA = "milrazas";
	private static final String IMG_DEFAULT="https://icon-icons.com/icons2/85/PNG/128/pug_dog_animal_15965.png";
	
	private String nombre;
	private int edad;// MESES
	private String raza;
	private float peso;
	private boolean apadrinado;
	private Chip chip;
	private String img;

	public Perro() {
		super();
		this.img=IMG_DEFAULT;
		this.nombre = "";
		this.edad = 0;
		this.raza = RAZA_DESCONOCIDA;
		this.peso = 0;
		this.apadrinado = false;
		this.nombre = "";
		this.chip = new Chip();
	}

	public Perro(String nombre, int edad, String raza, float peso, boolean apadrinado, Chip chip,String img) {
		this();
		this.nombre = nombre;
		this.edad = edad;
		this.raza = raza;
		this.peso = peso;
		this.apadrinado = apadrinado;
		this.chip = chip;
		this.img=img;
	}
	

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	@Override
	public String toString() {
		return "Perro [nombre=" + nombre + ", edad=" + edad + ", raza=" + raza + ", peso=" + peso + ", apadrinado="
				+ apadrinado + ", chip=" + chip + "]";
	}

}
