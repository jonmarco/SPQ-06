package es.deusto.server.data;

/**
This class creates pay objects
@author: Jon Marco

*/
public class Pago {

	private int id_pago;
	private int fecha;
	private int estado;
	private String tipo;
	private double importe;
	
	public Pago(int id_pago, int fecha, int estado, String tipo, double importe) {
		super();
		this.id_pago = id_pago;
		this.fecha = fecha;
		this.estado = estado;
		this.tipo = tipo;
		this.importe = importe;
	}

	public Pago() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_pago() {
		return id_pago;
	}

	public void setId_pago(int id_pago) {
		this.id_pago = id_pago;
	}

	public int getFecha() {
		return fecha;
	}

	public void setFecha(int fecha) {
		this.fecha = fecha;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
}
