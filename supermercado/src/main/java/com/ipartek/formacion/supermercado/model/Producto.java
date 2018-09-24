package com.ipartek.formacion.supermercado.model;

public class Producto {

	private long id;
	private String nombre;
	private float precio;
	private int descuento; // de 0 a 100
	private String imagen;
	private String descripcion;
	private String precioUnidad; // precio por cantidad (ej: €/L )

	public Producto() {
		super();
		this.id = -1;
		this.nombre = "";
		this.precio = 0;
		this.descuento = 0; // de 0 a 100
		this.imagen = "images/default_product.jpg";
		this.descripcion = "";
		this.precioUnidad = "";
	}

	public Producto(long id, String nombre, float precio, int descuento, String imagen, String descripcion,
			String precioUnidad) {
		this();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.precioUnidad = precioUnidad;
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

	public String getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(String precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public float getCalcularDescuento() {

		return  this.getPrecio() - (Math.round(this.getPrecio() * this.getDescuento()) / 100);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento
				+ ", imagen=" + imagen + ", descripcion=" + descripcion + ", precioUnidad=" + precioUnidad + "]";
	}

}
