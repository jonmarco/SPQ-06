package es.deusto.client.GUI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PnlCarga extends JPanel implements Runnable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon imgic;
	// especificamos el nombre de la ruta
	private String nombreruta="";
	// imagenes cargadas en el proyecto para su carga
	private String[] cargaimagenes = {
			"src/imagenes/mispotify.png","src/imagenes/mispotifycargauno.png",
			"src/imagenes/mispotifycargados.png","src/imagenes/mispotifycargatres.png"};
	

	
	private String miimagen="acdc.jpg";
	private java.net.URL imgURL;
	private String imagen="";
	private Thread carga=null;
	private int index=0;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	/**
	 * Create the panel.
	 */
	
	// imagen inicial
	public PnlCarga() {
		setBorder(null);
		
		setLayout(null);
		
		System.out.println("pintamos el panel");
		System.out.print("indice inicial del array es:" + cargaimagenes[index]);
		
		
		repaint();

	}
	
	@Override
	public void paint(Graphics g) {
		
		
		//imagen = cargaimagenes[index];
		//imgURL = getClass().getResource(imagen);
		
		boolean cargado=true;
	    if (cargado) {
	    	Graphics2D gr=(Graphics2D)g;
			Dimension t = getSize();
			System.out.println("el indice es:" + index);
	    	imgic= new ImageIcon(cargaimagenes[index]);
			gr.drawImage(imgic.getImage(), 0, 0, t.width, t.height, null);
	        
	    } else {
	        System.err.println("no se encontro el archivo especificado de la imagen" + nombreruta);
	        
	    }
	    
		setOpaque(false);
		
		super.paint(g);
		
	}
	
	

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		while(carga!=null)
		{
			
			System.out.println("entramos en el hilo");
			try{
				
				
				Thread.sleep(1000);
				// cada segundo incrementamos la variable
				// recorremos el array pintado la imagen de la 
				// siguiente posicion
				index++;
				System.out.println(index);
				
				if(index==4)
				{
					stop();	
				}
				
				
			
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			
			this.repaint();
			
		}
		
		// duda
		carga=null;
		
	}
	
	public void start()
	{
		index=0;
		if(carga==null)
		{
			
			System.out.println("creamos nuevo hilo");
			carga= new Thread(this);
			carga.start();
			
		}
		
	}
	
	
	public void stop()
	{
		
		carga=null;
		index=0;
		
		
	
	}
	
	/*
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		
		paint(g);
	}*/


}
