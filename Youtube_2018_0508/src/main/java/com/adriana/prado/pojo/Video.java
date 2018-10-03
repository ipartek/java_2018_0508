package com.adriana.prado.pojo;

import java.util.ArrayList;
import java.util.List;

public class Video {
	private long id;
	private String codigo;
	private String titulo;
	private String descripcion;
	private List<Comentario> comentarios;

	public static final int CODIGO_LENGTH = 11;
	public static final String CODIGO_LENGTH_EXCEPTION = "La longitud del ID tiene que ser " + CODIGO_LENGTH;

	public Video() {
		super();
		this.id = -1;
		this.codigo = "UmYKPY_-ejc";
		this.titulo = "Game of Thrones - Season 7 - Main Titles";
		this.descripcion = "Esta es una descripción de ejemplo para el vídeo por defecto.";
		this.comentarios = new ArrayList<Comentario>();
	}

	public Video(String codigo, String titulo) throws Exception {
		this();
		setCodigo(codigo);
		this.titulo = titulo;
	}
	
	public Video(String codigo, String titulo, String descripcion) throws Exception {
		this();
		setCodigo(codigo);
		this.titulo = titulo;
		this.descripcion = descripcion;
	}
	
	public Video(String codigo, String titulo, String descripcion, List<Comentario> comentarios) throws Exception {
		this();
		setCodigo(codigo);
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.comentarios = comentarios;
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

	public void setCodigo(String codigo) throws Exception {
		if (codigo != null && codigo.trim().length() == CODIGO_LENGTH)
			this.codigo = codigo;
		else
			throw new Exception(CODIGO_LENGTH_EXCEPTION);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + "codigo=" + codigo + ", titulo=" + titulo + ", descripcion=" + descripcion + "]";
	}
}
