package com.ipartek.formacion.libroElectronicoColaborativo.pojo;

public class Pagina {

	private static final int PALABRAS_MINIMAS = 25;
	private static final String TEXTO_PALABRAS_MINIMAS = "Tienes que introducir al menos "+ PALABRAS_MINIMAS +" palabras para escribir una pagina.";
	
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
			int numeroPalabras = contarPalabras(texto);
			if (numeroPalabras>= PALABRAS_MINIMAS) {
				this.texto = texto;
			}else {
				Exception e = new Exception(TEXTO_PALABRAS_MINIMAS);
				throw(e);
			}
		}
		
	}
	
	public static int contarPalabras(String texto){    
	    int contadorPalabras = 0;    
	    boolean palabra = false;
	    int finalDeLinea = texto.length() - 1;

	    for (int i = 0; i < texto.length(); i++) {
	        if (Character.isLetter(texto.charAt(i)) && i != finalDeLinea) {
	            palabra = true;
	        } else if (!Character.isLetter(texto.charAt(i)) && palabra) {
	            contadorPalabras++;
	            palabra = false;
	        } else if (Character.isLetter(texto.charAt(i)) && i == finalDeLinea) {
	            contadorPalabras++;
	        }
	    }
	    return contadorPalabras;
	}
	
}