package com.chuck.test;

import java.rmi.RemoteException;

import com.chuck.ChuckNorrisProxy;

public class Testing {

	public static void main(String[] args) throws RemoteException {
		
		System.out.println("Chuck Norris dice:");
		
		ChuckNorrisProxy cliente = new ChuckNorrisProxy();		
		String frase = cliente.dimeFrase(); 
				
		System.out.println(frase);	
		

	}

}
