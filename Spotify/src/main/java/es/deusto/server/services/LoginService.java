package es.deusto.server.services;

import java.util.HashMap;

import es.deusto.server.dao.DBManager;
import es.deusto.server.data.Usuario;

public class LoginService {

	public static LoginService instance = null;

	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		return instance;
	}

	
	public LoginService()
	{
		
	}
	
	
	public LoginService(String _ip, String _puerto, String _nombre) {
		
		
	}
	
	
	
	public boolean login(String _correo, String _pass)
	{
		boolean correcto=false;
		
		DBManager.getInstance();
		
		Usuario user = DBManager.getInstance().buscarUsuario(_correo);
		
		if(user!=null)
			correcto=true;
		else
			correcto=false;
				
		return correcto;
		
		
	}
	
	/*
	public synchronized boolean autentificarUsuario(String correo, String pass){
		HashMap<String, Usuario> Husuarios;
		Husuarios=DBManager.getInstance().getHusuarios();
		Usuario usr;
		
	
		usr=Husuarios.get(correo);
		if(usr==null){
			return false;
		}else{
			return true;
		}
		
	}*/
	
}
