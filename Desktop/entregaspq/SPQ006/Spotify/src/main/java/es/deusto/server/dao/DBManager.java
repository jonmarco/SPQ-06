package es.deusto.server.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import es.deusto.server.assemblers.CancionAssembler;
import es.deusto.server.assemblers.LoginAssembler;
import es.deusto.server.data.Cancion;
import es.deusto.server.data.Fecha;
import es.deusto.server.data.Hora;
import es.deusto.server.data.Reproduccion;
import es.deusto.server.data.Usuario;
import es.deusto.server.dto.CancionDTO;
import es.deusto.server.dto.UsuarioDTO;




public class DBManager {

	private static DBManager instance = null;
	private static PersistenceManagerFactory pmf = null;
	private static PersistenceManager pm = null;

	public static DBManager getInstance() {
		if(instance == null) {
			instance=new DBManager();
		}
		return instance;
	}
	
	public static void connect() {
		if(pmf==null)
			pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		
		if(pm == null || pm.isClosed())
			pm = pmf.getPersistenceManager();
	}
	
	/**
	 * 
	 */
	private DBManager(){

		/*
		 * 
		 private String titulo;
		 private String duracion;
		 private String album;
		 private String artista;
		 * 
		 */
		

		Cancion cancion1 = new Cancion(1,"No Woman No Cry",4,12091993,"NoWomanNoCry....",20, false);
		Cancion cancion2 = new Cancion(2,"Locked Away",5,12092015,"LockedAway....",20, false);
		Cancion cancion3 = new Cancion(3,"Nota de amor",4,12072015,"Notadeamor....",20, false);
		Cancion cancion4 = new Cancion(4,"Bitch Better Have My Money",4,22092015,"BitchBetterHaveMyMoney....",20, false);
		Cancion cancion5 = new Cancion(5,"Tip Toe",4,12101993,"Tip Toe....",20, false);
		Cancion cancion6 = new Cancion(6,"Demons",5,12112015,"Demons....",20, false);
		Cancion cancion7 = new Cancion(7,"On Top of the World",4,12072015,"On Top of The world....",20, false);
		Cancion cancion8 = new Cancion(8,"Shots",4,22112015,"Shots....",20, false);
		Cancion cancion9 = new Cancion(9,"Shots",4, 23122015,"Shots in Pub",20, false);
	
		/*
		private int id_usuario;
		private String pass;
		private String nombre;
		private int fecha_nacimiento;
		private ArrayList<Reproduccion> nombreArray = new ArrayList<Reproduccion>();
		private ArrayList<Integer>cancionesCompradas = new ArrayList<Integer>();
		private Boolean Reproduciendo= false;
		*/
	
		
		Usuario jon = new Usuario("jon.marco@opendeusto.es", "1234", null);
		Usuario ander = new Usuario("ander.loizaga@opendeusto.es", "1234", null);
		Usuario david = new Usuario("david.baz@opendeusto.es", "1234", null);
		Usuario inigo = new Usuario("inigo.alonsofdez@opendeusto.es", "1234", null);
		
		
		
		DBManager.connect();
		
		
		
				// Transaction to group DB operations
				Transaction tx = pm.currentTransaction();
				try {
					System.out.println("- Cargar DB Cancion y Usuario");
					// Get the Persistence Manager
					pm = pmf.getPersistenceManager();
					// Obtain the current transaction
					tx = pm.currentTransaction();
					// Start the transaction
					tx.begin();

					
					// load de users
					pm.makePersistent(jon);
					pm.makePersistent(ander);
					pm.makePersistent(david);
					pm.makePersistent(inigo);
					
					// load de songs
					
					pm.makePersistent(cancion1);
					pm.makePersistent(cancion2);
					pm.makePersistent(cancion3);
					pm.makePersistent(cancion4);
					pm.makePersistent(cancion5);
					pm.makePersistent(cancion6);
					pm.makePersistent(cancion7);
					pm.makePersistent(cancion8);
					pm.makePersistent(cancion9);
					

					System.out.println("ENTRAMOS EN EL PERSISTENT!!!!");
					tx.commit();
					// End the transaction
					
					
	
				/*	@SuppressWarnings("unused")
					CancionDTO c = CancionAssembler.getInstance().getCancionDTO(
							cancion1);*/
				
							
					
					//UsuarioDTO u = LoginAssembler.getInstance().getUsuarioDTO(jon);
					//insertarReproduccion(c.getTitulo(), u.getNick());
					
					

					
				} finally {
					if (tx != null && tx.isActive()) {
						tx.rollback();
					}

					if (pm != null && !pm.isClosed()) {
						pm.close();
					}
				}	
	}
	

	
	public Usuario loginUsuario(String correo, String password){
		DBManager.connect();
		Transaction tx = pm.currentTransaction();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			System.out.println("...Buscando al usuario... ");
			tx.begin();			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			for (Usuario usuario : extent) {
				if(usuario.getCorreo().equals(correo)&& usuario.getcontrasenia().equals(password))
				{
					usuarios.add(usuario);
				}	
			}
			tx.commit();
		} catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
		if(usuarios.size()==0){
			return null; // el usuario no existe
			
		}
	    				
