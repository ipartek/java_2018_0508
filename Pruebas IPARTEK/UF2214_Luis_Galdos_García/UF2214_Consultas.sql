USE howarts;

-- Listado de todas las casas de howarts
SELECT 
	nombre as 'Casa' 
FROM 
	casa
ORDER BY 
	nombre
LIMIT 100;
    
-- Tres primeros Alumnos con mejor nota en el año 2017.
SELECT 
	a.nombre AS 'Alumno',
    ROUND(AVG(aha.nota), 2) AS 'Nota Media'
FROM 
	alumno AS a
INNER JOIN
    alumno_has_asignatura AS aha
ON 
	a.id = aha.alumno_id
WHERE 
	aha.anio = 2017
GROUP BY
	a.id
ORDER BY 
	AVG(aha.nota) DESC
LIMIT 3;

-- Listado de profesores y materias impartidas, ordenado por materias alfabéticamente, para un año concreto.
SELECT
	pha.anio AS 'Curso',
    a.nombre AS 'Asignatura',
    p.nombre AS 'Profesor'
FROM 
	profesor AS p
INNER JOIN	
	profesor_has_asignatura AS pha
ON 
	p.id = pha.profesor_id
INNER JOIN	
	asignatura AS a
ON 
	a.id = pha.asignatura_id
WHERE
	pha.anio = 2017
ORDER BY
	a.nombre ASC
LIMIT 100;

-- Listado de habitaciones y alumnos que hay en cada una.
SELECT
	h.ubicacion AS 'Habitacion',
	a.nombre AS 'Alumno'
FROM 
	habitacion AS h
INNER JOIN	
	alumno_has_habitacion AS aha
ON 
	h.id = aha.habitacion_id
INNER JOIN
	alumno AS a
ON 
	a.id = aha.alumno_id
ORDER BY
	h.ubicacion ASC
LIMIT 100;

-- Listado Partidos jugados año 2017 ordenados por fecha.
SELECT
	partido.fecha AS 'Año',
    casa.nombre AS 'Casa',
    profesor.nombre AS 'Arbitro',
    chpq.puntuacion AS 'Puntuación'
FROM 
	partido_quidditch AS partido
INNER JOIN
	profesor
ON
	profesor.id = partido.arbitro
INNER JOIN
	casa_has_partido_quidditch as chpq
ON
	partido.id = chpq.partido_quidditch_id
INNER JOIN
	casa
ON
	casa.id = chpq.casa_id
WHERE
	YEAR(partido.fecha) = 2017
ORDER BY 
	partido.fecha ASC
LIMIT 100;

-- Nota media de los alumnos para una materia y un año en concretos.
SELECT
	aha.anio AS 'Curso',
	asig.nombre AS 'Asignatura',
	alum.nombre AS 'Alumno',
    ROUND(AVG(aha.nota), 2) AS 'Nota Media'
FROM 
	alumno AS alum
INNER JOIN
    alumno_has_asignatura AS aha
ON 
	alum.id = aha.alumno_id
INNER JOIN
    asignatura AS asig
ON 
	asig.id = aha.asignatura_id
WHERE 
	aha.anio = 2017 AND asig.nombre = 'Transformaciones' -- aha.asignatura_id = 1
GROUP BY
	alum.id
ORDER BY 
	AVG(aha.nota) DESC
LIMIT 100;
	
-- Nota media de los alumnos de cada una de las casas por materia.
SELECT
	aha.anio AS 'Curso (Año)',
	c.nombre AS 'Casa',
	asig.nombre AS 'Asignatura',
    ROUND(AVG(aha.nota), 2) AS 'Nota MediaTotal' 
FROM 
	casa AS c
INNER JOIN
	alumno AS alum
ON
	c.id = alum.casa_id
INNER JOIN
    alumno_has_asignatura AS aha
ON 
	alum.id = aha.alumno_id
INNER JOIN
    asignatura AS asig
ON 
	asig.id = aha.asignatura_id
GROUP BY
	asig.id, c.id
ORDER BY 
	asig.nombre ASC, c.nombre ASC
LIMIT 100;
	
	
    
    

    



