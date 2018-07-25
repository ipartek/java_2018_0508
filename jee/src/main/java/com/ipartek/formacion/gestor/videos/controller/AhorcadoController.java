package com.ipartek.formacion.gestor.videos.controller;

import java.io.IOException;
//import java.util.logging.Logger;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/jugar-ahorcado")
public class AhorcadoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private static final short MAXIMO_INTENTOS = 7;

	private static final String[] arrayPalabras = { "cesar", "java ee", "css", "html", "Integer", "String", "Ahorcado",
			"lorem ipsum", "chrystallion", "character" };

	private static int aciertos = 0;
	private static String charAcertados;
	private static int fallos = 0;
	private static String charFallados;
	private static int intentos = 0;

	private static String palabra;
	private static int numLetras;

	// Las usaremos paras esconder/descubrir las letras de la palabra
	private static char[] respuesta;
	private static String solucion;
	private static String intento;
	private static String caracter;

	// Lo usaremos para mostrar los diferentes mensajes (Acierto, fallo,
	// victoria...)
	private static String msg = "Comenzemos!";

	public AhorcadoController() {

		inicializarPartida();

	}

	private static void inicializarPartida() {

		aciertos = 0;
		charAcertados = "";
		fallos = 0;
		charFallados = "";
		intentos = 0;

		// Escogemos una palabra del array al azar
		int aleatorio = new Random().nextInt(arrayPalabras.length);
		palabra = arrayPalabras[aleatorio];
		// Contamos las letras sin repetir para saber cuando ha ganado
		numLetras = contarLetras(palabra);

		respuesta = new char[palabra.length()];

		// Inicializamos la variable respuesta con * y espacios
		for (int i = 0; i < palabra.length(); i++) {
			if (palabra.charAt(i) == ' ') {
				respuesta[i] = ' ';
			} else {
				respuesta[i] = '*';
			}
		}

		// Convertimos a String
		solucion = String.valueOf(respuesta);
		intento = "";
		
		msg = "Comenzamos!";

	}

	private static int contarLetras(String palabra) {
		int cont = 0; // Aquí guardaremos el número de letras no repetidas
		String letrasSinRepetir = new String();

		for (int i = 0; i < palabra.length(); i++) {
			if (!letrasSinRepetir.contains(Character.toString(palabra.charAt(i)))) {

				letrasSinRepetir += palabra.charAt(i);
			}

		}
		cont = letrasSinRepetir.length();
		return cont;
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String operacion;

		try {
			// Recogemos los parámetros de la VISTA
			caracter = request.getParameter("letra");
			intento = request.getParameter("intento");
			operacion = request.getParameter("operacion");

			if (operacion != null) { // Detectamos el botón pulsado
				
				switch (operacion) {
				case "Reiniciar":
					
					inicializarPartida();
					break;
					
				case "Ver":
					
					msg = "Has perdido!";
					descubrirPalabra();
					break;
					
				case "Enviar":	
					jugar();
					break;
					
				default:
					msg = "Error inesperado";
					break;
				}	
			} 

			// Enviamos los atributos
			request.setAttribute("solucion", solucion);
			request.setAttribute("aciertos", aciertos);
			request.setAttribute("charAcertados", charAcertados);
			request.setAttribute("fallos", fallos);
			request.setAttribute("charFallados", charFallados);
			request.setAttribute("intentos", intentos);
			request.setAttribute("msg", msg);

			// Llamamos a la VISTA
			request.getRequestDispatcher("ahorcado.jsp").forward(request, response);	
			
		} catch (Exception e) {
			
		}
		

	}

	private void jugar() {

		boolean acertado;

		// Tratamos los valores recogidos
		if (intento != null && !intento.trim().isEmpty()) { // Si trata de solucionar la palabra

			if (intento.equalsIgnoreCase(palabra)) { // Ha acertado la palabra

				msg = "Enhorabuena, has acertado la palabra!";

				descubrirPalabra();

			} else { // Ha dado una solución errónea
				msg = "Lo siento, no es correcto. Has perdido!";

				descubrirPalabra();
		
			}
		} else if (caracter != null && caracter.trim().length() == 1) { // Ha introducido una letra

			char letra = caracter.charAt(0); // Convertimos a caracter

			acertado = pintarRespuesta(letra);

			if (acertado) {
				aciertos++; // Sumamos un acierto
				charAcertados += letra + "\t"; // Lo añadimos al String de aciertos
				msg = "Has acertado!";
			} else {
				fallos++; // Sumamos un fallo
				charFallados += letra + "\t"; // Lo añadimos al String de aciertos
				msg = "Has fallado!";
			}

			intentos++; // En cualquier caso sumamos un intento

			if (aciertos == numLetras) { // No quedan letras por descubrir
				msg = "Enhorabuena, has descubierto la palabra!";
				descubrirPalabra();

			} else if (intentos == MAXIMO_INTENTOS) { // Comprobamos si no hay más intentos

				msg = "Lo sentimos, se acabaron los intentos!";
				descubrirPalabra();

			} else {
				solucion = String.valueOf(respuesta);
			}

		}

	}

	private void descubrirPalabra() {
		respuesta = palabra.toCharArray();
		solucion = String.valueOf(respuesta);
	}

	private boolean pintarRespuesta(char letra) {
		boolean acertado = false;

		for (int i = 0; i < palabra.length(); i++) { // Para cada letra de la Palabra

			if (palabra.charAt(i) == letra) { // Si se encuentra la letra (una o más veces)

				acertado = true;
				respuesta[i] = letra; // Pintamos la letra en la respuesta
			}
		}
		return acertado;

	}

}
