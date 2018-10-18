-- Queremos poder consultar las direcciones y números de las viviendas propiedad de una persona según su DNI.

SELECT p.id_vivienda, p.empadronado, p.id_persona, v.id, v.codigo,v.calle,v.numero,v.id_municipio,pe.id,pe.dni,pe.nombre
FROM propiedad as p, vivienda as v, persona as pe
WHERE p.id_vivienda = v.id and p.id_persona = pe.id and pe.dni = '123456789'
LIMIT 1000;