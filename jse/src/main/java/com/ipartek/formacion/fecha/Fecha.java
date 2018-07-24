package com.ipartek.formacion.fecha;

public class Fecha {

	private int ano = 0;
	private int mes = 1;
	private int dia = 1;

	public static final int MESES_ANO = 12;

	// --------------- CONSTRUCTORES -------------//
	// ------------------------------------------//
	public Fecha() {
		super();
	}

	public Fecha(int ano, int mes, int dia) throws FechaException {

		if (esFechaCorrecta(ano, mes, dia)) {

			this.ano = ano;
			this.mes = mes;
			this.dia = dia;

		} else {
			throw new FechaException("La fecha indicada no es correcta.");
		}
	}

	public Fecha(Fecha f) {

		this();
		this.ano = f.getAno();
		this.mes = f.getMes();
		this.dia = f.getDia();

	}

	// ----------- GETTERS AND SETTERS ----------//
	// ------------------------------------------//
	public int getAno() {
		return ano;
	}

	public int getMes() {
		return mes;
	}

	public int getDia() {
		return dia;
	}

	public void setAno(int ano) throws FechaException {
		if (esFechaCorrecta(ano, this.mes, this.dia)) {

			this.ano = ano;
		} else {
			throw new FechaException("La fecha indicada no es correcta.");
		}
	}

	public void setMes(int mes) throws FechaException {
		if (esFechaCorrecta(this.ano, mes, this.dia)) {

			this.mes = mes;
		} else {
			throw new FechaException();
		}
	}

	public void setDia(int dia) throws FechaException {
		if (esFechaCorrecta(this.ano, this.mes, dia)) {
			this.dia = dia;
		} else {
			throw new FechaException("La fecha indicada no es correcta.");
		}
	}

	public void set(int ano, int mes, int dia) throws FechaException {

		if (esFechaCorrecta(ano, mes, dia)) {

			this.setAno(ano);
			this.setMes(mes);
			this.setDia(dia);

		} else {
			throw new FechaException("La fecha indicada no es correcta.");
		}
	}

	public void set(Fecha f) { // Se entiende que ha sido correctamente creada

		setAno(f.getAno());
		setMes(f.getMes());
		setDia(f.getDia());

	}

	/**
	 * Devuelve un String con la representaci�n del objeto Fecha en formato
	 * DD/MM/AAAA
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		if (this.dia < 10) {
			sb.append('0');
		}
		sb.append(this.dia + "/");
		sb.append(this.mes + "/");
		sb.append(this.ano);

		return sb.toString();

	}

	// --------------- OTROS M�TODOS ------------//
	// ------------------------------------------//
	public boolean equals(Object o) {

		if (o instanceof Fecha) { // Si es una instancia de la clase Fecha

			Fecha f = (Fecha) o; // Hacemos un CAST

			return (ano == f.getAno() && mes == f.getMes() && dia == f.getDia()); // Comprobamos los atributos
		}
		return false;
	}

	/**
	 * Funcion booleana que comprueba si un a�o es bisiesto.
	 * 
	 * @param a�o, Integer
	 * @return <b>true</b> si a�o es bisiesto, <b>false</b> en caso contrario.
	 */
	public static boolean esBisiesto(int ano) {

		return (ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0));
	}

	/**
	 * Funcion booleana que comprueba si el a�o del obeto Fecha es bisiesto.
	 * 
	 * @param a�o, Integer
	 * @return <b>true</b> si el a�o es bisiesto, <b>false</b> en caso contrario.
	 */
	public boolean esBisiesto() {

		return (this.ano % 4 == 0) && ((this.ano % 100 != 0) || (this.ano % 400 == 0));
	}

	/**
	 * Funci�n booleana que comprueba si ula fecha DIA/MES/A�O es correcta.
	 * 
	 * @param a�o
	 * @param mes
	 * @param dia
	 * @return <b>true</b> si diaCorrecioe, <b>false</b> en caso contrario.
	 */
	public boolean esFechaCorrecta(int ano, int mes, int dia) { // M�todo para comprobar si la fecha es correcta

		boolean esDiaCorrecto = false;
		boolean esMesCorrecto = false;
		boolean esAnoCorrecto = false;

		esAnoCorrecto = ano > 0;
		esMesCorrecto = mes >= 2 && mes <= MESES_ANO;

		switch (mes) {
		case 2: // Mes Febrero

			if (esBisiesto(ano)) { // Febrero y adem�s bisiesto

				esDiaCorrecto = dia >= 1 && dia <= 29;
			} else {

				esDiaCorrecto = dia >= 1 && dia <= 28;
			}
			break;

		case 4: // Meses con 30 d�as
		case 6:
		case 9:
		case 11:

			esDiaCorrecto = dia >= 1 && dia <= 30;
			break;

		default: // Meses con 31 d�as

			esDiaCorrecto = dia >= 1 && dia <= 31;
		}
		return (esAnoCorrecto && esMesCorrecto && esDiaCorrecto);

	} // FIN esFechaCorrecta();

} // FIN Fecha
