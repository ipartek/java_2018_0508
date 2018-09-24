package com.ipartek.formacion.supermercado.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductoArrayDAO implements Crudable<Producto> {

	private static ProductoArrayDAO INSTANCE = null;
	private static List<Producto> lista = null;

	private ProductoArrayDAO() {
		lista = new ArrayList<Producto>();
		try {
//			lista.add(new Producto("xuoXkMZvD5Q", "AC/DC - You Shook Me All Night Long", "Esta es la descripción del vídeo de AC/DC - You Shook Me All Night Long", new ArrayList<Comentario>()));
//			lista.add(new Producto("O71fetlkCZo", "Queen - We Are The Champions", "Esta es la descripción del vídeo de Queen - We Are The Champions", new ArrayList<Comentario>()));
//			lista.add(new Producto("EOKAnomhHRg", "Bleach Opening - Ranbu No Melody", "Esta es la descripción del vídeo de Bleach Opening - Ranbu No Melody", new ArrayList<Comentario>()));
//			lista.add(new Producto(id, nombre, precio, precioVolumen, descuento, descripcion, imagen));
			lista.add(new Producto(123, "Beefeater", 12.85f, 18.50f, 0, "BEEFEATER ginebra inglesa botella 70cl.", "images/beefeater.jpg"));
			lista.add(new Producto(124, "Beefeater", 7.90f, 18.50f, 20, "BEEFEATER ginebra inglesa botella 70cl.", "images/beefeater.jpg"));
			lista.add(new Producto(125, "Don Simón", 1.75f, 2.15f, 5, "Vino tinto 12 % vol alcohol. Clarificado y estabilizado. Franco y limpio. Microbiológicamente estable.", "images/donsimon.jpg"));
			lista.add(new Producto(126, "Absolut Vodka", 15.75f, 19.95f, 0, "Absolut Vodka es la marca líder de vodka Premium, con el auténtico sabor del vodka original o tus sabores favoritos elaborados con ingredientes naturales.", "images/absolut-vodka.png"));
			lista.add(new Producto(127, "Johnnie Walker (Blue Label)", 22.95f, 27.50f, 33, "Johnnie Walker es una marca de whisky escocés producida por Diageo en Kilmarnock, Escocia.", "images/johnnie-walker-blue-label.jpg"));
			lista.add(new Producto(128, "Paulaner", 2.95f, 5.35f, 10, "Como marca líder de cerveza de trigo, la Cervecería Paulaner asume responsabilidad y aboga por un consumo responsable de bebidas alcohólicas.", "images/paulaner.jpg"));
			lista.add(new Producto(129, "Santa Teresa", 17.95f, 20.50f, 0, "Con una mezcla de rones Premium y hasta cinco años en barriles y barricas de roble, Santa Teresa Gran Reserva es la joya de la corona de los rones.", "images/santateresa.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static synchronized ProductoArrayDAO getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new ProductoArrayDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Producto producto) {
		boolean resul = false;
		if (producto != null) {
			resul = lista.add(producto);
		}
		return resul;
	}

	@Override
	public List<Producto> getAll() {
		return lista;
	}

	@Override
	public Producto getById(long id) {
		Producto resul = null;
		if (id != 0) {
			for (Producto productoIteracion : lista) {
				if (id == productoIteracion.getId()) {
					resul = productoIteracion;
					break;
				}
			}
		}
		return resul;
	}

	@Override
	public boolean update(Producto productoUpdate) {
		boolean resul = false;
		Producto productoIteracion = null;
		int i = 0;
		if (productoUpdate != null) {
			// Iterator
			Iterator<Producto> it = lista.iterator();
			while (it.hasNext()) {
				productoIteracion = it.next();
				if (productoIteracion.getId() == productoUpdate.getId()) {
					lista.set(i, productoUpdate);
					resul = true;
					break;
				}
				i++;
			}
		}
		return resul;
	}

	@Override
	public boolean delete(long id) {
		boolean resul = false;
		Producto pIteracion = null;
		if (id != 0) {
			// buscar producto a eliminar
			for (int i = 0; i < lista.size(); i++) {
				pIteracion = lista.get(i); // producto sobre el que iteramos
				if (id == pIteracion.getId()) { // producto encontrado
					resul = lista.remove(pIteracion);
					break;
				}
			}
		}		
		return resul;
	}

	public int length() {
		return lista.size();
	}
}
