package es.deusto.client.GUI;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

/**
 * This class makes the PnlSeleccion JPanel
 * @author: Iñigo Alonso
 * @version: 22/05
 */


public class PnlSeleccion extends JPanel implements MouseListener{

	private JLabel lbl_explorar;
	private JLabel lbl_reproducciones;
	private int seleccion;

	
	public int getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(int seleccion) {
		this.seleccion = seleccion;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PnlSeleccion() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		
		setBounds(15,92,153,455);
		//v = new PnlVisualizar();
		
		JLabel lbl_principal = new JLabel("PRINCIPAL");
		lbl_principal.setBounds(12, 26, 78, 16);
		add(lbl_principal);
		
		lbl_explorar = new JLabel("Explorar");
		
		
		lbl_explorar.setBounds(12, 51, 129, 27);
		add(lbl_explorar);
		lbl_explorar.addMouseListener(this);
		
		JLabel lbl_playlists = new JLabel("PLAYLISTS");
		lbl_playlists.setBounds(12, 91, 78, 16);
		add(lbl_playlists);
		
		JLabel lbl_tumusica = new JLabel("TU MUSICA");
		lbl_tumusica.setBounds(12, 73, 78, 16);
		
		lbl_reproducciones = new JLabel("Reproducciones");
		lbl_reproducciones.setBounds(12, 115, 129, 27);
		add(lbl_reproducciones);
		lbl_reproducciones.addMouseListener(this);

	}

	
	/**
 * This method will be executed when someone cliks the mouse
 * @param: Receives the mouse event like parameter
 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println(e.getID());
		if(e.getComponent().equals(lbl_explorar))
		{
			// todas las canciones
			this.seleccion=0;
			//v.setSeleccion(1);
		}
		else if(e.getComponent().equals(lbl_reproducciones))
		{
			// todas las repros
			this.seleccion=1;
			//v.setSeleccion(2);
			
		}
	}
/**
 * This method will be executed when someone enters in lbl_explorar
 * @param: Receives the mouse event like parameter
 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getComponent().equals(lbl_explorar))
		{		System.out.println(e.getSource());
			lbl_explorar.setForeground(Color.YELLOW);
			lbl_explorar.setBackground(Color.green);
			
		}
		else if(e.getComponent().equals(lbl_reproducciones))
		{
			lbl_reproducciones.setForeground(Color.YELLOW);
			lbl_reproducciones.setBackground(Color.green);
		}
		
	} 
	
	/**
 * This method will be executed when someone exites from lbl_explorar
 * @param: Receives the mouse event like parameter
 */

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		if(e.getComponent().equals(lbl_explorar))
		{
			lbl_explorar.setForeground(Color.black);
			lbl_explorar.setBackground(Color.green);
		}
		else if(e.getComponent().equals(lbl_reproducciones))
		{
			lbl_reproducciones.setForeground(Color.black);
			lbl_explorar.setBackground(Color.green);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
