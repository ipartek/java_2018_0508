package com.ipartek.formacion.repaso.pojo;

import java.sql.Date;
import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Juego {
	
	private long id;
	
	@NotBlank
	@Size(min=2, max=150)
	private String titulo;
	
	@NotNull
	private Date fechaLanzamiento;

	public Juego() {
		super();
		this.id = -1;
		this.titulo = "";
		this.fechaLanzamiento = new Date(Calendar.getInstance().getTimeInMillis());
	}

	public Juego(long id, String titulo, Date fechaLanzamiento) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.fechaLanzamiento = fechaLanzamiento;
	}
	
	public Juego(String titulo) {
		this();
		this.titulo = titulo;
	}


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

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}
	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	@Override
	public String toString() {
		return "Juego [id=" + id + ", titulo=" + titulo + ", fechaLanzamiento=" + fechaLanzamiento + "]";
	}

}
