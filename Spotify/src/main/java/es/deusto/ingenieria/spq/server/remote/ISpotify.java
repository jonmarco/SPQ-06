package main.java.es.deusto.ingenieria.spq.server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import main.java.es.deusto.ingenieria.spq.server.dto.CancionDTO;
import main.java.es.deusto.ingenieria.spq.server.dto.ReproduccionDTO;

public interface ISpotify extends Remote{

	public boolean login(String Correo, String contrasenia)throws RemoteException;
    // buscamos cancion por titulo
    public ArrayList<CancionDTO> buscarCanciones(String titulo) throws RemoteException;
    // listamos todas las canciones
    public CancionDTO buscarCancion(int id_cancion) throws RemoteException;
    //aniade una reproduccion nueva
    public void aniadirReproduccion(int id_cancion, String correo) throws RemoteException;
    //para los pagos y demas
    public ArrayList<ReproduccionDTO> usuarioReproducciones(String id_usuario) throws RemoteException;
   
   // public void playSong(int id_usuario, int id_cancion)throws RemoteException; //aniade la reproduccion y ejecuta la cancion
   // public void stopSong(int id_usuario, int id_cancion)throws RemoteException;
    
    
    public boolean pagoPaypal(String nombre, String contrasenia,String[] args)throws RemoteException;
   // public boolean pagoBanco(String nombre, String contrasenia)throws RemoteException;
}
