package es.deusto.server.services;

import java.rmi.Naming;
import java.util.HashMap;

import es.deusto.server.assemblers.LoginAssembler;
import es.deusto.server.assemblers.UsuarioAssembler;
import es.deusto.server.dao.DBManager;
import es.deusto.server.data.Usuario;
import es.deusto.server.dto.UsuarioDTO;
import es.deusto.server.remote.ISpotify;

public class LoginService {

	public static LoginService instance = null;

	private ISpotify service;
	
	public static LoginService getInstance() {
		if (instance == null) {
			instance = new LoginService();
		}
		return instance;
	}

	public LoginService()
	{
		
	}
	
	
	public LoginService(String _ip, String _puerto, String _nombreServer) {
		
		try {
			String URL = "//" + _ip + ":" + _puerto + "/" + _nombreServer;
			this.service = (ISpotify) Naming.lookup(URL);

			System.out.println(" * Autorizcion '" + URL + "' localizado!!");
		} catch (Exception ex) {
			System.err.println("# Error locating remote facade LOGIN: " + ex);
			ex.printStackTrace();
		}
		
	}
	public ISpotify getService() {
		return this.service;
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
	
	
	public boolean registrarUsuario(String _email, String _password)
	{
		
		boolean existe=false;
		DBManager.getInstance();
		
		try
		{
			existe = DBManager.getInstance().registrarUsuario(_email, _password);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return existe;
		
	}
	
	
	public UsuarioDTO sacarUsuario(String _correo, String _password)
	{
		
		Usuario miusuario = null;
		DBManager.getInstance();
		try{
			miusuario =  DBManager.getInstance().loginUsuario(_correo, _password);
			if(miusuario==null)
			{
				System.out.println("USUARIO NULO NO LO BUSCA");
			}
		
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return LoginAssembler.getInstance().getUsuarioDTO(miusuario);
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
