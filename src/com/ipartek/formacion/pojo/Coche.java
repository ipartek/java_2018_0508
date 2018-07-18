package com.ipartek.formacion.pojo;

/**
 * 
 * @author Curso Clase coche para el ejercicio 5 de ArrayList
 *
 */
public class Coche {

	long id;
	String marca;
	String modelo;
	long km;
	String matricula;
	
	public Coche(long id, String marca, String modelo, long km, String matricula) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.km = km;
		this.matricula = matricula;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public long getKm() {
		return km;
	}

	public void setKm(long km) {
		this.km = km;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", km=" + km + ", matricula=" + matricula
				+ "]";
	}

}
