package com.ipartek.formacion.supermercado.model;

import java.text.DecimalFormat;

public class Producto {
	private long id;
	private String nombre;
	private float precio;
	private float precioVolumen; //Precio l o precio kg
	private int descuento; //De 0 a 100
	private String descripcion;
	private String imagen;
	
	public Producto() {
		super();
		this.id = -1;
		this.nombre = "";
		this.precio = 0;
		this.precioVolumen = 0;
		this.descuento = 0;
		this.descripcion = "";
		this.imagen = "images/default_product.png";
	}

	public Producto(long id, String nombre, float precio, float precioVolumen, int descuento, String descripcion,
			String imagen) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.precioVolumen = precioVolumen;
		this.descuento = descuento;
		this.descripcion = descripcion;
		this.imagen = imagen;
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

	public float getPrecioVolumen() {
		return precioVolumen;
	}

	public void setPrecioVolumen(float precioVolumen) {
		this.precioVolumen = precioVolumen;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getCalcularDescuento() {
		DecimalFormat df = new DecimalFormat("##.##");
		float total = this.precio - (this.precio * this.descuento / 100);
		return df.format(total);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", precioVolumen=" + precioVolumen
				+ ", descuento=" + descuento + ", descripcion=" + descripcion + ", imagen=" + imagen + "]";
	}
}
