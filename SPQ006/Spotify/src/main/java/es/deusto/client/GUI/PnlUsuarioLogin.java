package es.deusto.client.GUI;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import es.deusto.client.Validar;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.net.URL;
import java.awt.event.ActionEvent;

public class PnlUsuarioLogin extends JPanel implements ActionListener{
	@Override
	public synchronized void addKeyListener(KeyListener l) {
		// TODO Auto-generated method stub
		super.addKeyListener(l);
	}

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtemail;
	private JPasswordField txtpassword;
	private PnlCarga pnlCarga;
	private JButton btnlogin;
	private Validar va;
	private JLabel lblpassword;
	private JLabel lblemail;
	
	private ImageIcon icorrecto;
	private ImageIcon ierror;
	private Image imcorrecto;
	private Image imerror;
	
	
	private JLabel lblemailcorrecto;
	private JLabel lblpasscorrecto;
	
	
	

	/**
	 * Create the panel.
	 */
	public PnlUsuarioLogin() {
		setBackground(new Color(128, 128, 128));
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setBounds(0, 0, 970, 556);
		setLayout(null);
		
		JPanel pnldatos = new JPanel();
		pnldatos.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnldatos.setBounds(502, 118, 368, 359);
		add(pnldatos);
		pnldatos.setLayout(null);
		
		lblemail = new JLabel("Email:");
		lblemail.setBounds(32, 49, 81, 16);
		pnldatos.add(lblemail);
		
		txtemail = new JTextField();
		txtemail.setBounds(32, 82, 287, 38);
		pnldatos.add(txtemail);
		txtemail.setColumns(10);
		
		lblpassword = new JLabel("Password:");
		lblpassword.setBounds(32, 138, 81, 16);
		pnldatos.add(lblpassword);
		
		btnlogin = new JButton("Login");
		// creamos el panel con la imagen de mi spotify inicial
		
		
		//pnlcarga = new PnlCarga();
		btnlogin.setBounds(105, 252, 126, 38);
		pnldatos.add(btnlogin);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(32, 167, 287, 38);
		pnldatos.add(txtpassword);
		
		lblemailcorrecto = new JLabel("");
		lblemailcorrecto.setBounds(331, 88, 16, 27);
		pnldatos.add(lblemailcorrecto);
		
		lblpasscorrecto = new JLabel("");
		lblpasscorrecto.setBounds(331, 167, 16, 27);
		pnldatos.add(lblpasscorrecto);
		
		pnlCarga = new PnlCarga();
		pnlCarga.setBounds(61, 82, 385, 400);
		add(pnlCarga);
		
		//txtusername.addFocusListener(this);
		//txtpassword.addActionListener(this);
		
		va = new Validar();
		btnlogin.addActionListener(this);
	
		
		icorrecto = new ImageIcon("src/imagenes/iconocorrecto.png");
		ierror = new ImageIcon("src/imagenes/iconoerror.png");
		
		/*
		if(ucorrecto != null && uerror!= null)
		{
		icorrecto = new ImageIcon(ucorrecto);
		ierror = new ImageIcon(uerror);
		}
		else
		{
			System.out.println("no se encuentran las imagenes");
		}
		*/
		
		if(imcorrecto != null & imerror != null)
			System.out.println("cargamos las imagenes");
		else 
			System.out.println("no se cargan las imagenes");
			
		
		
		
		
		txtemail.addFocusListener(new FocusListener()
				{

					@Override
					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void focusLost(FocusEvent e) {
						// TODO Auto-generated method stub
						if(va.validarEmail(txtemail.getText()))
						{
							lblemailcorrecto.setIcon(icorrecto);
							System.out.print("Correcto y perdemos el foco");
						}
						else
						{
							lblemailcorrecto.setIcon(ierror);
							System.out.print("error y perdemos el foco");
						}
					}
			
			
			
			
			
			
			
				});
		
		txtpassword.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
				
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(va.validarPassword(txtpassword.getText()))
				{
					lblpasscorrecto.setIcon(icorrecto);
					System.out.println("correcto y perdemos el foco");
				}
				else
				{
					lblpasscorrecto.setIcon(ierror);
					System.out.println("error y perdemos el foco");
				}
				
				
			}
			
			
			
		});
		
		
		
		

		setOpaque(false);
		repaint();
		
	}
	
	public boolean login()
	{
		String mail;
		String password;
		boolean login=false;
		Validar va = new Validar();
		
		
		mail = txtemail.getText();
		password = txtpassword.getText();
		
		if(va.validarEmail(mail) && va.validarPassword(password))	
			login=true;
		else
			login=false;
			
		
		return login;
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnlogin)
		{
			pnlCarga.start();
			System.out.print("Inicio seleccionado:");
			JOptionPane.showMessageDialog(this, "confirmado");
			
			
		}
	}
	
}
