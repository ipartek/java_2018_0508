package com.ipartek.formacion.libroElectronico.model.pojo;

import java.util.StringTokenizer;

public class Pagina {

	private int id;
	private String texto;
	private String Autor;
	public Pagina() {
		super();
		this.id=-1;
		this.texto="";
		this.Autor="";
	}
	public Pagina(int id, String texto, String autor) {
		super();
		this.id = id;
		this.texto = texto;
		Autor = autor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getAutor() {
		return Autor;
	}
	public void setAutor(String autor) {
		Autor = autor;
	}
	@Override
	public String toString() {
		return "Pagina [id=" + id + ", texto=" + texto + ", Autor=" + Autor + "]";
	}
	public int contarPalabras(String texto) {
		int palabras=0;
		
		StringTokenizer st = new StringTokenizer(texto);
	       palabras=st.countTokens();
		
		return palabras;
	}
	
	
}
