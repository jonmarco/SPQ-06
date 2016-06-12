package main.java.es.deusto.ingenieria.spq.client.GUI;


import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


import java.awt.GridLayout;


public class PnlAnuncios extends JPanel{
	
	private String[] rutaimagenes={"acdc.jpg","imaginedragons.jpg",
			"icecube.jpg","jamesblunt.jpg"};
	
	
	
	private PnlAnuncio pnla1;
	private PnlAnuncio pnla2;
	private PnlAnuncio pnla3;
	private PnlAnuncio pnla4;
	
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PnlAnuncios() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setVisible(true);
		
		setLayout(new GridLayout(0, 4, 0, 0));
		
		pnla1 = new PnlAnuncio(rutaimagenes[0]);
		pnla2 = new PnlAnuncio(rutaimagenes[1]);
		pnla3 = new PnlAnuncio(rutaimagenes[2]);
		pnla4 = new PnlAnuncio(rutaimagenes[3]);
		
		
		
		// obtencion de las imagenes para los JPanel
		System.out.println("llega");
			
		this.add(pnla1);
		this.add(pnla2);
		this.add(pnla3);
		this.add(pnla4);
	
		
		this.setVisible(true);
		
		setOpaque(false);
		repaint();

	}




}
