package com.ipartek.formacion.pojo;

public class VideoYoutube {

	// VARIABLES
	long id = 0;
	String titulo;
	String codigo;

	// CONSTRUCTOR(es)
	public VideoYoutube(String s) {

		this.id+= 1;
		this.titulo = s;
		this.codigo = s.substring(0, 3) + Long.toString(this.id);
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
