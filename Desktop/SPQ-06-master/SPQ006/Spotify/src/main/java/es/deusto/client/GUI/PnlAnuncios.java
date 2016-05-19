package es.deusto.client.GUI;


import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;


import java.awt.GridLayout;

/**
 * This class makes the PnlAnuncio panel
 * @author: Iñigo Alonso
 * @version: 22/05
 */

public class PnlAnuncios extends JPanel{
	
	/**
	* This array contains the information of the route paths of the songs images
	*/
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
		
		
		
		/**
		* Obtaining the images for the panel
		*/
		System.out.println("llega");
			
		this.add(pnla1);
		this.add(pnla2);
		this.add(pnla3);
		this.add(pnla4);
	
		
	
		setOpaque(false);
		repaint();

	}




}
