SELECT p.id_vivienda, p.empadronado, p.id_persona, m.id, m.codigo,m.nombre,pe.id,pe.nombre,pe.apellido1,pe.apellido1,v.id
FROM propiedad as p, municipio as m, persona as pe, vivienda as v
where p.id_persona = pe.id and p.id_vivienda = v.id and v.id_municipio = m.id  and m.codigo = 013