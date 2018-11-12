-- Listado de todas las casas de Howards  : 
SELECT nombre FROM casa ORDER BY nombre DESC;

-- Tres primeros Alumnos con mejor nota en el año 2017 
SELECT a.nombre, a.apellidos, aha.anio, avg(aha.nota)
FROM   alumno AS a, alumno_has_asignatura AS aha      
WHERE a.id=aha.alumno_id AND aha.anio=2017
group by a.nombre
ORDER BY AVG (aha.nota) DESC
LIMIT 3;

-- Listado de profesores y materias impartidas ordenado por materias alfabéticamente para un año concreto 
SELECT p.nombre, p.apellidos, asig.nombre
FROM profesor AS p, profesor_has_asignatura AS pha, asignatura AS asig
WHERE p.id=pha.profesor_id AND asig.id=pha.asignatura_id AND pha.anio=2017
ORDER BY asig.nombre ASC;

-- Listado de habitaciones y alumnos que hay en cada una - 1 punto
SELECT h.ubicacion, a.nombre, a.apellidos
FROM habitacion AS h, alumno AS a, alumno_has_habitacion AS ahh
WHERE h.id=ahh.habitacion_id AND a.id=ahh.alumno_id
ORDER BY h.ubicacion;


-- Listado Partidos jugados año 2017 ordenados por fecha - 1 punto (??)
SELECT pq.fecha, p.nombre AS Arbitro, a.nombre AS MVP, c.nombre, chpq.puntuacion
FROM partido_quidditch AS pq, 
	 profesor AS p, 
     alumno AS a, 
     casa AS c,
     casa_has_partido_quidditch AS chpq,
     alumno_has_partido_quidditch AS ahpq
WHERE YEAR(fecha)=2017 
	AND p.id=arbitro
    AND pq.mvp=a.id
    AND c.id=chpq.casa_id
    AND a.id=ahpq.alumno_id
ORDER BY fecha DESC;

-- Nota media de los alumnos para una materia y un año - 1 punto
SELECT avg(nota), a.nombre
FROM alumno_has_asignatura as aha, asignatura as a
WHERE anio=2017 AND a.id=aha.asignatura_id and a.nombre= 'Encantamientos'
GROUP BY asignatura_id;

-- Nota media de los alumnos de cada una de las casas por materia 1 punto
SELECT c.nombre, asig.nombre, AVG(nota) FROM alumno_has_asignatura AS aha, alumno as a, casa AS c, asignatura AS asig
WHERE a.id=alumno_id AND c.id=a.casa_id AND asig.id=aha.asignatura_id
GROUP BY c.id, asig.id
ORDER BY c.id DESC;