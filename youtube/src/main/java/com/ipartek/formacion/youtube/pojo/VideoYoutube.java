package com.ipartek.formacion.youtube.pojo;

public class VideoYoutube {

	public static final int COD_LONGITUD = 11;

	private long id;
	private String cod;
	private String nombre;

	public VideoYoutube() throws Exception {
		super();
		this.id = -1;
		this.setCod("XBbovuvX-N4");
		this.setNombre("¿Mejor Afilado Para Cuchillo De Supervivencia? - Scandi VS Plano");
	}

	public VideoYoutube(long id, String cod, String nombre) throws Exception {
		this();
		this.id = id;
		setCod(cod);
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) throws Exception {
		if (cod != null && cod.length() == COD_LONGITUD) {
			this.cod = cod;
		} else {
			throw new Exception("El CÓDIGO del video debe ser exactamente de " + COD_LONGITUD + " caracteres");
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
