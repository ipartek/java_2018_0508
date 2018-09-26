package com.ipartek.formacion.libro.pojo;

import java.util.StringTokenizer;

public class Pagina {

	private static final int LONGITUD_TEXTO_ABREVIADO = 20; // 20 palabras
	private long id;
	private String titulo;
	private String contenido;
	private String autor;

	// CONSTRUCTORS
	public Pagina() {
		super();
		this.titulo = "";
		this.contenido = "";
		this.autor = "";
	}

	public Pagina(long id, String titulo, String contenido, String autor) {
		super();
		this.id = id;
		this.titulo = titulo.trim();
		this.contenido = contenido.trim();
		this.autor = autor.trim();
	}

	// GETTERS AND SETTERS
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

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	/**
	 * Procedimiento propio que acorta el contenido del texto si 
	 * contenido tiene más de LONGITUD_TEXTO_ABREVIADO palabras.
	 * 
	 * @return String, con el contenido de la página abreviado.
	 */
	public String getContenidoCorto() {
		
		String textoAbreviado = this.contenido;	
		StringTokenizer tokens = new StringTokenizer(textoAbreviado, " ");
		
		if (tokens.countTokens() > LONGITUD_TEXTO_ABREVIADO) {	// Si el texto es mayor que LONGITUD_TEXTO_ABREVIADO
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < LONGITUD_TEXTO_ABREVIADO; i++) {
				sb.append(tokens.nextToken() + " ");
			}
			
			textoAbreviado = sb.toString();
		} 	
		
		return textoAbreviado.concat(" ...");	
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

}
