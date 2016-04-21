package main.java.es.deusto.ingenieria.spq.server.dto;

import java.io.Serializable;

public class PagoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int fecha;
	private double importe;
	private String tipo;
	
	public PagoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PagoDTO(int fecha, double importe, String tipo) {
		super();
		this.fecha = fecha;
		this.importe = importe;
		this.tipo = tipo;
	}
	public int getFecha() {
		return fecha;
	}
	public void setFecha(int fecha) {
		this.fecha = fecha;
	}
	public double getImporte() {
		return importe;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
