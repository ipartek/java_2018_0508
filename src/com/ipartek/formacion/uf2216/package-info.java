/**
 * 
 * Crear una aplicación que nos solicite datos por pantalla para poder crear
 * nuevos registros en nuestro CMS.
 * 
 * Nuestro CMS se encarga de gestionar REVISTAS, por lo cual la aplicación debe
 * solicitar los siguientes datos:
 * 
 * 
 * 
 * 1. Titulo tamaño mínimo 3 letras, máximo 150
 * 
 * 2. ISBN número de longitud 10
 * 
 * 3. Número de Páginas mínimo 1
 * 
 * 4. Formato ( digital o papel ) true == digital false == papel
 * 
 * 
 * 
 * Cada campo que solicitamos deberá ser comprobado que tiene un formato valido,
 * en caso de no cumplir el formato se solicitará de nuevo el mismo campo. Si el
 * formato es correcto solicita el siguiente campo. * *** Cuando termina de
 * solicitar todos los campos debe mostrar un resumen del revista a ingresar en
 * el CMS, además de pedir una confirmación si se quiere guardar.
 * 
 * Además deberá tener las siguientes funcionalidades:
 * 
 * Listar revistas insertados Guardar en un fichero.txt todos las revistas
 * 
 * @author Curso
 *
 */
package com.ipartek.formacion.uf2216;