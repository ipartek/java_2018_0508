package com.andrea.perez.youtube.pojo;

import java.util.ArrayList;
import java.util.List;

public class Video {
	private long id;
	private String codigo;
	private String titulo;
	private List<Comentario> comentarios;
	private Usuario usuario;
	private String miniImg;

	public static final int CODIGO_LENGTH = 11;
	public static final String CODIGO_LENGTH_EXCEPTION = "La longitud del ID tiene que ser " + CODIGO_LENGTH;

	public Video() {
		super();
		this.id = -1;
		this.codigo = "";
		this.titulo = "";
		this.comentarios = new ArrayList<Comentario>();
		this.usuario = new Usuario();
	}

	public Video(String codigo, String titulo) throws Exception {
		this();
		setCodigo(codigo);
		this.titulo = titulo;
	}

	public Video(String codigo, String titulo, String descripcion, Usuario u) throws Exception {
		this();
		setCodigo(codigo);
		this.titulo = titulo;

		this.usuario = u;
	}

	public Video(String codigo, String titulo, String descripcion, List<Comentario> comentarios) throws Exception {
		this();
		setCodigo(codigo);
		this.titulo = titulo;

		this.comentarios = comentarios;
	}

	public Video(long video) {
		this.id = video;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", codigo=" + codigo + ", titulo=" + titulo + ", usuario=" + usuario + ", miniImg="
				+ miniImg + "]";
	}

}
