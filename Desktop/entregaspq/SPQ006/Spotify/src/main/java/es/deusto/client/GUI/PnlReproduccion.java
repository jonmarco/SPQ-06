package es.deusto.client.GUI;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import es.deusto.client.Controller.InteractuarController;
import es.deusto.server.data.Fecha;
import es.deusto.server.data.Hora;

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
	
	private PnlScroll pnl;
	//private Reproductor r;
	private JSlider sld_volumen;
	
	public PnlReproduccion(PnlScroll _pnl) {
		setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		setLayout(null);
		
		this.pnl = _pnl;
		PnlcancionSeleccionada pnlseleccion = new PnlcancionSeleccionada("src/imagenes/cancion.jpg");
		pnlseleccion.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlseleccion.setBounds(12, 13, 197, 176);
		add(pnlseleccion);
		
		JButton btn_reproducir = new JButton("Reproducir");
		btn_reproducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				// obtenemos la hora actual y la fecha y se la pasamos
				Hora hora = new Hora();
				Fecha fecha = new Fecha();
				
				try
				{
					pnl.start();
					
				
					
					System.out.println("empezamos a mover el texto");
					
					System.out.println("cambiamos valor de reproduciendo de la cancion");
					//InteractuarController.getInstance().playSong(id_cancion, _correo);
				
				//r = new Reproductor();
				System.out.println("Cancion seleccionada:" + pnl.getNombre());
				//r.abrirFichero("src/canciones/" + pnl.getNombre() + ".mp3");
				//r.abrirFichero("C:/SPQ006/Spotify/src/canciones/"+pnl.getNombre()+".mp3");
				//System.out.println("src/canciones/" + pnl.getNombre() + ".mp3");
				System.out.println("C:/SPQ006/Spotify/src/canciones/"+pnl.getNombre()+".mp3");
				//r.play(); 
			
				
				}catch(Exception ex)
				{ 
					ex.printStackTrace();	
					
				}
				
				
				// obtenemos la fecha actual
				
				
				// obtenemos la hora actual de la repdroduccion
				
				
				
			}
		});
		btn_reproducir.setBounds(266, 147, 97, 25);
		add(btn_reproducir);
		
		JButton btn_parar = new JButton("Parar");
		btn_parar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					pnl.stop();
					System.out.println("Paramos la cancion");
					// recoger objeto
					//InteractuarController.getInstance().stopSong(id_cancion);
					//r.pause();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btn_parar.setBounds(375, 147, 97, 25);
		add(btn_parar);
		
		JLabel lbl_reproduciendo = new JLabel("Reproduciendo:");
		lbl_reproduciendo.setBounds(266, 53, 97, 16);
		add(lbl_reproduciendo);
		
		sld_volumen = new JSlider();
		sld_volumen.setBounds(503, 134, 234, 56);
		sld_volumen.setPaintTicks(true);
		sld_volumen.setMinorTickSpacing(5);
		sld_volumen.setMajorTickSpacing(20);
		sld_volumen.setBorder(new TitledBorder("Volumen"));
		
		sld_volumen.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent arg0) {
				// TODO Auto-generated method stub
				try {
					//r.fijarVolumen(sld_volumen.getValue());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
		});
		add(sld_volumen);
		
		pnl.setBounds(266,82,408,35);
		add(pnl);
		
		repaint();
		
		

	}
}
