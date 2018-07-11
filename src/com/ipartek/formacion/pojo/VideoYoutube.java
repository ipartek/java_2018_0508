package com.ipartek.formacion.pojo;

public class VideoYoutube {

	long id;
	String codigo;
	String titulo;

	public VideoYoutube() {
		super();
		// TODO Auto-generated constructor stub
	}

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
		return "VideoYoutube [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + "]";
	}

}