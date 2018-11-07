package com.ipartek.formacion.supermercado.model;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Producto {

	private static final int MIN_DESCUENTO = 0;
	private static final int MIN_MAXIMO = 0;

	private long id;
	private float precio;
	private int descuento; // 0 - 100

	private String nombre;
	private String unidad; // Unidad de medida
	private String imagen;
	private String descripcion;

	public Producto() {
		super();
		this.id = 1;
		this.nombre = "";
		this.unidad = "L.";
		this.imagen = "images/default.png";
		this.descripcion = "";
	}

	public Producto(long id, float precio, int descuento, String nombre, String unidad, String imagen,
			String descripción) {
		super();
		this.id = id;
		this.precio = precio;
		this.descuento = descuento;
		this.nombre = nombre;
		this.unidad = unidad;
		this.imagen = imagen;
		this.descripcion = descripcion;
	}

	// GETTERS AND SETTERS
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getPrecio() {

		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCalcularDescuento() {
		
		DecimalFormat formatoPrecioTotal = new DecimalFormat("#.00");
		
		float descuento = (this.precio * this.descuento) / 100;	
		return formatoPrecioTotal.format(this.precio - descuento); 
	}

}
