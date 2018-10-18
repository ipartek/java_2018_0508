SELECT count(distinct(v.id)) as 'casas vacias', m.codigo,m.nombre
FROM propiedad as p, municipio as m, persona as pe, vivienda as v
WHERE m.id = v.id_municipio and v.id = p.id_vivienda and p.empadronado = 0 and pe.id = p.id_persona
group by m.codigo

-- p.id_vivienda, p.empadronado, p.id_persona, m.id, m.codigo,m.nombre,pe.id,pe.nombre,pe.apellido1,pe.apellido1,v.id,v.codigo,v.calle,v.numero