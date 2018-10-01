package com.ipartek.examen.model.pojo;

public class Paginas {
	private String autor;
	private String texto;
	private int paginas ;
	private static int contador=1;
	
	public Paginas(String autor,String texto) {
		
		super();
		
		this.autor = autor;
		this.texto = texto;
		this.paginas = contador;
		contador++;
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
	
	public int getPaginas() {
		return this.paginas;
	}
}
