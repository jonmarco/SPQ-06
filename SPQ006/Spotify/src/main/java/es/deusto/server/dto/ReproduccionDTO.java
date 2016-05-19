package es.deusto.server.dto;

import java.io.Serializable;

import es.deusto.server.data.Cancion;
import es.deusto.server.data.Usuario;

/**
This class is to move play class  from server to client
@author: Inigo Alonso

*/

public class ReproduccionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int fecha;
	private Usuario usuario;
	private Cancion cancion;
	public ReproduccionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReproduccionDTO(int fecha, Usuario usuario, Cancion cancion) {
		super();
		this.fecha = fecha;
		this.usuario = usuario;
		this.cancion = cancion;
	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Cancion getCancion() {
		return cancion;
	}
	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}

}
