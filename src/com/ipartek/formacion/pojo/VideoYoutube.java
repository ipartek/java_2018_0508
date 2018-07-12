package com.ipartek.formacion.pojo;
 
public class VideoYoutube {
	
	private long id;
	private String titulo;
	private String codigo;
	
	public VideoYoutube() {
		super();
		this.setId(-1);
		this.setTitulo("");
		this.setCodigo("");
	}
	
	public VideoYoutube(long id, String titulo, String codigo) {
		this();
		this.setId(id);
		this.setTitulo(titulo);
		this.setCodigo(codigo);
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

	@Override
	public String toString() {
		return "VideoYoutube [id=" + id + ", titulo=" + titulo + ", codigo=" + codigo + "]";
	}
	
}
