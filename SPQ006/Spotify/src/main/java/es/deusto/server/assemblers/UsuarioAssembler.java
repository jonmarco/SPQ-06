package es.deusto.server.assemblers;

import es.deusto.server.data.Usuario;
import es.deusto.server.dto.UsuarioDTO;
/**
	 * @author Ander Loziaga
	 *
	 */
/**
 * A usuarioAssembler classic class.
 *
 */
public class UsuarioAssembler {
	
		public static UsuarioAssembler instance;

		public static UsuarioAssembler getInstance() {
			if (instance == null) {
				instance = new UsuarioAssembler();
			}
			return instance;
		}
		/**
		 * a method tu get the DTO of a user
		 *
		 */
		public UsuarioDTO getUsuarioDTO(Usuario usuario) {
			UsuarioDTO dto = new UsuarioDTO(usuario.getCorreo());
			return dto;
		}
	}



/*
public class LoginAssembler {
	public static LoginAssembler instance;

	public static LoginAssembler getInstance() {
		if (instance == null) {
			instance = new LoginAssembler();
		}
		return instance;
	}

	public UsuarioDTO getUsuarioDTO(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO(usuario.getNick(), usuario.getEmail());
		return dto;
	}
}
*/
