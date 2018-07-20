package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.uf2216.CrudAble;
import com.ipartek.formacion.uf2216.RevistaArrayDAO;
import com.ipartek.formacion.uf2216.Revista;

public class RevistaArrayDAO implements CrudAble<Revista>{
	
	//Atributos estatictos
			private static RevistaArrayDAO INSTANCE = null;
			private static List<Revista> lista = null;
			
	//PATRON SINGLETON
			private RevistaArrayDAO() {
				lista = new ArrayList<Revista>();
			}
			public static synchronized RevistaArrayDAO getInstance() { 
				if (INSTANCE == null) { 
					INSTANCE = new RevistaArrayDAO(); //Así solo tenemos un objeto LibrosArrayDao
				}
				return INSTANCE; //Devuelve un objeto de la propia clase
			}
			
			
	//Todos los metodos que implementa la interfaz crudable - EN ESTE CASO NO SON IMPORTANTES
			@Override
			public boolean insert(Revista nueva_revista) {
				boolean resul = false;
				if ( nueva_revista != null ) {
					resul = lista.add(nueva_revista);			
				}			
				return resul;
			}
			
			
			@Override
			public List<Revista> getAll() {
				return lista;
			}
			
			/**
			 * Al haber dicho que no importaba el id,no lo he creado como atributo
			 */
			@Override
			public Revista getById(long id) {
				Revista resul = null;
				//foreach
				for (Revista revistaIteracion : lista) {
					if ( id == revistaIteracion.getId() ) { //Si coinciden los ID
						resul = revistaIteracion;//Guardamos resultado
						break;
					}
				}
				return resul;
			}
			
			
			@Override
			public boolean update(Revista revista_modificada) {
				boolean resul = false;
				Revista rIteracion = null;
				//buscar libro a eliminar
				for (int i = 0; i < lista.size(); i++) {
					
					rIteracion = lista.get(i);   //revista sobre el que iteramos
					
					if ( revista_modificada.getid() == rIteracion.getId() ) {    // revista encontrado
						lista.set(i, revista_modificada);
						resul = true;
					}
				}
				return resul;
			}
			
			
			//@Override
			public boolean delete(long id) {
				boolean resul = false;
				Revista rIteracion = null;
				
				//buscar revista a eliminar
				for (int i = 0; i < lista.size(); i++) {
					
					rIteracion = lista.get(i);   //revista sobre el que iteramos
					
					if ( id == rIteracion.getId() ) {    // revista encontrado
						resul = lista.remove(rIteracion);
						break;
					}
				}
				return false;
			}	
}
