package es.deusto.client.GUI;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import es.deusto.client.Controller.InteractuarController;
import es.deusto.server.dto.CancionDTO;

//import Controller.InteractuarController;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Login extends JFrame implements ActionListener{

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
	public Login()
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
		
		
		if(pnllogin.isCerrar()){
			this.dispose();
			new VInteractuar();
			System.out.println("HOLA HOLA HOLA");
		}
			
		
		//cambiarPanelLogin();
		
		this.show();
		this.setVisible(true);
		
		
		repaint();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