		return usuarios.get(0); //el usuario existe
		
		
	}
	
	
	public boolean registrarUsuario(String _email, String _password)
	{
		
		boolean existe=false;
		Usuario usuariocarga=null;
		
		DBManager.connect();
		Transaction tx = pm.currentTransaction();
		try
		{
			System.out.println("...Registrando al usuario... ");
			tx.begin();		
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			for(Usuario user: extent)
			{
				if(user.getCorreo().equals(_email) && user.getcontrasenia().equals(_password))
				{
					System.out.println("ENTRAMOS");
					
					existe=true;
				}
				else
				{
					
					existe=false;
				}
								
			}
			
			System.out.println(existe);
			
			if(!existe)
			{
				usuariocarga = new Usuario();
				usuariocarga.setCorreo(_email);
				usuariocarga.setcontrasenia(_password);
				usuariocarga.setlReproducciones(null);
				pm.makePersistent(usuariocarga);
				tx.commit();
				System.out.println("LO CARGAMOS");
				
			}else
			{
				System.out.println("Como ya existe NO lo cargamos");
			}
			
			
			
			
		}catch(Exception ex)
		{
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
			
		}finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }	
		
		
		return existe;
	}
	
	
	
	public Usuario buscarUsuario(String _correo){
		DBManager.connect();
		Transaction tx = pm.currentTransaction();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			System.out.println("...Buscando al usuario... ");
			tx.begin();			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			for (Usuario usuario : extent) {
				if(usuario.getCorreo().equals(_correo))
				{
					usuarios.add(usuario);
				}
				
			}
			tx.commit();
		} catch (Exception ex) {
			System.out.println("ERROR AL DEVOLVER EL USUARIO");
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    		
		System.out.println("TAMAÑO LISTA USUARIOS:" + usuarios.size());
		if(usuarios.size()== 0)
			return null;
		else
			return usuarios.get(0);
		
	}
		
	
	public Usuario buscarUsuarioString(String correo){
		DBManager.connect();
		Transaction tx = pm.currentTransaction();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			System.out.println("...Buscando al usuario... ");
			tx.begin();			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			for (Usuario usuario2 : extent) {
				if(usuario2.getCorreo().equals(correo))
				{
					usuarios.add(usuario2);
				}
				
			}
			tx.commit();
		} catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }
	    				
		return usuarios.get(0);
	}
	
	public Cancion buscarCancion(int id_cancion){
		DBManager.connect();
		Transaction tx = pm.currentTransaction();
		List<Cancion> lcanciones = new ArrayList<Cancion>();
			
		try {
				System.out.println(" ...Buscando la cancion.... ");
				tx.begin();			
				Extent<Cancion> extent = pm.getExtent(Cancion.class, true);
				
				for (Cancion cancion : extent) {
					if(cancion.getId_cancion()== id_cancion)
					{
						lcanciones.add(cancion);
					}
					
				}
				
				tx.commit();			
			} catch (Exception ex) {
		    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		    } finally {
		    	if (tx != null && tx.isActive()) {
		    		tx.rollback();
		    	}

	    		pm.close();    		
		    }
		    				
			return lcanciones.get(0);
	}
	public ArrayList<Cancion> buscarCanciones(String nombre){
		DBManager.connect();
		Transaction tx = pm.currentTransaction();
		ArrayList<Cancion> lCanciones = new ArrayList<>();
			
		try {
				System.out.println("   ...Buscando la cancion... ");
				tx.begin();			
				Extent<Cancion> extent = pm.getExtent(Cancion.class, true);
				
				for (Cancion cancion : extent) {
					if(cancion.getNombre().contains(nombre))
					{
						lCanciones.add(cancion);
					}
					
				}
				
				tx.commit();			
			} catch (Exception ex) {
		    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
		    } finally {
		    	if (tx != null && tx.isActive()) {
		    		tx.rollback();
		    	}

	    		pm.close();    		
		    }
		    				
			return lCanciones;
		}	
	
	public Hora obtenerHora(){
	    Calendar fecha = new GregorianCalendar();
	    int hora = fecha.get(Calendar.HOUR_OF_DAY);
	    int minuto = fecha.get(Calendar.MINUTE);
	    int segundo = fecha.get(Calendar.SECOND);
	    Hora h= new Hora(hora,minuto,segundo);
	    return h;
		
	}
	
	public Fecha obtenerFecha()
	{
		Calendar fecha = new GregorianCalendar();
		int year = fecha.get(Calendar.YEAR);
		int month = fecha.get(Calendar.MONTH);
		int day = fecha.get(Calendar.DAY_OF_MONTH);
		Fecha f = new Fecha(year, month, day);
		
		return f;
	}

	
	public void aniadirReproduccion(int id_cancion, String correo){
		Reproduccion reproduccionQ= new Reproduccion();
		Usuario u=  buscarUsuario(correo);
		Cancion c=  buscarCancion(id_cancion);
		
		String hora="";
		String fecha="";
		
		Hora h= new Hora();
		Fecha f = new Fecha();
		
		h=obtenerHora();
		f = obtenerFecha();
		
		fecha = f.getYear() +"/"+f.getMonth()+"/"+f.getDay();
		hora = h.getHora() +"/"+h.getMinuto()+"/"+ h.getSegundo();
		
		
		
		reproduccionQ.setCancion(c);
		reproduccionQ.setUsuario(u);
		reproduccionQ.setHora(hora);
		reproduccionQ.setFecha(fecha);
		
		DBManager.connect();
				// Transaction to group DB operations
				Transaction tx = pm.currentTransaction();
				
				try {
					System.out.println("Aniadir Reproduccion");
					// Get the Persistence Manager
					pm = pmf.getPersistenceManager();
					// Obtain the current transaction
					tx = pm.currentTransaction();
					// Start the transaction
					tx.begin();

					pm.makePersistent(reproduccionQ);

					tx.commit();
					// End the transaction

				} finally {
					if (tx != null && tx.isActive()) {
						tx.rollback();
					}

					if (pm != null && !pm.isClosed()) {
						pm.close();
					}
				}
		
	}
	
	/*
	public void playSong(int id_cancion, String id_usuario){
		//Accede a la bd y lo pone a true el campo reproduccion y realiza las distintas llamadas
		
		
		
		/*PARA AÑADIR UNA CANCION CLICAMOS SOBRE ELLA, Y AL DARLE A REPRODUCIR BUSCA LA CANCION EN LA BASE DE DATOS
		SACA EL ID Y CON EL ID DEL USARIO QUE YA LO TENEMOS POR QUE LO HEMOS PASADO ASIGNAMOS LA REPRO*/
		//aniade la reproduccion
		//aniadirReproduccion(id_cancion,id_usuario);
		//pone el campo en la bd a true
		
	/*
		PersistenceManagerFactory pmf = JDOHelper
				.getPersistenceManagerFactory("tralala");
		// Persistence Manager
	    PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("...Reproduciendo cancion... ");
			tx.begin();			
			Extent<Cancion> extent = pm.getExtent(Cancion.class, true);
			for (Cancion cancion : extent) {
				if(cancion.getId_cancion()== id_cancion)
				{
					cancion.setReproduciendo(true);
				}
				
			}
			tx.commit();
		} catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }  				
	
	}

	public void stopSong(int id_cancion){
		//Accede a la bd y lo pone a false el campo reproduccion y realiza las distintas llamadas
		
		PersistenceManagerFactory pmf = JDOHelper
				.getPersistenceManagerFactory("tralala");
		// Persistence Manager
	    PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("...Paramos la cancion... ");
			tx.begin();			
			Extent<Cancion> extent = pm.getExtent(Cancion.class, true);
			for (Cancion cancion : extent) {
				if(cancion.getId_cancion()==id_cancion)
				{
					cancion.setReproduciendo(false);
				}
				
			}
			tx.commit();
		} catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }  				
	
	}	
	
	
	
	/*metodo a implementar*/
	
	public ArrayList<Reproduccion> usuarioReproducciones(String correo){
		ArrayList<Reproduccion>lReproduccion= new ArrayList<Reproduccion>();
		DBManager.connect();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("...Obtener reproducciones... ");
			tx.begin();
			Extent<Reproduccion> extent = pm.getExtent(Reproduccion.class, true);
			for (Reproduccion rep : extent) {
				if(rep.getUsuario().getCorreo().equals(correo)){
					lReproduccion.add(rep);
				}	
			}
		}catch(Exception ex){	
			System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }  				
		return lReproduccion;
		
		
	}
	
	/*metodo a implementar*/
	public void aniadirReproduccionAlUsuario(String correo, Reproduccion r){
	
		ArrayList<Reproduccion> lReproducciones = new ArrayList<Reproduccion>();
		
		DBManager.connect();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("...Reproduciendo cancion... ");
			tx.begin();			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			for (Usuario usuario : extent) {
				if(usuario.getCorreo().equals(correo))
				{
					lReproducciones=usuario.getlReproducciones();
					lReproducciones.add(r);
				}
				
			}
			tx.commit();
		} catch (Exception ex) {
	    	System.out.println("   $ Error retreiving an extent: " + ex.getMessage());
	    } finally {
	    	if (tx != null && tx.isActive()) {
	    		tx.rollback();
	    	}

    		pm.close();    		
	    }  				
	
		
	}
	
	
	public static void main(String[] args) {
		DBManager.getInstance();
	}
}


