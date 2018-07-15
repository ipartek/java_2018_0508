package com.ipartek.formacion.fecha;

public class Fecha {

	private int año = 0;
	private int mes = 1;
	private int dia = 1;

	public static final int MESES_AÑO = 12;

	// --------------- CONSTRUCTORES -------------//
	// ------------------------------------------//
	public Fecha() {
		super();
	}

	public Fecha(int año, int mes, int dia) throws FechaException {

		if (esFechaCorrecta(año, mes, dia)) {

			this.año = año;
			this.mes = mes;
			this.dia = dia;

		} else {
			throw new FechaException("La fecha indicada no es correcta.");
		}
	}

	public Fecha(Fecha f) {

		this();
		this.año = f.getAño();
		this.mes = f.getMes();
		this.dia = f.getDia();

	}

	// ----------- GETTERS AND SETTERS ----------//
	// ------------------------------------------//
	public int getAño() {
		return año;
	}

	public int getMes() {
		return mes;
	}

	public int getDia() {
		return dia;
	}

	public void setAño(int año) throws FechaException {
		if (esFechaCorrecta(año, this.mes, this.dia)) {

			this.año = año;
		} else {
			throw new FechaException("La fecha indicada no es correcta.");
		}
	}

	public void setMes(int mes) throws FechaException {
		if (esFechaCorrecta(this.año, mes, this.dia)) {

			this.mes = mes;
		} else {
			throw new FechaException();
		}
	}

	public void setDia(int dia) throws FechaException {
		if (esFechaCorrecta(this.año, this.mes, dia)) {
			this.dia = dia;
		} else {
			throw new FechaException("La fecha indicada no es correcta.");
		}
	}

	public void set(int año, int mes, int dia) throws FechaException {

		if (esFechaCorrecta(año, mes, dia)) {

			this.setAño(año);
			this.setMes(mes);
			this.setDia(dia);

		} else {
			throw new FechaException("La fecha indicada no es correcta.");
		}
	}

	public void set(Fecha f) { // Se entiende que ha sido correctamente creada

		setAño(f.getAño());
		setMes(f.getMes());
		setDia(f.getDia());

	}

	/**
	 * Devuelve un String con la representación del objeto Fecha en formato
	 * DD/MM/AAAA
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (this.dia < 10) {
			sb.append('0');
		}
		sb.append(this.dia + "/");
		sb.append(this.mes + "/");
		sb.append(this.año);

		return sb.toString();

	}

	// --------------- OTROS MÉTODOS ------------//
	// ------------------------------------------//
	public boolean equals(Object o) {

		if (o instanceof Fecha) { // Si es una instancia de la clase Fecha

			Fecha f = (Fecha) o; // Hacemos un CAST

			return (año == f.getAño() && mes == f.getMes() && dia == f.getDia()); // Comprobamos los atributos
		}
		return false;
	}

	/**
	 * Funcion booleana que comprueba si un año es bisiesto.
	 * 
	 * @param año, Integer
	 * @return <b>true</b> si año es bisiesto, <b>false</b> en caso contrario.
	 */
	public static boolean esBisiesto(int año) {

		return (año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0));
	}

	/**
	 * Funcion booleana que comprueba si el año del obeto Fecha es bisiesto.
	 * 
	 * @param año, Integer
	 * @return <b>true</b> si el año es bisiesto, <b>false</b> en caso contrario.
	 */
	public boolean esBisiesto() {

		return (this.año % 4 == 0) && ((this.año % 100 != 0) || (this.año % 400 == 0));
	}

	/**
	 * Función booleana que comprueba si ula fecha DIA/MES/AÑO es correcta.
	 * 
	 * @param año
	 * @param mes
	 * @param dia
	 * @return <b>true</b> si diaCorrecioe, <b>false</b> en caso contrario.
	 */
	public boolean esFechaCorrecta(int año, int mes, int dia) { // Método para comprobar si la fecha es correcta

		boolean esDiaCorrecto = false;
		boolean esMesCorrecto = false;
		boolean esAñoCorrecto = false;

		esAñoCorrecto = año > 0;
		esMesCorrecto = mes >= 2 && mes <= MESES_AÑO;

		switch (mes) {
		case 2: // Mes Febrero

			if (esBisiesto(año)) { // Febrero y además bisiesto

				esDiaCorrecto = dia >= 1 && dia <= 29;
			} else {

				esDiaCorrecto = dia >= 1 && dia <= 28;
			}
			break;

		case 4: // Meses con 30 días
		case 6:
		case 9:
		case 11:

			esDiaCorrecto = dia >= 1 && dia <= 30;
			break;

		default: // Meses con 31 días

			esDiaCorrecto = dia >= 1 && dia <= 31;
		}
		return (esAñoCorrecto && esMesCorrecto && esDiaCorrecto);

	} // FIN esFechaCorrecta();

} // FIN Fecha
