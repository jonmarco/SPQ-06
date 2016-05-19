package es.deusto.server.data;

//import javax.jdo.annotations.PersistenceCapable;

//@PersistenceCapable(detachable = "true")
public class Reproduccion {
	
	private int fecha;
	private String hora;
	private Usuario usuario;
	private Cancion cancion;
	
	public Reproduccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Reproduccion(int fecha, String hora, Usuario usuario, Cancion cancion) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.usuario = usuario;
		this.cancion = cancion;
	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
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

