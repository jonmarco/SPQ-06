package es.deusto.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import es.deusto.server.dto.CancionDTO;
import es.deusto.server.dto.ReproduccionDTO;
import es.deusto.server.services.BusquedaService;
import es.deusto.server.services.InteractuarService;
import es.deusto.server.services.LoginService;

/**
This class is the of Spotify
@author: Inigo Alonso

*/

public class Spotify extends UnicastRemoteObject implements ISpotify {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Spotify instance;
	private LoginService loginService;
	//private PagoPaypal pagoPaypal;

	protected Spotify() throws RemoteException {
		super();
	}
	public static Spotify getInstance() {
		if (instance == null) {
			try {
				instance = new Spotify();
			} catch (Exception ex) {
				System.out.println("#....Error al crear el RemoteFacade....#" + ex);
			}
		}
		return instance;
	}
	
	
	//para pasar los args
	public void setLoginService(String ip, String puerto, String nombre){
		this.loginService=new LoginService(ip,puerto,nombre);
	}
	
	/*
	public void setPagoService(String ip, String puerto, String nombre){
		this.pagoPaypal=new PagoPaypal(ip,puerto,nombre);
	}*/
	
	
	
	/**
	With this method, we find searching the name of the song

	*/
	@Override
	public ArrayList<CancionDTO> buscarCanciones(String titulo) throws RemoteException {
		// TODO Auto-generated method stub
		return BusquedaService.getInstance().buscarCanciones(titulo);
	}
	
	/**
	With this method, we list the name of all of the song

	*/
	@Override
	public CancionDTO buscarCancion(int id_cancion) throws RemoteException {
		return BusquedaService.getInstance().buscarCancion(id_cancion);
	}

	/**
	With this method, we add a new play 

	*/
	@Override
	public void aniadirReproduccion(int id_cancion, String correo) throws RemoteException {
		// TODO Auto-generated method stub
		InteractuarService.getInstance().aniadirReproduccion(correo, id_cancion);
				
	}
	
	/**
	With this method, we do the pays

	*/
	public ArrayList<ReproduccionDTO> usuarioReproducciones(String id_usuario){
		return InteractuarService.getInstance().usuarioReproducciones(id_usuario);
	}
	
	/**
	With this method, we will connect if exists (boolean=true)

	*/
	public boolean login(String nombre_usuario, String contrasenia) throws RemoteException {
		System.out.println(nombre_usuario+" est� tratando de conectar.");
		return LoginService.getInstance().login(nombre_usuario, contrasenia);
	}
	
	/*@Override
	public boolean pagoPaypal(String nombre, String contrasenia, String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}
	*/
	/*
	@Override
	public boolean pagoPaypal(String nombre, String contrasenia, String[] args) throws RemoteException {
		return this.pagoPaypal.pagoPaypal(nombre, contrasenia);
		
	}
	
	
	public boolean pagoBanco(String nombre, String contrasenia) throws RemoteException {
		return PagoBanco.getInstance().pagoBanco(nombre, contrasenia);
		
	}*/

	

}


