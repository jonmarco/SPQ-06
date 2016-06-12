package es.deusto.server.data;

import java.util.ArrayList;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Usuario {

	//aqui solo el mail y la lista de reproducciones
	@PrimaryKey
	private String correo;
	private String contrasenia;
	private ArrayList<Reproduccion> lReproducciones = new ArrayList<Reproduccion>();
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Usuario(String correo, String contrasenia, ArrayList<Reproduccion> lReproducciones) {
		super();
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.lReproducciones = lReproducciones;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getcontrasenia() {
		return contrasenia;
	}
	public void setcontrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public ArrayList<Reproduccion> getlReproducciones() {
		return lReproducciones;
	}
	public void setlReproducciones(ArrayList<Reproduccion> lReproducciones) {
		this.lReproducciones = lReproducciones;
	}
	
	
	/*
	private int id_usuario;
	private String pass;
	private String nombre;
	private int fecha_nacimiento;
	private ArrayList<Reproduccion> lReproducciones = new ArrayList<Reproduccion>();
	private Boolean Reproduciendo= false;
	public Usuario() {
		super();
	}
	public Usuario(int id_usuario, String pass, String nombre, int fecha_nacimiento,
		 Boolean reproduciendo) {
		super();
		this.id_usuario = id_usuario;
		this.pass = pass;
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		Reproduciendo = reproduciendo;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(int fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public ArrayList<Reproduccion> getNombreArray() {
		return lReproducciones;
	}
	public void setNombreArray(ArrayList<Reproduccion> nombreArray) {
		this.lReproducciones = nombreArray;
	}
	
	public Boolean getReproduciendo() {
		return Reproduciendo;
	}
	public void setReproduciendo(Boolean reproduciendo) {
		Reproduciendo = reproduciendo;
	}
	*/
	

}
