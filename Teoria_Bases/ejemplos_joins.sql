/******************************************************************/
/*		JOINS		*/
/******************************************************************/
/*		INNER JOINS		*/
/******************************************************************/
/*		JOIN explicita		*/
 SELECT e.apellido, d.nombre
 FROM   empleado as e
 INNER JOIN departamento as d
 ON e.id_departamento = d.id;
 /******************************************************************/
 /*		JOIN implicita		*/
 SELECT e.apellido, d.nombre
 FROM   empleado as e, departamento as d
 WHERE e.id_departamento = d.id;
 /******************************************************************/
 /*	OUTER JOINS		*/
 /******************************************************************/
 /*	LEFT JOIN	*/
 SELECT e.apellido, d.nombre
 FROM   empleado as e
 LEFT JOIN departamento as d
 ON e.id_departamento = d.id;
 /******************************************************************/
 /*	RIGHT JOIN	*/
 SELECT e.apellido, d.nombre
 FROM   empleado as e
 RIGHT JOIN departamento as d
 ON e.id_departamento = d.id;
 /******************************************************************/
 /*	FULL JOIN	*/
 /* SELECT e.apellido, d.nombre
 FROM   empleado as e
 FULL OUTER JOIN departamento as d
 ON e.id_departamento = d.id; */
 /*	No existen en MySQL	*/