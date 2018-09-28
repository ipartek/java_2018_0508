package com.ipartek.formacion.libroElectronicoColaborativo.pojo;

public class Pagina {
	
	private String contenido;
	private String autor;
	
	public Pagina() {
		super();
		this.contenido = "";
		this.autor = "";
	}
	
	public Pagina(String contenido, String autor) {
		this();
		this.contenido = contenido;
		this.autor = autor;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Pagina [contenido=" + contenido + ", autor=" + autor + "]";
	}

}
