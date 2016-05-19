package es.deusto.server.services;

import java.util.ArrayList;

import es.deusto.server.assemblers.ReproduccionAssembler;
import es.deusto.server.dao.DBManager;
import es.deusto.server.data.Cancion;
import es.deusto.server.data.Reproduccion;
import es.deusto.server.dto.ReproduccionDTO;

/**

@author: Inigo Alonso

*/

public class InteractuarService {

	public static InteractuarService instance = null;

	public static InteractuarService getInstance() {
		if (instance == null) {
			instance = new InteractuarService();
		}
		return instance;
	}
	
	
	
	/**
	With this method, we create a play, and we add it to the user that is going to listen

	*/
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
	
	
	/**
	With this method, we list all the plays of a user 

	*/
	
	public ArrayList<ReproduccionDTO> usuarioReproducciones(String id_usuario){
		DBManager.getInstance();
		ArrayList<Reproduccion> lReproduccionData= new ArrayList<Reproduccion>(); // el que viene de la bd
		lReproduccionData = DBManager.getInstance().usuarioReproducciones(id_usuario);
		
		return ReproduccionAssembler.getInstance().assemble(lReproduccionData);
		//return CancionAssembler.getInstance().getListaCanciones(lReproduccionData);
	
	}


	
}
