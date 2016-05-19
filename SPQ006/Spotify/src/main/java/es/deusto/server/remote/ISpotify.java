package es.deusto.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import es.deusto.server.dto.CancionDTO;
import es.deusto.server.dto.ReproduccionDTO;

/**
This class is the Interface of Spotify
@author: Jon Marco

*/

public interface ISpotify extends Remote{

	public boolean login(String Correo, String contrasenia)throws RemoteException;
    
	
	
	/**
	header of searching a song

	*/
    public ArrayList<CancionDTO> buscarCanciones(String titulo) throws RemoteException;
   
	
	/**
	header of listing songs

	*/
    public CancionDTO buscarCancion(int id_cancion) throws RemoteException;
   
	
	/**
	header of adding a play

	*/
    public void aniadirReproduccion(int id_cancion, String correo) throws RemoteException;
    //para los pagos y demas
	
	/**
	header of the pays

	*/
    public ArrayList<ReproduccionDTO> usuarioReproducciones(String id_usuario) throws RemoteException;
   
   // public void playSong(int id_usuario, int id_cancion)throws RemoteException; //aniade la reproduccion y ejecuta la cancion
   // public void stopSong(int id_usuario, int id_cancion)throws RemoteException;
    
  /*
    public boolean pagoPaypal(String nombre, String contrasenia,String[] args)throws RemoteException;
   // public boolean pagoBanco(String nombre, String contrasenia)throws RemoteException;
   */
}
