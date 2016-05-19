package es.deusto.server.assemblers;

import es.deusto.server.data.Usuario;
import es.deusto.server.dto.UsuarioDTO;
/**
 * the assembler class of the login
 *
 */
public class LoginAssembler {
	public static LoginAssembler instance;

	public static LoginAssembler getInstance() {
		if (instance == null) {
			instance = new LoginAssembler();
		}
		return instance;
	}
	/**
	 * the method to get a UsuarioDTO
	 *
	 */
	public UsuarioDTO getUsuarioDTO(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO(usuario.getCorreo());
		return dto;
	}
}
