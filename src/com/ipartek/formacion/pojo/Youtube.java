package com.ipartek.formacion.pojo;

public class Youtube {

	private long id;
	private String titulo;
	private String codigo;

	public Youtube(long id, String titulo, String codigo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.codigo = codigo;
	}

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

	public String toString() {
		return "Youtube [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + "]";
	}
}
