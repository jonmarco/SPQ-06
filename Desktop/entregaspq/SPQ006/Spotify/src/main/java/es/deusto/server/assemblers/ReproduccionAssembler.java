package es.deusto.server.assemblers;

import java.util.ArrayList;

import es.deusto.server.data.Reproduccion;
import es.deusto.server.dto.ReproduccionDTO;
public class ReproduccionAssembler {
	
	public static ReproduccionAssembler instance;

	public static ReproduccionAssembler getInstance() {
		if (instance == null) {
			instance = new ReproduccionAssembler();
		}
		return instance;
	}

	public ArrayList<ReproduccionDTO> assemble (ArrayList<Reproduccion> reproducciones){
		ArrayList<ReproduccionDTO> lReproducciones = new ArrayList<ReproduccionDTO>();
		for(Reproduccion r: reproducciones){
			lReproducciones.add(new ReproduccionDTO(r.getFecha(), r.getHora(), r.getUsuario(),r.getCancion()));
			
		}
		System.out.println("Assambling.....");
		return lReproducciones;
	}
	public ReproduccionDTO getReproduccionDTO(Reproduccion r){
		ReproduccionDTO rDTO= new ReproduccionDTO(r.getFecha(), r.getHora(),r.getUsuario(),r.getCancion());
			
			return rDTO;
		}
}



