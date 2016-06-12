package es.deusto.client.GUI;


import java.awt.EventQueue;

import javax.swing.JFrame;


public class prueba extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PnlAnuncios anuncios;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prueba frame = new prueba();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public prueba() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 466);
		
		
		anuncios = new PnlAnuncios();
		this.setContentPane(anuncios);
		this.setVisible(true);
		repaint();
		
	}

	

}
