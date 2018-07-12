package com.ipartek.formacion.pojo;

public class VideoYoutube {

	// Atributos
	long id;
	String codigo;
	String titulo;

	// Constructores
	public VideoYoutube() {
		super();
		this.id = -1;
		this.codigo = "";
		this.titulo = "";
	}

	public VideoYoutube(long id, String codigo, String titulo) {
		this();
		this.id = id;
		this.codigo = codigo;
		this.titulo = titulo;
	}

	// Getters y Setters
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	@Override
	public String toString() {

		String aDevolver = this.id+"--"+this.titulo;
		aDevolver+="\nCodigo: "+this.codigo;
		return aDevolver;
	}

}
