/******************************************************************/
/*		EJERCICIO 1		*/
/******************************************************************/
SELECT d.nombre as `departamento`, e.apellido as `empleado`, p.nombre , p.sueldo
FROM   departamento as d
INNER JOIN empleado as e
ON d.id = e.id_departamento
INNER JOIN puesto as p
ON e.id_puesto = p.id
ORDER BY d.nombre ASC,p.sueldo ASC;
/******************************************************************/
SELECT d.nombre as `departamento`, e.apellido as `empleado`,p.nombre, p.sueldo
FROM   departamento as d, empleado as e, puesto as p
WHERE d.id = e.id_departamento AND e.id_puesto = p.id
ORDER BY d.nombre ASC,p.sueldo ASC;
/******************************************************************/
/*		EJERCICIO 2		*/
/******************************************************************/
SELECT e.apellido, d.nombre, p.sueldo
FROM   departamento as d
RIGHT JOIN empleado as e
ON d.id = e.id_departamento
INNER JOIN puesto as p
ON e.id_puesto = p.id
ORDER BY e.apellido ASC,p.sueldo ASC;
/******************************************************************/
/*		EJERCICIO 3	*/
/******************************************************************/
SELECT d.nombre, COUNT(e.id_departamento) as N_Empleados
FROM   departamento as d
LEFT JOIN empleado as e
ON d.id = e.id_departamento
GROUP BY d.nombre;