package com.ipartek.formacion.supermercado.model;

import java.text.DecimalFormat;

public class Producto {
	
	public static final String IMAGEN = "/images/default_product.png";
	
	
	private long id;
	private String nombre;
	private float precio;
	private int descuento;// 0 - 100
	private String imagen;
	private String descripcion;
	private float precioVolumen;// precio por litro o kg
	

	public Producto() {
		super();
		this.id = -1;
		this.nombre = "";
		this.precio = 0;
		this.descuento = 0;
		this.imagen = IMAGEN;
		this.descripcion = "";
		this.precioVolumen = 0;
		
	}

	public Producto(long id, String nombre, float precio, int descuento, String imagen, String descripcion,
			float precioVolumen) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.precioVolumen = precioVolumen;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public float getPrecioVolumen() {
		return precioVolumen;
	}

	public void setPrecioVolumen(float precioVolumen) {
		this.precioVolumen = precioVolumen;
	}

	/**
	 * Calcula el precio del descuento
	 * */
	public String getCalcularDescuento() {		
		DecimalFormat formateador = new DecimalFormat("####.##");
		
		return formateador.format(precio-(precio*descuento) / 100);
		
		
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", imagen=" + imagen + ", descripcion=" + descripcion + ", precioVolumen=" + precioVolumen + "]";
	}

}
