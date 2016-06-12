package es.deusto.server.assemblers;
import java.util.ArrayList;

import es.deusto.server.data.Cancion;
import es.deusto.server.dto.CancionDTO;

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
 public class CancionAssembler {
	public static CancionAssembler instance;

	public static CancionAssembler getInstance() {
		if (instance == null) {
			instance = new CancionAssembler();
		}
		return instance;
	}

	public CancionDTO getCancionDTO(Cancion cancion) {

		CancionDTO dto = new CancionDTO(cancion.getId_cancion(),cancion.getNombre(),cancion.getPrecio(), cancion.isReproduciendo());
		System.out.println("Assambling....");
		return dto;
	}
	
	public ArrayList<CancionDTO> getListaCanciones (ArrayList<Cancion>canciones){
		ArrayList<CancionDTO> lCanciones = new ArrayList<CancionDTO>();
		for(Cancion c: canciones){
			lCanciones.add(new CancionDTO(c.getId_cancion(),c.getNombre(),c.getPrecio(), c.isReproduciendo()));
		}
		System.out.println("Assambling....");
		
		return lCanciones;
		
	}


	
 //metodo para devolver la lista de canciones falta
}

 
	


