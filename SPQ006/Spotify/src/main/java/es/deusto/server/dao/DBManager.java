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
import es.deusto.server.data.Hora;
import es.deusto.server.data.Reproduccion;
import es.deusto.server.data.Usuario;
import es.deusto.server.dto.CancionDTO;
import es.deusto.server.dto.UsuarioDTO;

/**
 * Here is the class of the DBManager
 *
 */


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
	/**
	 * The basic class of the connection with de BD
	 *
	 */
	public static void connect() {
		if(pmf==null)
		
			pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		if(pm == null || pm.isClosed())
			pm = pmf.getPersistenceManager();
	}
	
	private DBManager(){

		/*
		 * 
		 private String titulo;
		 private String duracion;
		 private String album;
		 private String artista;
		 * 
		 */
		/**
		 * The initialitations of the cancion objects
		 *
		 */
		

		Cancion cancion1 = new Cancion(1,"No Woman No Cry",4,12091993,"NoWomanNoCry....",20);
		Cancion cancion2 = new Cancion(2,"Locked Away",5,12092015,"LockedAway....",20);
		Cancion cancion3 = new Cancion(3,"Nota de amor",4,12072015,"Notadeamor....",20);
		Cancion cancion4 = new Cancion(4,"Bitch Better Have My Money",4,22092015,"BitchBetterHaveMyMoney....",20);
		Cancion cancion5 = new Cancion(5,"Tip Toe",4,12101993,"Tip Toe....",20);
		Cancion cancion6 = new Cancion(6,"Demons",5,12112015,"Demons....",20);
		Cancion cancion7 = new Cancion(7,"On Top of the World",4,12072015,"On Top of The world....",20);
		Cancion cancion8 = new Cancion(8,"Shots",4,22112015,"Shots....",20);
		Cancion cancion9 = new Cancion(9,"Shots",4, 23122015,"Shots in Pub",20);
	
		/*
		private int id_usuario;
		private String pass;
		private String nombre;
		private int fecha_nacimiento;
		private ArrayList<Reproduccion> nombreArray = new ArrayList<Reproduccion>();
		private ArrayList<Integer>cancionesCompradas = new ArrayList<Integer>();
		private Boolean Reproduciendo= false;
		*/
	
		/**
		 * here we create new users
		 *
		 */
		Usuario jon = new Usuario("jon.marco@opendeusto.es", "1234", null);
		Usuario ander = new Usuario("ander.loizaga@opendeusto.es", "1234", null);
		Usuario david = new Usuario("david.baz@opendeusto.es", "1234", null);
		Usuario inigo = new Usuario("inigo.alonsofdez@opendeusto.es", "1234", null);
		
		
		
		DBManager.connect();
		/**
		 * Transaction to group DB operations
		 *
		 */
				 
				Transaction tx = pm.currentTransaction();
				try {
					System.out.println("- Cargar DB Cancion y Usuario");
					// Get the Persistence Manager
					pm = pmf.getPersistenceManager();
					// Obtain the current transaction
					tx = pm.currentTransaction();
					/**
					 * start the transaction
					 *
					 */
					tx.begin();

					
					/**
					 * load the users
					 *
					 */
					pm.makePersistent(jon);
					pm.makePersistent(ander);
					pm.makePersistent(david);
					pm.makePersistent(inigo);
					
					/**
					 * load the songs
					 *
					 */
					
					pm.makePersistent(cancion1);
					pm.makePersistent(cancion2);
					pm.makePersistent(cancion3);
					pm.makePersistent(cancion4);
					pm.makePersistent(cancion5);
					pm.makePersistent(cancion6);
					pm.makePersistent(cancion7);
					pm.makePersistent(cancion8);
					pm.makePersistent(cancion9);
					
					/**
					 * the end of transaction
					 *
					 */
					tx.commit();
					
					
					
	
					@SuppressWarnings("unused")
					CancionDTO c = CancionAssembler.getInstance().getCancionDTO(
							cancion1);
				
							
					
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
	

	/**
	 * the basic method to log a user
	 * @param
	 *
	 */
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
	
	/**
	 *the method of buscar usuario which finds a user with his email
	 *@param
	 *
	 *
	 */
	
	
	public Usuario buscarUsuario(String correo){
		DBManager.connect();
		Transaction tx = pm.currentTransaction();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			System.out.println("...Buscando al usuario... ");
			tx.begin();			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			for (Usuario usuario : extent) {
				if(usuario.getCorreo().equals(correo))
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
	    				
		return usuarios.get(0);
	}
		
	/**
	 *the method of buscar usuario which finds a users string with his emails
	 *@param
	 *
	 *
	 */
	
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
	/**
	 *the method of buscar cancion which finds a song with the id of the song
	 *@param
	 *
	 *
	 */
	
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
	/**
	 *the method of buscar canciones which finds a song with the name
	 *@param
	 *
	 *
	 */
	
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
	/**
	 *the method of obtener hora which gets the hour
	 *
	 *
	 *
	 */
	
	public  Hora obtenerHora(){
	    Calendar fecha = new GregorianCalendar();
	    int anio = fecha.get(Calendar.YEAR);
	    int mes = fecha.get(Calendar.MONTH);
	    int dia = fecha.get(Calendar.DAY_OF_MONTH);
	    int hora = fecha.get(Calendar.HOUR_OF_DAY);
	    int minuto = fecha.get(Calendar.MINUTE);
	    int segundo = fecha.get(Calendar.SECOND);
	    Hora h= new Hora(anio,mes,dia,hora,minuto,segundo);
	    return h;
		
	}
	/**
	 *the method of aniadir reproduccion which you can add a new reprodution 
	 *@param
	 *
	 *
	 */
	
	
	public void aniadirReproduccion(int id_cancion, String correo){
		Reproduccion reproduccionQ= new Reproduccion();
		Usuario u=  buscarUsuario(correo);
		Cancion c=  buscarCancion(id_cancion);
		Hora h= new Hora();
		int hora;
		h=obtenerHora();
		hora=h.getDia();
		reproduccionQ.setCancion(c);
		reproduccionQ.setUsuario(u);
		reproduccionQ.setFecha(hora);
		
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
	public void playSong(int id_usuario, int id_cancion){
		//Accede a la bd y lo pone a true el campo reproduccion y realiza las distintas llamadas
		
		//aniade la reproduccion
		aniadirReproduccion(id_cancion,id_usuario);
		//pone el campo en la bd a true
		
		PersistenceManagerFactory pmf = JDOHelper
				.getPersistenceManagerFactory("tralala");
		// Persistence Manager
	    PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("...Reproduciendo cancion... ");
			tx.begin();			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			for (Usuario usuario : extent) {
				if(usuario.getId_usuario()==id_usuario)
				{
					usuario.setReproduciendo(true);
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

	public void stopSong(int id_usuario, int id_cancion){
		//Accede a la bd y lo pone a false el campo reproduccion y realiza las distintas llamadas
		
		PersistenceManagerFactory pmf = JDOHelper
				.getPersistenceManagerFactory("tralala");
		// Persistence Manager
	    PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		try {
			System.out.println("...Reproduciendo cancion... ");
			tx.begin();			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);
			for (Usuario usuario : extent) {
				if(usuario.getId_usuario()==id_usuario)
				{
					usuario.setReproduciendo(false);
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
	*/
	/**
	 *with this method we can know the reproductions of an user
	 *@param
	 *
	 *
	 */
	
	
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


