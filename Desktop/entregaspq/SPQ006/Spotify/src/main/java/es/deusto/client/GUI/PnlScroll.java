package es.deusto.client.GUI;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JLabel;
import javax.swing.border.EtchedBorder;

public class PnlScroll extends JPanel implements Runnable{

	
	private Thread temp;
	

	private int posicionX;
	private int posicionY=13;  
	private int width=83;
	private int height=16;
	private String nombre="cancion";
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		int ancho=this.getWidth();		
		Graphics2D gr = (Graphics2D)g;	
		System.out.println(ancho);	
		gr.drawString("", this.getWidth()/2, this.getHeight()/2);
		
	
	}

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbl_nombrecancion;
	public JLabel getLbl_nombrecancion() {
		return lbl_nombrecancion;
	}
	public void setLbl_nombrecancion(JLabel lbl_nombrecancion) {
		this.lbl_nombrecancion = lbl_nombrecancion;
	}
	/**
	 * Create the panel.
	 */
	public PnlScroll() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(null);
		lbl_nombrecancion = new JLabel();
		System.out.print(nombre);
		lbl_nombrecancion.setText(nombre);
		//this.setBounds(posicionX, posicionY, width, height);
		lbl_nombrecancion.setBounds(posicionX, 8, 83, 16);
		add(lbl_nombrecancion);
		this.setVisible(true);

	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		
		while(temp!=null)
		{
			try
			{
				Thread.sleep(1000);
				mover();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			repaint();
			System.out.println("mas");
		}
		
		temp=null;
	}
	
	public void start()
	{
		if(temp==null)
		{
			temp = new Thread(this);
			temp.start();
		}
		
	}
	
	public void stop()
	{
		temp=null;
		lbl_nombrecancion.setBounds(0, 8, 86, 16);
		
		
	}
	
	public void mover()
	{
		posicionX = posicionX+3;
		lbl_nombrecancion.setBounds(posicionX, posicionY, width, height);
		
	}
	
	public void update(Graphics g) {
	    paint(g);
	  }
	

}
