package es.deusto.server.dto;

import java.io.Serializable;

import es.deusto.server.data.Cancion;
import es.deusto.server.data.Usuario;

public class ReproduccionDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fecha;
	private String hora;
	private Usuario usuario;
	private Cancion cancion;
	public ReproduccionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReproduccionDTO(String fecha, String hora, Usuario usuario, Cancion cancion) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.usuario = usuario;
		this.cancion = cancion;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
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
