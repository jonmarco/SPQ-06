package es.deusto.server.assemblers;
import java.util.ArrayList;

import es.deusto.server.data.Cancion;
import es.deusto.server.dto.CancionDTO;
/**
	 * @author Ander Loizaga
	 *
	 */
/*
		public class CancionAssembler {
		
			// dos metodos uno para la lista y otro para una cancion solo
			public List<CancionDTO> assemble (List<Cancion>canciones){
				List<CancionDTO> lCanciones = new ArrayList<CancionDTO>();
				for(Cancion c: canciones){
					lCanciones.add(new CancionDTO(c.getId_cancion(),c.getNombre(),c.getPrecio()));
				}
				System.out.println("Assambling....");
				
				return lCanciones;
				
			}
			public CancionDTO getCancionDTO(Cancion c){
			CancionDTO cDTO= new CancionDTO(c.getId_cancion(),c.getNombre(),c.getPrecio());
				
				return cDTO;
			}
			
	}
		*/
// dos metodos uno para la lista y otro para una cancion solo	
/**
 * cancion assembler class
 *
 */
 public class CancionAssembler {
	public static CancionAssembler instance;
	/**
	 * get the instance of cancionAssembler
	 *
	 */
	public static CancionAssembler getInstance() {
		if (instance == null) {
			instance = new CancionAssembler();
		}
		return instance;
	}
	/**
	 * get cancionDTO class
	 *
	 */
	public CancionDTO getCancionDTO(Cancion cancion) {

		CancionDTO dto = new CancionDTO(cancion.getId_cancion(),cancion.getNombre(),cancion.getPrecio());
		System.out.println("Assambling....");
		return dto;
	}
	/**
	 * the method where we get all the song of the list
	 *
	 */
	
	public ArrayList<CancionDTO> getListaCanciones (ArrayList<Cancion>canciones){
		ArrayList<CancionDTO> lCanciones = new ArrayList<CancionDTO>();
		for(Cancion c: canciones){
			lCanciones.add(new CancionDTO(c.getId_cancion(),c.getNombre(),c.getPrecio()));
		}
		System.out.println("Assambling....");
		
		return lCanciones;
		
	}


	
 //metodo para devolver la lista de canciones falta
}

 
	


