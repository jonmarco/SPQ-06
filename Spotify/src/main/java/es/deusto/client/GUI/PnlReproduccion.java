package es.deusto.client.GUI;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JLabel;


import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PnlReproduccion extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PnlReproduccion(PnlScroll pnl) {
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setLayout(null);
		
		PnlcancionSeleccionada pnlseleccion = new PnlcancionSeleccionada("cancion.jpg");
		pnlseleccion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlseleccion.setBounds(12, 13, 197, 176);
		add(pnlseleccion);
		
		JButton btn_reproducir = new JButton("Reproducir");
		btn_reproducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btn_reproducir.setBounds(266, 134, 97, 25);
		add(btn_reproducir);
		
		JButton btn_parar = new JButton("Parar");
		btn_parar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
			}
		});
		btn_parar.setBounds(381, 134, 97, 25);
		add(btn_parar);
		
		JLabel lbl_reproduciendo = new JLabel("Reproduciendo:");
		lbl_reproduciendo.setBounds(266, 53, 97, 16);
		add(lbl_reproduciendo);
		
		JSlider sld_volumen = new JSlider();
		sld_volumen.setBounds(503, 134, 134, 23);
		add(sld_volumen);
		
		JLabel lblPago = new JLabel("PAGO");
		lblPago.setBounds(711, 13, 56, 16);
		add(lblPago);
		
		pnl.setBounds(266,82,408,35);
		add(pnl);
		
		repaint();
		
		

	}
}
