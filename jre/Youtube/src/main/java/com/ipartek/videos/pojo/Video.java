package com.ipartek.videos.pojo;

import java.io.Serializable;

public class Video implements Cloneable, Serializable {

	// Atributos
	private static final long serialVersionUID = -3674003955297656544L;
	private static final int LONG_ID = 11;
	private String id;
	private String titulo;

	// Constructores
	public Video() {
		super();
		this.id = "e_n8Yo_zxUE";
		this.titulo = "Metallica: The Memory Remains (Montréal, Canada - July 19, 2017)";
	}

	public Video(String id, String titulo) throws Exception {
		this();
		this.setId(id);
		this.setTitulo(titulo);

	}

	// Getters y Setters
	public String getId() {
		return id;
	}

	public void setId(String id) throws Exception {
		if (id != null && id.length() == LONG_ID) {

			this.id = id;
		} else {
			throw new Exception("El ID debe tener " + LONG_ID + " caracteres");
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	// Metodos

	@Override
	public String toString() {
		return "VideoYoutube [id=" + id + ", titulo=" + titulo + "]";
	}

}
