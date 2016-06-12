package es.deusto.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import es.deusto.server.dto.CancionDTO;
import es.deusto.server.dto.ReproduccionDTO;
import es.deusto.server.dto.UsuarioDTO;
import es.deusto.server.services.BusquedaService;
import es.deusto.server.services.InteractuarService;
import es.deusto.server.services.LoginService;

public class Spotify extends UnicastRemoteObject implements ISpotify {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Spotify instance;
	private LoginService loginService;
	//private PagoPaypal pagoPaypal;

	
	// aqui tenia PROTECTED
	public Spotify() throws RemoteException {
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
	
	

	@Override
	public ArrayList<CancionDTO> buscarCanciones(String titulo) throws RemoteException {
		// TODO Auto-generated method stub
		return BusquedaService.getInstance().buscarCanciones(titulo);
	}

	@Override
	public CancionDTO buscarCancion(int id_cancion) throws RemoteException {
		return BusquedaService.getInstance().buscarCancion(id_cancion);
	}

	@Override
	public void aniadirReproduccion(int id_cancion, String correo) throws RemoteException {
		// TODO Auto-generated method stub
		InteractuarService.getInstance().aniadirReproduccion(correo, id_cancion);
				
	}
	
	public ArrayList<ReproduccionDTO> usuarioReproducciones(String id_usuario){
		return InteractuarService.getInstance().usuarioReproducciones(id_usuario);
	}
	

	// METODO A MODIFICAR NOS CONECTAREMOS Y SI EXISTE BOOLEAN=TRUE
	public boolean login(String nombre_usuario, String contrasenia) throws RemoteException {
		System.out.println(nombre_usuario+" est� tratando de conectar.");
		return LoginService.getInstance().login(nombre_usuario, contrasenia);
	}
	@Override
	public UsuarioDTO sacarUsuario(String correo, String _password) throws RemoteException{
		// TODO Auto-generated method stub
		System.out.println("el correo introducido es:" + correo);
		return LoginService.getInstance().sacarUsuario(correo, _password);
	}
	@Override
	public boolean registrarUsuario(String correo, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return LoginService.getInstance().registrarUsuario(correo, password);
		
	}
	
	/*
	@Override
	public void playSong(int id_cancion, String _correo) throws RemoteException {
		// TODO Auto-generated method stub
		InteractuarService.getInstance().playSong(id_cancion, _correo);
	}
	@Override
	public void stopSong(int id_cancion) throws RemoteException {
		// TODO Auto-generated method stub
		InteractuarService.getInstance().stopSong(id_cancion);
	}
	*/
	
	

}


