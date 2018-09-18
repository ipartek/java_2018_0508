package com.ipartek.formacion.youtube.pojo;

public class Comentario {
	
	private String autor;
	private String texto;
	
	public Comentario() {
		super();
		this.autor = "";
		this.texto = "";
	}

	public Comentario(String autor, String texto) {
		this();
		this.autor = autor;
		this.texto = texto;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String toString() {
		return "Comentario [autor=" + autor + ", texto=" + texto + "]";
	}
	
	

}
