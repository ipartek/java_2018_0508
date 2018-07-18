package com.ipartek.formacion.coches;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *  Curso Gestor de Coches
 */
import com.ipartek.formacion.model.CocheDao;
import com.ipartek.formacion.pojo.Coche;

public class GestorCoches {
	// La declaracion se puede hacer aqui
	static Coche[] Coches;
	static CocheDao CocheDao;

	public static void main(String[] args) throws Exception {
		// La inicializacion es mas correcta hacerla aqui
		Coches = new Coche[5];
		cargarMenu();
	}

	public static void cargarMenu() throws Exception {
		PrecargarCochesDemo();
		pintarMenu();
	}

	public static CocheDao PrecargarCochesDemo() {
		/**
		 * long id, String marca, String modelo, long km, String matricula
		 */
		CocheDao = CocheDao.getInstance();
		Coche coche1 = new Coche(1, "Audi", "A3", 12000, "xa-1234-asd");
		Coche coche2 = new Coche(2, "Seat", "Ibiza", 12000, "xa-1234-asd");
		Coche coche3 = new Coche(3, "Mercedes", "i 320", 12000, "xa-1234-asd");
		Coche coche4 = new Coche(4, "wolsvagen", "Golf", 12000, "xa-1234-asd");
		Coche coche5 = new Coche(5, "Ferrari", "Rosa", 12000, "xa-1234-asd");
		CocheDao.insert(coche1);
		CocheDao.insert(coche2);
		CocheDao.insert(coche3);
		CocheDao.insert(coche4);
		CocheDao.insert(coche5);
		return CocheDao;
	}

	public static void pintarMenu() throws Exception {
		int opcion;

		System.out.println("-------------------------------------");
		System.out.println("-------Registro de vehiculos---------");
		System.out.println("-------------Opciones----------------");
		System.out.println("-------------1: Añadir---------------");
		System.out.println("-----2: Listar todos los coches------");
		System.out.println("-----3: Listar todos los coches por marca------");
		System.out.println("-----4: Listar todos los coches con Km por debajo de------");
		System.out.println("-----5: Listar el coche con mas Km-----");
		System.out.println("-----6: Listar por km ------");
		System.out.println("-----7: Salir ------");
		;
		System.out.println("-----Seleccione una opcion------");

		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			opcion = Integer.parseInt(br.readLine());

			// quito las opciones para ser llamadas desde una funcion
			opcionesMenu(opcion);

		} catch (Exception e) {
			System.out.println("Opcion incorrecta!! Pulse un numero del 1 al 6 para");
			pintarMenu();
		}

	}

	public static void opcionesMenu(int opcion) throws Exception {
		// constantes
		final int ANADIR = 1;
		final int LISTAR_TODOS = 2;
		final int LISTAR_TODOS_MARCA = 3;
		final int LISTAR_TODOS_KM_ABAJO = 4;
		final int LISTAR_TODOS_KM_ARRIBA = 5;
		final int LISTAR_TODOS_KM = 6;
		final int SALIR = 7;
		switch (opcion) {
		case (ANADIR):
			anadirCoche();
			break;
		case (LISTAR_TODOS):
			listarTodos();
			break;
		case (LISTAR_TODOS_MARCA):
			listarTodosMarca();
			break;
		case (LISTAR_TODOS_KM_ABAJO):
			listarTodoskmAbajo();
			break;
		case (LISTAR_TODOS_KM_ARRIBA):
			listarTodoskmArriba();
			break;
		case (LISTAR_TODOS_KM):
			listarTodoskm();
			break;
		case (SALIR):
			salir();
			break;

		default:
			break;
		}
	}

	private static void salir() {
		System.out.println("Gracias por su consulta");
		System.exit(0);
		
	}

	private static void listarTodoskm() {
		// TODO Auto-generated method stub

	}

	private static void listarTodoskmArriba() {
		// TODO Auto-generated method stub

	}

	private static void listarTodoskmAbajo() {
		// TODO Auto-generated method stub

	}

	private static void listarTodosMarca() {
		// TODO Auto-generated method stub

	}

	private static void listarTodos() {
		// TODO Auto-generated method stub

	}

	private static void anadirCoche() {
		/**
		 * Necesitamos los siguientes datos menos el id que lo autogeneraremos long
		 * id,<br>
		 * String marca, String modelo, long km, String matricula<br>
		 */

		String marca;
		String modelo;
		String matricula;
		long km;

		try {
			try {

				marca = preguntarMarca();

			} catch (Exception e) {
				marca = preguntarMarca();
			}
			try {
				modelo = preguntarModelo();
			} catch (Exception e) {
				modelo = preguntarModelo();
			}
			try {
				matricula = preguntarMatricula();
			} catch (Exception e) {
				matricula = preguntarMatricula();
			}
			try {
				km = preguntarKm();
			} catch (Exception e) {
				System.out.println(("Por favor introduza la cantidad de kilometros en numero: Por ejemplo:120000"));
				km = preguntarKm();
			}

		} catch (Exception e) {
			System.out.println("Se ha producido un error, lamentablemente tendre que comenzar de nuevo");
			anadirCoche();
		}

	}

	private static long preguntarKm() {
		int km = 0;
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println("Introduce los kilometros que tiene el vehiculo");
			km = Integer.parseInt(br.readLine());
		} catch (Exception e) {
			preguntarKm();
		}
		return km;
	}

	private static String preguntarMatricula() throws Exception {
		String matricula;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Introduce la matricula del vehiculo");
		matricula = br.readLine();
		return matricula;
	}

	private static String preguntarModelo() throws Exception {
		String modelo;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Introduce el modelo del vehiculo");
		modelo = br.readLine();
		return modelo;

	}

	private static String preguntarMarca() throws Exception {
		/**
		 * dividiendo las preguntas en diferentes funciones puedo controlar mejor
		 * las<br>
		 * excepciones
		 */
		String marca;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Introduce la marca del vehiculo");
		marca = br.readLine();
		return marca;
	}

}
