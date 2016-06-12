package es.deusto.server.dto;

/**
This class is to move user class data from server to client
@author: Inigo Alonso

*/

public class UsuarioDTO {

	private String correo;

	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UsuarioDTO(String correo) {
		super();
		this.correo = correo;
		
	}
	public String getcorreo() {
		return correo;
	}
	public void setcorreo(String correo) {
		this.correo = correo;
	}
	
	
}
