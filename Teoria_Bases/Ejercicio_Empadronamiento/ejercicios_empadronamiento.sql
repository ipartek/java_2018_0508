/*Ejercicios Empadronamiento*/
USE empadronamiento;
/*Queremos poder consultar las direcciones y números de las viviendas propiedad de una persona según su DNI.*/
SELECT v.calle,v.numero
FROM vivienda as v
INNER JOIN propiedad as p ON v.id = p.id_vivienda
INNER JOIN persona as per ON p.id_persona = per.id
WHERE per.dni LIKE '123456789';
/*Necesitamos los nombres y apellidos de los propietarios de un municipio determinado.*/
SELECT per.nombre, per.apellido1, per.apellido2
FROM persona as per
INNER JOIN propiedad as p ON per.id = p.id_persona
INNER JOIN vivienda as v ON p.id_vivienda = v.id
INNER JOIN municipio as m ON v.id_municipio = m.id
WHERE m.codigo LIKE '013';
/*Queremos poder preguntar quién está empadronado en una vivienda según su dirección y número.*/
SELECT per.nombre, per.apellido1, per.apellido2
FROM persona as per
INNER JOIN propiedad as p ON per.id = p.id_persona
INNER JOIN vivienda as v ON p.id_vivienda = v.id
WHERE v.calle LIKE 'minerias' AND v.numero = 1 AND p.empadronado = 1;
/*Numero de casas vacias por municipio*/
SELECT m.nombre, COUNT(DISTINCT (v.id)) as 'Casas Vacias'
-- SELECT *
FROM municipio as m
INNER JOIN vivienda as v ON m.id = v.id_municipio
INNER JOIN propiedad as p ON v.id = p.id_vivienda
WHERE p.empadronado = 0
GROUP BY m.codigo;