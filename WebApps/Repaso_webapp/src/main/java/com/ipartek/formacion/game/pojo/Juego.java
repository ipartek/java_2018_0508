package com.ipartek.formacion.game.pojo;

import java.sql.Date;
import java.util.Calendar;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Juego {

	private long id;
	
	@NotBlank
	@Size(max=150, min=2)
	private String titulo;
	
	private Date fechaLanzamiento;
	
	public Juego() {
		super();
		this.id = -1;
		this.titulo = "";
		this.fechaLanzamiento = new Date( Calendar.getInstance().getTimeInMillis() );
	}
	
	public Juego(String titulo, Date fechaLanzamiento) {
		super();
		this.titulo = titulo;
		this.fechaLanzamiento = fechaLanzamiento;
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
