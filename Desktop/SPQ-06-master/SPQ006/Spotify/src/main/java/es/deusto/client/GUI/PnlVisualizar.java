package es.deusto.client.GUI;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import es.deusto.server.dto.CancionDTO;

/**
 * This class makes the PnlVisualizar JPanel
 * @author: Iñigo Alonso
 * @version: 22/05
 */

public class PnlVisualizar extends JPanel {

	private PnlReproduccion pnlrepro;
	private PnlCanciones pnlcanciones;
	private PnlListareproduccion pnlreproducciones;
	private PnlAnuncios pnlanuncios;
	private PnlScroll pnlscroll;
	
	public ArrayList<CancionDTO> lista = new ArrayList<CancionDTO>();;
	
	public ArrayList<CancionDTO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<CancionDTO> lista) {
		this.lista = lista;
	}

	private int seleccion=0;
	
	
	public int getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(int seleccion) {
		this.seleccion = seleccion;
		
		/*this.remove(pnlanuncios);
		this.remove(pnlrepro);
		this.remove(pnlcanciones);
		this.remove(pnlreproducciones);
		
		// dependiendo de la seleccion metemos un panel en el sur u otro.
		switch(seleccion)
		{
		case 0:
			pnlcanciones = new PnlCanciones(pnlrepro);
			this.add(pnlcanciones);
			break;
		case 1:
			pnlreproducciones=new PnlListareproduccion(pnlscroll);
			this.add(pnlreproducciones);
			break;
		default:
			pnlanuncios = new PnlAnuncios();
			this.add(pnlanuncios);
			break;
		
		}*/
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PnlVisualizar()
	{	
		this.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		this.setLayout(new GridLayout(2, 1, 0, 0));
	
		
		pnlscroll= new PnlScroll();
		pnlrepro = new PnlReproduccion(pnlscroll);
		
		
		System.out.println("pnl");
		System.out.println("Entra en Pnlvisualizar");
		System.out.println(lista.size());

		
		
		// dependiendo de la seleccion metemos un panel en el sur u otro.
		
		
		switch(seleccion)
		{
		case 0:
			pnlcanciones = new PnlCanciones(pnlrepro);
			pnlcanciones.cargarListaCanciones(lista);
			this.add(pnlrepro);
			this.add(pnlcanciones);
			repaint();
			break;
		case 1:
			pnlreproducciones=new PnlListareproduccion(pnlscroll);
			this.add(pnlrepro);
			this.add(pnlreproducciones);
			break;
		default:
			pnlanuncios = new PnlAnuncios();
			this.add(pnlrepro);
			this.add(pnlanuncios);
			break;
		
		}

	}
	/**
 * This class put the songs into a list
 * @param: receives the arraylist of songs like parameter
 */
	public void cargarLista(ArrayList<CancionDTO> _cancion)
	{
		lista=_cancion;
		
		for(int i=0; i<lista.size(); i++ )
		{
			
			System.out.println("pnlvisualizar" + lista.get(i).getNombre());
			
		}
		pnlcanciones.cargarListaCanciones(lista);
	
	}
	
	public void opcionSeleccionadda(int _opcion)
	{
		this.seleccion=_opcion;
		
	}
	
	

}
