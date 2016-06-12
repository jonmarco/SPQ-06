package es.deusto.server.dto;

import java.util.ArrayList;

import es.deusto.server.data.Reproduccion;

public class UsuarioDTO {

	private String correo;
	private String password;
	private ArrayList<Reproduccion> lreproducciones;
	
	
	
	public ArrayList<Reproduccion> getLreproducciones() {
		return lreproducciones;
	}
	public void setLreproducciones(ArrayList<Reproduccion> lreproducciones) {
		this.lreproducciones = lreproducciones;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getcorreo() {
		return correo;
	}
	public void setcorreo(String correo) {
		this.correo = correo;
	}
	
	
	public UsuarioDTO(String correo, String _contrasenia, ArrayList<Reproduccion> _lreproducciones) {
		super();
		this.correo = correo;
		this.password = _contrasenia;
		this.lreproducciones = _lreproducciones;
		
	}
	
	
}
