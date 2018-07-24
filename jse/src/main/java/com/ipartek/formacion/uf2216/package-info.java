/**
 * Package con el examen de la Unidad Formativa 2216 resuelto.
 * 
 * El ejercicio consiste en crear una aplicación que nos solicite datos por
 * pantalla para poder crear nuevos registros en nuestro CMS. Nuestro CMS se
 * encarga de gestionar REVISTAS, por lo cual la aplicación debe solicitar los
 * siguientes datos:
 * 
 * <ul>
 * <li>String Título ( 3 - 150 caracteres)</li>
 * <li>String ISBN (10 caracteres)</li>
 * <li>int Número de páginas ( >= 1)</li>
 * <li>boolean Formato ( digital == true, papel == false)</li>
 * </ul>
 * 
 * Cada campo que solicitamos deberá ser comprobado que tiene un formato valido,
 * en caso de no cumplir el formato se solicitará de nuevo el mismo campo. Si el
 * formato es correcto solicita el siguiente campo. Cuando termina de solicitar
 * todos los campos debe mostrar un resumen de la revista a ingresar en el CMS,
 * además de pedir una confirmación si se quiere guardar.
 * 
 * Además deberá tener las siguientes funcionalidades:
 * 
 * <ul>
 * <li>Listar revistas insertadas</li>
 * <li>Guardar en un fichero.txt todos las revistas</li>
 * </ul>
 * 
 * @author Curso
 *
 */
package com.ipartek.formacion.uf2216;