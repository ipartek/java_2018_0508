package com.ipartek.formacion.model;

public class Pagina {

	private static final int MIN_PALABRAS = 25;
	private static final String TXT_MIN_PALABRAS = "Tienes que introducir al menos"+MIN_PALABRAS+"palabras para escribir una pagina.";
	
	private String autor;
	private String texto;
	
	public Pagina() {
		super();
		this.autor="";
		this.texto="Erase un vez...";
	}

	public Pagina(String autor, String texto) throws Exception {
		this();
		this.autor = autor;
		this.setTexto(texto);
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

	public void setTexto(String texto) throws Exception {
		if (texto!=null) {
			int nPalabras = cuentaPalabras(texto);
			if (nPalabras>= MIN_PALABRAS) {
				this.texto = texto;
			}else {
				Exception e = new Exception(TXT_MIN_PALABRAS);
				throw(e);
			}
		}
		
	}
	
	public static int cuentaPalabras(String texto){    
	    int conteoPalabras = 0;    
	    boolean palabra = false;
	    int finDeLinea = texto.length() - 1;

	    for (int i = 0; i < texto.length(); i++) {
	        // Si el char is una letra, word = true.
	        if (Character.isLetter(texto.charAt(i)) && i != finDeLinea) {
	            palabra = true;
	            // Si el char no es una letra y aún hay más letras,
	            // el contador continua.
	        } else if (!Character.isLetter(texto.charAt(i)) && palabra) {
	            conteoPalabras++;
	            palabra = false;
	            // última palabra de la cadena; si no termina con una no letra ,
	        } else if (Character.isLetter(texto.charAt(i)) && i == finDeLinea) {
	            conteoPalabras++;
	        }
	    }
	    return conteoPalabras;
	}
	
}
