package com.ipartek.formacion.pojo;

public class VideoYoutube {
	
	private long id;
	private String codigo;
	private String titulo;

	public VideoYoutube() {
		this.id = 0;
		this.codigo = "";
		this.titulo = "";
		
	}
	
	public VideoYoutube(String codigo, String titulo) {
		this.setCodigo(codigo);
		this.setTitulo(titulo);
		
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
