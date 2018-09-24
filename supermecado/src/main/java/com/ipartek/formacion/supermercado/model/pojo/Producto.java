package com.ipartek.formacion.supermercado.model.pojo;

public class Producto {
	private long id;
	private String nombreProducto;
	private float precioProducto;
	private int descuento; //de 0 a 100
	private String imgUrl;
	private float precioUnidad;
	private String descripcion;
	


	
	public Producto() {
		super();
		this.id = -1;
		this.nombreProducto = "";
		this.precioProducto = -1;
		this.descuento = -1;
		this.imgUrl = "https://sw.edu/biodiversity/wp-content/uploads/2013/11/noimg-e1385401442182.png";
		this.precioUnidad = -1;
		this.descripcion = descripcion;
	}
	public Producto(long id, String nombreProducto, float precioProducto, int descuento, String imgUrl,
			float precioUnidad, String descripcion) {
		this();
		this.id = id;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.descuento = descuento;
		this.imgUrl = imgUrl;
		this.precioUnidad = getPrecioUnidad();
		this.descripcion = descripcion;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public float getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(float precioProducto) {
		this.precioProducto = precioProducto;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public float getPrecioUnidad() {
		return precioUnidad;
	}
	public void setPrecioUnidad(int descuento) {
		this.precioUnidad = this.descuento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public long getFinalPrice() {
		long precioFinal;
		return  Math.round(( this.precioProducto - ( this.precioProducto * this.descuento /100 ) ));

		
	}
	
}
