package es.deusto.server.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class CancionDTO implements Serializable{
		
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_cancion;
	private String nombre;
	private double precio;
	private ArrayList<ReproduccionDTO> reproducciones = new ArrayList<ReproduccionDTO>();
	private boolean reproduciendo;
	
	
	public boolean isReproduciendo() {
		return reproduciendo;
	}

	public void setReproduciendo(boolean reproduciendo) {
		this.reproduciendo = reproduciendo;
	}

	public CancionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CancionDTO(int id_cancion, String nombre, double precio, boolean _reproduciendo) {
		super();
		this.id_cancion = id_cancion;
		this.nombre = nombre;
		this.precio = precio;
		this.reproduciendo=_reproduciendo;
		
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public ArrayList<ReproduccionDTO> getNombreArray() {
		return reproducciones;
	}
	public void setNombreArray(ArrayList<ReproduccionDTO> nombreArray) {
		this.reproducciones = nombreArray;
	}
	
	


}
