
/*
package main.java.es.deusto.ingenieria.spq.server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Spotify extends UnicastRemoteObject implements ISpotify {
	
	
	private static RemoteFacade instance;
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
	private PagoPaypal pagoPaypal;

	protected Spotify() throws RemoteException {
		super();
	}
	public static RemoteFacade getInstance() {
		if (instance == null) {
			try {
				instance = new RemoteFacade();
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
	
	public void setPagoService(String ip, String puerto, String nombre){
		this.pagoPaypal=new PagoPaypal(ip,puerto,nombre);
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
	

	public boolean login(String nombre_usuario, String contrasenia) throws RemoteException {
		System.out.println(nombre_usuario+" est� tratando de conectar.");
		return this.loginService.login(nombre_usuario,contrasenia);
	}
	@Override
	public boolean pagoPaypal(String nombre, String contrasenia, String[] args) throws RemoteException {
		return this.pagoPaypal.pagoPaypal(nombre, contrasenia);
		
	}
	
	/*
	public boolean pagoBanco(String nombre, String contrasenia) throws RemoteException {
		return PagoBanco.getInstance().pagoBanco(nombre, contrasenia);
		
	}


	

}

*/
