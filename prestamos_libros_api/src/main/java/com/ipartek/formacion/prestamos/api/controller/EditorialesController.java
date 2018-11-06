package com.ipartek.formacion.prestamos.api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipartek.formacion.libros.pojo.Editorial;
import com.ipartek.formacion.libros.service.ServiceEditorial;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/editoriales")
public class EditorialesController {

	private static ServiceEditorial editorialServicio;

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ArrayList<Editorial> detalle() {

		ArrayList<Editorial> editoriales = new ArrayList<Editorial>();
		editorialServicio = ServiceEditorial.getInstance();
		try {

			editoriales = (ArrayList<Editorial>) editorialServicio.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return editoriales;
	}

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody boolean crear(@RequestBody String userJson) {

		editorialServicio = ServiceEditorial.getInstance();

		boolean resul = false;

		try {

			ObjectMapper mapper = new ObjectMapper();
			Editorial editorial = new Editorial();

			editorial = mapper.readValue(userJson, Editorial.class);
			resul = editorialServicio.crear(editorial);
			return resul;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resul;

	}
	
	//TODO Hay que poder cojerlo solo desde la id
	@RequestMapping(method = RequestMethod.DELETE)
	public @ResponseBody boolean eliminar(@RequestBody String userJson) {

		editorialServicio = ServiceEditorial.getInstance();
		boolean resul = false;
		try {

			ObjectMapper mapper = new ObjectMapper();
			Editorial editorial = new Editorial();

			editorial = mapper.readValue(userJson, Editorial.class);
			String id = String.valueOf(editorial.getId());
			resul = editorialServicio.eliminar(id);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return resul;
	}
	
	//TODO Hay que poder cojerlo solo desde la id
		@RequestMapping(method = RequestMethod.PUT)
		public @ResponseBody boolean modificar(@RequestBody String userJson) {

			editorialServicio = ServiceEditorial.getInstance();
			boolean resul = false;
			try {

				ObjectMapper mapper = new ObjectMapper();
				Editorial editorial = new Editorial();

				editorial = mapper.readValue(userJson, Editorial.class);
				resul = editorialServicio.modificar(editorial);

			} catch (Exception e) {
				e.printStackTrace();
			}

			return resul;

		}

}
