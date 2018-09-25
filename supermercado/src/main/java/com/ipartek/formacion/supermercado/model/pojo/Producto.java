package com.ipartek.formacion.supermercado.model.pojo;

public class Producto {

	private int id;
	private String nombre;
	private float precio;
	private int descuento;
	private String descripcion;// de 0 a 100 
	private String imagen;
	private float precioCantidad;
	
	public Producto() {
		super();
		this.id=-1;
		this.nombre="";
		this.precio=0;
		this.descuento=0;
		this.descripcion="";
		this.precioCantidad=0;
		this.imagen="images/default_product.png";
		
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Producto(int id, String nombre, float precio, int descuento, String descripcion, String imagen,
			float precioCantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.descuento = descuento;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precioCantidad = precioCantidad;
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

	public float getPrecioCantidad() {
		return precioCantidad;
	}

	public void setPrecioCantidad(float precioCantidad) {
		this.precioCantidad = precioCantidad;
	}

	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", precio=" + precio + ", descuento=" + descuento + ", descripcion="
				+ descripcion + ", imagen=" + imagen + ", precioCantidad=" + precioCantidad + "]";
	}
	
	public float getCalcularDescuento() {
		precio=this.getPrecio();
		descuento=this.getDescuento();
		float precioFinal = 0;
		if (descuento>0) {
			float rebaja=(precio/100)*descuento;
			
			precioFinal= Math.round(precio-rebaja);
		} else {
			precioFinal=precio;
		}
		
		
		
		
		return precioFinal;
		
	}

}
