package es.deusto.server.services;

import java.util.ArrayList;
import java.util.List;

import es.deusto.server.assemblers.CancionAssembler;
import es.deusto.server.dao.DBManager;
import es.deusto.server.data.Cancion;
import es.deusto.server.dto.CancionDTO;

/**
This class gives service to search songs
@author: Inigo Alonso

*/

public class BusquedaService {

	public static BusquedaService instance = null;

	public static BusquedaService getInstance() {
		if (instance == null) {
			instance = new BusquedaService();
		}
		return instance;
	}

	private BusquedaService() {

	}
	
	
	
	
	/**
	With this method, we return the exact song 

	*/
	public CancionDTO buscarCancion(int id_cancion) {
		DBManager.getInstance();
		Cancion cancion = DBManager.getInstance().buscarCancion(id_cancion);
		List<Cancion> cancionList = new ArrayList<Cancion>();
		cancionList.add(cancion);
		return CancionAssembler.getInstance().getCancionDTO(cancion);
		//return (CancionDTO) new CancionAssembler().assemble(cancionList);
	}
	
	
	/**
	With this method, we list all the song with that name

	*/
	public ArrayList<CancionDTO> buscarCanciones(String nombre) {
		//List<CancionDTO> songs = new ArrayList<>();
		DBManager.getInstance();
		ArrayList<Cancion> cancion = DBManager.getInstance().buscarCanciones(nombre);
		return CancionAssembler.getInstance().getListaCanciones(cancion);
		/*
		for(int i=0;i<cancion.size();i++){
			songs.add(new CancionAssembler().getCancionDTO(cancion.get(i)));
		
		}
		*/
		
		
		
	}
}
