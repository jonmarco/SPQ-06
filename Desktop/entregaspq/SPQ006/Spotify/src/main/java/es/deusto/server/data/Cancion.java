package es.deusto.server.data;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Cancion {

	@PrimaryKey
	private int id_cancion;
	private String nombre;
	private int duracion;
	private int fecha_cancion;
	private String letra;
	private double precio;
	private boolean reproduciendo;
	
	public boolean isReproduciendo() {
		return reproduciendo;
	}

	public void setReproduciendo(boolean reproduciendo) {
		this.reproduciendo = reproduciendo;
	}

	public Cancion(int id_cancion, String nombre, int duracion, int fecha_cancion,
			String letra, double precio, boolean _reproduciendo) {
		super();
		this.id_cancion = id_cancion;
		this.nombre = nombre;
		this.duracion = duracion;
		this.fecha_cancion = fecha_cancion;
		this.letra = letra;
		this.precio = precio;
		this.reproduciendo = _reproduciendo;
		
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
