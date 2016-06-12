package es.deusto.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import es.deusto.server.dto.CancionDTO;
import es.deusto.server.dto.ReproduccionDTO;
import es.deusto.server.dto.UsuarioDTO;

public interface ISpotify extends Remote{

	public boolean login(String Correo, String contrasenia)throws RemoteException;
	
	public boolean registrarUsuario(String correo, String password) throws RemoteException;
	
	public UsuarioDTO sacarUsuario(String correo, String _password)throws RemoteException;
    // buscamos cancion por titulo
    public ArrayList<CancionDTO> buscarCanciones(String titulo) throws RemoteException;
    // listamos todas las canciones
    public CancionDTO buscarCancion(int id_cancion) throws RemoteException;
    //aniade una reproduccion nueva
    public void aniadirReproduccion(int id_cancion, String correo) throws RemoteException;
    //para los pagos y demas
    public ArrayList<ReproduccionDTO> usuarioReproducciones(String id_usuario) throws RemoteException;
   
    //public void playSong(int id_cancion, String _correo)throws RemoteException; //aniade la reproduccion y ejecuta la cancion
    //public void stopSong(int id_cancion)throws RemoteException;
    
}
