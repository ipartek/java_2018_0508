package com.ipartek.formacion.pojo;

public class VideoYoutube {

	// VARIABLES
	long id;
	String titulo;
	String codigo;

	// CONSTRUCTOR(es)
	public VideoYoutube() {		// Por defecto, todo vacío
		super();
		this.id = -1;
		this.codigo = "";
		this.titulo = "";
	}

	public VideoYoutube(long id, String titulo, String codigo) { // Con parámetros
		this();
		this.id = id;
		this.titulo = titulo;
		this.codigo = codigo;
		
	}




	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "VideoYoutube [id=" + id + ", titulo=" + titulo + ", codigo=" + codigo + "]";
	}
	
	

}
