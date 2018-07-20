package com.ipartek.formacion.uf2216;

import java.util.ArrayList;
import java.util.List;

public class RevistasArrayDAO implements CrudAble<Revistas> {
	
	private static RevistasArrayDAO INSTANCE=null;
	private static List<Revistas> Lista=null;
	
	private RevistasArrayDAO(){
		
		Lista= new ArrayList<Revistas>();
			
	}
	
	public static synchronized RevistasArrayDAO getInstance() {
		
		if(INSTANCE==null) {
			
			INSTANCE= new RevistasArrayDAO();
		}
		
		return INSTANCE;
	}

	@Override
	public boolean insert(Revistas revista) {
		
        boolean resul=false;
		
		if(revista!=null) {
			
			Lista.add(revista); 
			resul=true;
			
		}
		
		return resul;
	}

	@Override
	public List<Revistas> getAll() {
		
		return Lista;
	}

	@Override
	public Revistas getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Revistas pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
