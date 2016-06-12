package es.deusto.server.services;

import java.util.ArrayList;

import es.deusto.server.assemblers.ReproduccionAssembler;
import es.deusto.server.dao.DBManager;
import es.deusto.server.data.Cancion;
import es.deusto.server.data.Reproduccion;
import es.deusto.server.dto.ReproduccionDTO;

public class InteractuarService {

	public static InteractuarService instance = null;

	public static InteractuarService getInstance() {
		if (instance == null) {
			instance = new InteractuarService();
		}
		return instance;
	}
	
	public void aniadirReproduccion(String correo, int id_cancion) {
		// mejor llamarla reproducirCancion
		
		// creo una reproduccion
		// busco al usuario 
		// se a aniado
		
		DBManager.getInstance();
		Cancion cancionData = null;
		cancionData = DBManager.getInstance().buscarCancion(id_cancion); // objeto cancion
		if (cancionData.equals(null)) {
			System.out.println("No se encuentra la cancion");
		} else {

			DBManager.getInstance().aniadirReproduccion(id_cancion, correo); 
			Reproduccion rep = new Reproduccion();
			rep.setCancion(cancionData);
			rep.setUsuario(DBManager.getInstance().buscarUsuario(correo));
			
			DBManager.getInstance().aniadirReproduccionAlUsuario(correo, rep);
			
			
		}

	}
	
	public ArrayList<ReproduccionDTO> usuarioReproducciones(String id_usuario){
		DBManager.getInstance();
		ArrayList<Reproduccion> lReproduccionData= new ArrayList<Reproduccion>(); // el que viene de la bd
		lReproduccionData = DBManager.getInstance().usuarioReproducciones(id_usuario);
		
		return ReproduccionAssembler.getInstance().assemble(lReproduccionData);
		//return CancionAssembler.getInstance().getListaCanciones(lReproduccionData);
	
	}
	
	
	/*
	public void playSong(int id_cancion, String _correo)
	{
		DBManager.getInstance();
		
		try{
			
			DBManager.getInstance().playSong(id_cancion, _correo);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void stopSong(int id_cancion)
	{
		DBManager.getInstance();
		
		try{
			DBManager.getInstance().stopSong(id_cancion);
		}catch(Exception e)
		{
			
		}
		
	}*/
	
	
	
	


	
}
