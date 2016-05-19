package es.deusto.client.GUI;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;

public class PnlAnuncioModificado extends JPanel {

	
	private ImageIcon ic;
	
	private String nombreimagen;
	

	public String getNombreimagen() {
		return nombreimagen;
	}

	public void setNombreimagen(String nombreimagen) {
		this.nombreimagen = nombreimagen;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	private JLabel anunciomodificado;
	
	public PnlAnuncioModificado() {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setLayout(new BorderLayout(0, 0));

		ic = new ImageIcon(nombreimagen);
		anunciomodificado= new JLabel("", ic, JLabel.CENTER);
		
		
		
		this.add(anunciomodificado, BorderLayout.CENTER);
	}

}
