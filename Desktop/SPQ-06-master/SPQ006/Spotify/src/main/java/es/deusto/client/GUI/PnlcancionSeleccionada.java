package es.deusto.client.GUI;


import java.awt.Graphics;
import java.awt.Graphics2D;


import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * This class makes the a panel which is going to be shown when we select a song
 * @author: David Baz
 * @version: 22/05
 */

public class PnlcancionSeleccionada extends JPanel {

	
	
	private ImageIcon ic;
	private String nombre;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PnlcancionSeleccionada(String _nombre) {

		this.nombre=_nombre;
	
	}
	
	@Override
	public void paint(Graphics g) {
		
		
		java.net.URL imgURL = getClass().getResource(nombre);
	    if (imgURL != null) {
	    	Graphics2D gr=(Graphics2D)g;
			ic= new ImageIcon(imgURL);
			System.out.println(nombre);
			gr.drawImage(ic.getImage(), 0,0, 197, 176, null);
	        
	    } else {
	        System.err.println("Couldn't find file: " + nombre);
	        
	    }
	    
		setOpaque(false);
		super.paint(g);
		
	}


}
