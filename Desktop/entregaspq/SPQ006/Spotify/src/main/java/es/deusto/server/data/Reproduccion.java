package es.deusto.server.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reproduccion {
	
	
	/*clase generada por la relacion entre las otras 2*/
	@PrimaryKey
	private Usuario usuario;
	@PrimaryKey
	private Cancion cancion;
	private String fecha;
	private String hora;
	
	
	public Reproduccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reproduccion(String _fecha, String _hora, Usuario _usuario, Cancion _cancion) {
		super();
		
		this.fecha = _fecha;
		this.hora = _hora;
		this.usuario = _usuario;
		this.cancion = _cancion;
	}
	
	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String _fecha) {
		this.fecha = _fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
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

