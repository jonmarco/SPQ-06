package es.deusto.client.GUI;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import es.deusto.client.Controller.InteractuarController;
import es.deusto.server.dto.CancionDTO;
import java.awt.Color;

/**
 * This class creates the frame 
 */


public class VInteractuar extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnBuscar;
	private ArrayList<CancionDTO> lista = new ArrayList<CancionDTO>();
	
	private PnlReproduccion pnlrepro;
	private PnlCanciones pnlcancion;
	private PnlListareproduccion pnlreproducciones;
	private int seleccion;
	private PnlVisualizar pnlvisualizar;
	private PnlUsuarioLogin pnllogin;
	private PnlCarga pnlcarga;
	
	private boolean cambiodepanel=true;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VInteractuar frame = new VInteractuar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	@SuppressWarnings("deprecation")
	public VInteractuar()
	{
		
		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/*Panel de login el cual se ocultara si es correcto*/
		PnlUsuarioLogin pnllogin = new PnlUsuarioLogin();
		
		
		this.contentPane.add(pnllogin);
		
		
		
		this.show();
		this.setVisible(true);
		
		
		repaint();
		
	}
	
	
	/**
 * This method finds songs into the list
 * 
 */

	public void buscar() {
			String busqueda = textField.getText();
			System.out.println(busqueda);
			
			if(esnumerico(busqueda))
			{
				int id = Integer.parseInt(busqueda);
				CancionDTO cancion = InteractuarController.getInstance().buscarCancion(id);
				System.out.println(cancion.getNombre());
				
				lista.add(cancion);
				System.out.println("lista posicion:" + lista.get(0).getNombre());
				
				pnlvisualizar.cargarLista(lista);
				
				
			}else{
				ArrayList<CancionDTO> canciones = InteractuarController.getInstance().buscarCanciones(busqueda);
				lista=canciones;
				pnlvisualizar.cargarLista(lista);
				
				
				for(int i=0; i < canciones.size(); i++)
				{
					System.out.println("nombre" +canciones.get(i).getNombre() + "id" + canciones.get(i).getId_cancion());
					
				}
				
				for(int j=0; j <lista.size(); j++)
				{
					System.out.println("lista nombres" + lista.get(j).getNombre());
				}
				
				
				
			}
	}
	
	/**
 * This method is going to tell us if the string has a number
 * @param: Receives a string
 */
	public boolean esnumerico(String _nombre)
	{
		boolean esnumerico=false;
		
		try{
			Integer.parseInt(_nombre);
			esnumerico=true;
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "Buscar por nombre");
		}
		
		
		return esnumerico;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==btnBuscar)
		{
			System.out.println("btnbuscar");
			buscar();
		}
		
	
	}
	
	public void cambiarPanelLogin()
	{
		
		// introducimos en el principal el pnllogin
		
		this.contentPane.remove(pnllogin);
			
			JPanel PnlBusqueda = new JPanel();
			PnlBusqueda.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			PnlBusqueda.setLocation(15, 13);
			PnlBusqueda.setSize(925, 68);
			
			// introducimos el panel principal
			
			contentPane.add(PnlBusqueda);
			PnlBusqueda.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(12, 33, 210, 22);
			PnlBusqueda.add(textField);
			textField.setColumns(10);
		
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(232, 32, 83, 25);
			PnlBusqueda.add(btnBuscar);
			btnBuscar.addActionListener(this);
			
			JLabel lblNombreCancin = new JLabel("Nombre Canci\u00F3n:");
			lblNombreCancin.setBounds(12, 13, 99, 16);
			PnlBusqueda.add(lblNombreCancin);
			
			JLabel lblnombrelogeado = new JLabel("Bienvenido, "+ InteractuarController.getNombre()+"!");
			lblnombrelogeado.setBounds(736, 41, 177, 16);
			PnlBusqueda.add(lblnombrelogeado);
			
			
			PnlSeleccion pnlseleccion = new PnlSeleccion();
			pnlseleccion.setBounds(15,92,153,428);
			contentPane.add(pnlseleccion);
			
			seleccion= pnlseleccion.getSeleccion();
			
			
			pnlvisualizar = new PnlVisualizar();
			pnlvisualizar.setBounds(180, 92, 760, 428);
		
			contentPane.add(pnlvisualizar);
			
			
			repaint();
		
		
	
	}
	
	
}
