package com.ipartek.formacion.arrayList.ejercicio5;

/**
 * Clase Coche para gestionar la venta de coches de segunda mano.
 * 
 * @author Luis
 *
 */
public class Coche {

	// VARIABLES DE LA CLASE COCHE
	private String matricula;
	private String marca;
	private String modelo;
	private int km;

	// CONSTRUCTORES DE LA CLASE COCHE
	public Coche() {
		super();
		this.matricula = "";
		this.marca = "";
		this.modelo = "";
		km = 0;
	}

	public Coche(String matricula, String marca, String modelo, int km) {
		this();
		setMatricula(matricula);
		setMarca(marca);
		setModelo(modelo);
		setKm(km);
	}

	// GETTERS AND SETTERS DE LA CLASE COCHE
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	// OTRAS FUNCIONES DE LA CLASE COCHE
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("\nMatrícula: ");
		sb.append(matricula);

		sb.append("\nMarca: ");
		sb.append(marca);

		sb.append("\nModelo: ");
		sb.append(modelo);

		sb.append("\nKm: ");
		sb.append(km);

		return sb.toString();
	}
} // CLASE COCHE
