package com.ipartek.formacion.pojo;

public class VideoYoutube {
	
	long id;
	String titulo;
	String codigo;
	
	
	public VideoYoutube() {
		
		super();
		this.id=-1;
		this.titulo="";
		this.codigo="";
		
	}
	
	public VideoYoutube(long id, String titulo, String codigo) {
		
		super();
		this.id=id;
		this.titulo=titulo;
		this.codigo=codigo;
		
		
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
	
	



}

