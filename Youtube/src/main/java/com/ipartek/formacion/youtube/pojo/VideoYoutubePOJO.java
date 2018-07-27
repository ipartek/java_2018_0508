package com.ipartek.formacion.youtube.pojo;

public class VideoYoutubePOJO {

	private static final int LONGITUD_ID = 11;

	private String id;
	private String titulo;

	public VideoYoutubePOJO() {
		
		super();
		this.id = "";
		this.titulo = "";
	}
	

	public VideoYoutubePOJO(String id, String titulo) {
		
		this();
		setId(id);
		this.titulo = titulo;
	}


	public String getId() {
		return id;
	}

	/**
	 * Establece el ID del video sólo si su longitud es igual a LONGITUD_ID.
	 * @param id, String
	 * @throws RuntimeException si la longitud del ID no es la adecuada.
	 */
	public void setId(String id) {
		if (id != null && id.length() == LONGITUD_ID) {

			this.id = id;

		} else { // ID incorrecto. Lanzamos excepción de tipo Runtime.
			
			throw new RuntimeException("ERROR: El ID del video debe contener " + LONGITUD_ID + " caracteres.");
		}

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "VideoYoutube [ID=" + id + ", Título=" + titulo + "]";
	}

}
