package es.deusto.server.data;

//import javax.jdo.annotations.PersistenceCapable;

//@PersistenceCapable(detachable = "true")
/**
This class creates song objects
@author: Jon Marco

*/
public class Cancion {

	private int id_cancion;
	private String nombre;
	private int duracion;
	private int fecha_cancion;
	private String letra;
	private double precio;
	
	public Cancion(int id_cancion, String nombre, int duracion, int fecha_cancion, String letra, double precio) {
		super();
		this.id_cancion = id_cancion;
		this.nombre = nombre;
		this.duracion = duracion;
		this.fecha_cancion = fecha_cancion;
		this.letra = letra;
		this.precio = precio;
	}
	
	public int getId_cancion() {
		return id_cancion;
	}
	public void setId_cancion(int id_cancion) {
		this.id_cancion = id_cancion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public int getFecha_cancion() {
		return fecha_cancion;
	}
	public void setFecha_cancion(int fecha_cancion) {
		this.fecha_cancion = fecha_cancion;
	}
	public String getLetra() {
		return letra;
	}
	public void setLetra(String letra) {
		this.letra = letra;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
}
