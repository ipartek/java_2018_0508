package com.ipartek.formacion.nidea.pojo;

public class Categoria {

	private long id;
	private String codigo;
	private String nombre;

	// CONSTRUCTOR(es)
	public Categoria() {
		super();
		this.codigo = "";
		this.nombre = "";
	}

	public Categoria(long id, String codigo, String nombre) {
		super();
		this.id = id;
		this.codigo = codigo.trim();
		this.nombre = nombre.trim();
	}

	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// OTROS MÉTODOS
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}
