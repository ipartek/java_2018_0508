package com.andrea.perez.pojo;

public class Pagina {

	private int numPag;
	private String texto;
	private String autor;

	public Pagina(int numPag, String texto, String autor) {
		super();
		this.numPag = numPag;
		this.texto = texto;
		this.autor = autor;
	}

	public int getNumPag() {
		return numPag;
	}

	public void setNumPag(int numPag) {
		this.numPag = numPag;
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
		return "Pagina [numPag=" + numPag + ", texto=" + texto + ", autor=" + autor + "]";
	}

}
