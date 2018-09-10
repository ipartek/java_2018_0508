package com.ipartek.formacion.gestor.videos.pojo;

public class Alumno {

	private static final int MIN_LONG_ISBN = 5;
	private static final String MENSAJE_ERROR_ISBN = "La longitud del ISBN debe ser mayor que " + MIN_LONG_ISBN;

	private static long id;
	private String nombre;
	private String email;
	

	// CONSTRUCTORES
	public Alumno() {
		super();
		this.id = -1;
		this.nombre = "";
		this.email = "";
		
	}
	
	public Alumno( String titulo, String email)
			throws Exception {
		this();
		this.id = id;
		this.nombre = titulo.trim();
		this.email = email;
		
	}

	public Alumno(long id, String titulo, String email)
			throws Exception {
		this();
		this.id = id;
		this.nombre = titulo.trim();
		this.email = email;
		
	}

	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void settNombre(String nombre) {
		if (nombre != null && !nombre.trim().isEmpty()) {
			this.nombre = nombre.trim();
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null && !email.trim().isEmpty()) {
			this.email = email.trim();
		}
	}

	


	

	

}

