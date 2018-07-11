package com.ipartek.formacion.pojo;

public class videoYoutube {
	
	//variables
	long id;
	private String titulo;
	private String codigo;
	
	public videoYoutube() {
		super();
		this.titulo = ""  ;
		this.codigo = "" ;

	}

	//setters y getters
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

	//constrructor
	
	
}
