package com.ipartek.formacion.gestiondocente.pojo;

import java.sql.Date;

public class Curso {

	private int codigo;
	private String nombre;
	private String identificador;
	private Date fInicio;
	private Date fFin;
	private int nHoras;
	private String temario;
	private int activo;
	private Cliente cliente;
	private float precio;
	private Profesor profesor;
	
	public Curso() {
		super();
		this.codigo = 0;
		this.nombre = "";
		this.identificador = "";
		this.fInicio = null;
		this.fFin = null;
		this.nHoras = 0;
		this.temario = "";
		this.activo = 0;
		this.cliente = null;
		this.precio = 0;
		this.profesor = null;
	}
	

	public Curso(int codigo, String nombre, String identificador, Date fInicio, Date fFin, int nHoras,
			String temario, int activo, Cliente cliente, float precio, Profesor profesor) {
		this();
		this.codigo = codigo;
		this.nombre = nombre;
		this.identificador = identificador;
		this.fInicio = fInicio;
		this.fFin = fFin;
		this.nHoras = nHoras;
		this.temario = temario;
		this.activo = activo;
		this.cliente = cliente;
		this.precio = precio;
		this.profesor = profesor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public Date getfInicio() {
		return fInicio;
	}

	public void setfInicio(Date fInicio) {
		this.fInicio = fInicio;
	}

	public Date getfFin() {
		return fFin;
	}

	public void setfFin(Date fFin) {
		this.fFin = fFin;
	}

	public int getnHoras() {
		return nHoras;
	}

	public void setnHoras(int nHoras) {
		this.nHoras = nHoras;
	}

	public String getTemario() {
		return temario;
	}

	public void setTemario(String temario) {
		this.temario = temario;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nombre=" + nombre + ", identificador=" + identificador + ", fInicio="
				+ fInicio + ", fFin=" + fFin + ", nHoras=" + nHoras + ", temario=" + temario + ", activo=" + activo
				+ ", cliente=" + cliente + ", precio=" + precio + ", profesor=" + profesor + "]";
	}

}
