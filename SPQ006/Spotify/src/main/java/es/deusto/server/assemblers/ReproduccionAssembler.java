package es.deusto.server.assemblers;

import java.util.ArrayList;

import es.deusto.server.data.Reproduccion;
import es.deusto.server.dto.ReproduccionDTO;

/**
	 * @author Ander Loizaga
	 *
	 */
public class ReproduccionAssembler {
	
	public static ReproduccionAssembler instance;
	/**
	 * with this method we get a instance of reproduccionAssembler 
	 *@return
	 */
	public static ReproduccionAssembler getInstance() {
		if (instance == null) {
			instance = new ReproduccionAssembler();
		}
		return instance;
	}
	/**
	 * in this method we add the reproduccionDTO in the list of lReproducciones
	 *@param
	 *
	 *
	 */

	public ArrayList<ReproduccionDTO> assemble (ArrayList<Reproduccion> reproducciones){
		ArrayList<ReproduccionDTO> lReproducciones = new ArrayList<ReproduccionDTO>();
		for(Reproduccion r: reproducciones){
			lReproducciones.add(new ReproduccionDTO(r.getFecha(),r.getUsuario(),r.getCancion()));
			
		}
		System.out.println("Assambling.....");
		return lReproducciones;
	}
	/**
	 * getReproduccionDTO returns which "reproduccion" is playing getting the user, date and song.
	 *@return
	 */
	public ReproduccionDTO getReproduccionDTO(Reproduccion r){
		ReproduccionDTO rDTO= new ReproduccionDTO(r.getFecha(),r.getUsuario(),r.getCancion());
			
			return rDTO;
		}
}



