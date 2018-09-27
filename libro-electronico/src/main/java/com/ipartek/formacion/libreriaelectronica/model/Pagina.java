package com.ipartek.formacion.libreriaelectronica.model;

public class Pagina {
	private long id;
	private String titulo;
	private String contenido;
	private String nombreUsuario;
	
	public Pagina() {
		super();
		this.id = -1;
		this.titulo = "";
		this.contenido = "";
		this.nombreUsuario = "";
	}

	public Pagina(long id, String titulo, String contenido, String nombreUsuario) {
		this();
		this.id = id;
		this.titulo = titulo;
		this.contenido = contenido;
		this.nombreUsuario = nombreUsuario;
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

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	@Override
	public String toString() {
		return "Pagina [id=" + id + ", titulo=" + titulo + ", contenido=" + contenido + ", nombreUsuario="
				+ nombreUsuario + "]";
	}
}
