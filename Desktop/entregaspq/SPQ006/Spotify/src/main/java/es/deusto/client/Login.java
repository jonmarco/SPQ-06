package es.deusto.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.client.GUI.PnlUsuarioLogin;
import es.deusto.client.GUI.VInteractuar;

public class Login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private PnlUsuarioLogin pnllogin;
	private boolean correcto=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		setResizable(false);
		setTitle("Login Spotify");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 586);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		/*Panel de login el cual se ocultara si es correcto*/
		pnllogin = new PnlUsuarioLogin();
		
		
		this.contentPane.add(pnllogin);
		
		
		//cambiarPanelLogin();
		
		this.show();
		this.setVisible(true);
		
		
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	
		
		if(pnllogin.isCorrecto())
		{
			this.dispose();
			new VInteractuar();
			System.out.println("HOLAHOLA");
			
		}
		
		
		
		
	}

}
