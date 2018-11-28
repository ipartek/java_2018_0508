package com.formaciion.ipartek.gestor.migrar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.formaciion.ipartek.gestor.DAO.PersonaDAO;
import com.formaciion.ipartek.gestor.pojo.Persona;

public class migrarDatos {
	private static PersonaDAO dao;

	public static void main(String[] args) throws IOException {
		dao = PersonaDAO.getInstance();
		BufferedReader br = null;
		try {			
			br = new BufferedReader(
					new FileReader("C:\\Desarrollo\\Workspace\\gestorPersona\\src\\main\\resources\\personas.txt"));

			Persona p = new Persona();
			String line = null;
			while ((line = br.readLine()) != null) {
				String tmp[] = line.split(",");
				p.setNombre(tmp[0]);
				p.setApellido1(tmp[1]);
				p.setApellido2(tmp[2]);
				p.setEmail(tmp[4]);
				p.setDni(tmp[5]);

				if (p.getNombre() != null && p.getApellido1() != null && p.getApellido2() != null
						&& p.getEmail() != null && p.getDni() != null) {
					dao.insert(p);
				}

			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			br.close();
		}

	}
}
