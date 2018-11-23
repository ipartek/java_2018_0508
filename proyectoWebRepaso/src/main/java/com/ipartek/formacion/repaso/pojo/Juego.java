package com.ipartek.formacion.repaso.pojo;

import java.sql.Date;
import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Juego {

	private long id;

	@NotBlank
	@Size(min = 2, max = 150)
	private String titulo;

	@NotNull
	private Date fecha_lanzamiento;

	public Juego() {
		super();
		this.id = -1;
		this.titulo = "";
		this.fecha_lanzamiento = new Date(Calendar.getInstance().getTime().getTime());
	}

	public Juego(String titulo, Date fecha_lanzamiento) {
		this();
		this.titulo = titulo;
		this.fecha_lanzamiento = fecha_lanzamiento;
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

	public Date getFecha_lanzamiento() {
		return fecha_lanzamiento;
	}

	public void setFecha_lanzamiento(Date fecha_lanzamiento) {
		this.fecha_lanzamiento = fecha_lanzamiento;
	}

}
