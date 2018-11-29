package com.ipartek.formacion.personas.pojo;

import java.util.Set;

import javax.validation.ConstraintViolation;

/**
 * Clase propia creada para la gestión de las validaciones a la hora de
 * insertar/modificar un registro de la Base de Datos. </br>
 * Sus atributos son:
 * <ul>
 * <li>boolean resultado, indica si la operación ha sido existosa</li>
 * <li>Set<ConstraintViolation<Persona>>, con las violaciones encontradas en el
 * objeto.
 * </ul>
 * 
 * @author Luis
 *
 */
public class ResultadoUpdate {

	boolean result;
	Set<ConstraintViolation<Persona>> violations;

	public ResultadoUpdate() {
		super();
		this.result = false;
	}

	public ResultadoUpdate(Set<ConstraintViolation<Persona>> violations) {
		this();
		this.violations = violations;
	}

	public ResultadoUpdate(boolean result, Set<ConstraintViolation<Persona>> violations) {
		super();
		this.result = result;
		this.violations = violations;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Set<ConstraintViolation<Persona>> getViolations() {
		return violations;
	}

	public void setViolations(Set<ConstraintViolation<Persona>> violations) {
		this.violations = violations;
	}

	@Override
	public String toString() {
		return "ResultadoUpdate [result=" + result + ", violations=" + violations + "]";
	}
	
	

}
