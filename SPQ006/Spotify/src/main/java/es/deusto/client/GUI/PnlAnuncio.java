package es.deusto.client.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PnlAnuncio extends JPanel {

	
	private ImageIcon imgic;
	private String nombre="";
	

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
	public PnlAnuncio(String _nombre) {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(null);
		
		this.nombre = _nombre;

		System.out.println(nombre);
	}
	
	
	@Override
	public void paint(Graphics g) {
		
		
		java.net.URL imgURL = getClass().getResource(nombre);
	    if (imgURL != null) {
	    	Graphics2D gr=(Graphics2D)g;
			Dimension t = getSize();
	    	imgic= new ImageIcon(imgURL);
			gr.drawImage(imgic.getImage(), 0, 0, t.width, t.height, null);
	        
	    } else {
	        System.err.println("Couldn't find file: " + nombre);
	        
	    }
	    
		setOpaque(false);
		super.paint(g);
		
	}


}
