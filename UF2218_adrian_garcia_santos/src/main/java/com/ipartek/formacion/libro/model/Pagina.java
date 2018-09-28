package com.ipartek.formacion.libro.model;

public class Pagina {
	
	private long id;
	private String texto;
	private String autor;
	
	public Pagina() {
		super();
		this.id = 1;
		this.texto = "Erase una vez...";
		this.autor = "Anónimo";
	}
	
	public Pagina(long id, String texto, String autor) {
		super();
		this.id = id;
		this.texto = texto;
		this.autor = autor;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}
	
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String getAutor() {
		return autor;
	}
	
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "Pagina [id=" + id + ", texto=" + texto + ", autor=" + autor + "]";
	}
	
}
