package com.ipartek.formacion.pojo;

public class VideoYoutube {

	private long id;
	private String codigo;
	private String titulo;
	private String autor;
	private String idBorrar;

	public VideoYoutube() {
		super();
	}

	public VideoYoutube(long id, String codigo, String titulo, String autor) {
		this();
		this.id = -1;
		this.codigo = "";
		this.titulo = "";
		this.autor = "";
	}

	public VideoYoutube(String idBorrar, String codigo, String titulo, String autor) {
		super();
		this.idBorrar = idBorrar;
		this.codigo = codigo;
		this.titulo = titulo;
		this.autor = autor;
	}

	public VideoYoutube(Long id, String titulo, String codigo) {
		this();
		this.id = id;
		this.titulo = titulo;
		this.codigo = codigo;
	}

	public String getIdBorrar() {
		return idBorrar;
	}

	public void setIdBorrar(String idBorrar) {
		this.idBorrar = idBorrar;
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

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "id=" + id + "\n codigo=" + codigo + "\n titulo=" + titulo + "\n autor=" + autor;
	}

}
