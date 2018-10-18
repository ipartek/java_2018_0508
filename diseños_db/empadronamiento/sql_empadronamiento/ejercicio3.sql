SELECT p.id_vivienda, p.empadronado, p.id_persona, m.id, m.codigo,m.nombre,pe.id,pe.nombre,pe.apellido1,pe.apellido1,v.id,v.codigo,v.calle,v.numero
FROM propiedad as p, municipio as m, persona as pe, vivienda as v
WHERE pe.id = p.id_persona and p.id_vivienda = v.id and v.calle = 'Juan de garay' and v.numero = '8'