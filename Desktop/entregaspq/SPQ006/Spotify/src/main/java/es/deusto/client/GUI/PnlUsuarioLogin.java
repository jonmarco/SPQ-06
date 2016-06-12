package es.deusto.client.GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import es.deusto.client.Validar;
import es.deusto.client.Controller.InteractuarController;
import es.deusto.server.data.Usuario;
import es.deusto.server.dto.UsuarioDTO;
import es.deusto.server.services.BusquedaService;

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
	
	private JPanel pnldatos;
	private JTextField txtemail;
	private JPasswordField txtpassword;
	private PnlCarga pnlCarga;
	private JButton btnlogin;
	
	
	public JButton getBtnlogin() {
		return btnlogin;
	}

	public void setBtnlogin(JButton btnlogin) {
		this.btnlogin = btnlogin;
	}

	public JButton getBtnloginregistro() {
		return btnloginregistro;
	}

	public void setBtnloginregistro(JButton btnloginregistro) {
		this.btnloginregistro = btnloginregistro;
	}



	private Validar va;
	private JLabel lblpassword;
	private JLabel lblemail;
	
	
	private JPanel pnldatosregistrarse;
	private JLabel lblregistrarse;
	private JLabel lblpasswordregistro;
	private JLabel lblemailregistro;
	private JButton btnloginregistro;
	private JTextField txtemailregistro;
	private JPasswordField txtpasswordregistro;
	
	
	private ImageIcon icorrecto;
	private ImageIcon ierror;
	private Image imcorrecto;
	private Image imerror;
	
	
	private JLabel lblemailcorrecto;
	private JLabel lblpasscorrecto;
	
	private JLabel lblemailcorrectoregistro;
	private JLabel lblpasscorrectoregistro;
	
	private boolean correcto=false;
	
	
	private String email="";
	private String password="";
	
	
	private boolean cerrar = false;
	
	private JLabel lblgoback;
	
	private UsuarioDTO user;
	private VInteractuar vin;
	

	public boolean isCerrar() {
		return cerrar;
	}

	public void setCerrar(boolean cerrar) {
		this.cerrar = cerrar;
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	/**
	 * Create the panel.
	 */
	public PnlUsuarioLogin() {
		setBackground(new Color(128, 128, 128));
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		this.setBounds(0, 0, 970, 556);
		setLayout(null);
		
		/*PANEL LOGIN*/
		
		pnldatos = new JPanel();
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
		
		lblregistrarse = new JLabel("¿No eres Usuario? Registrate.");
		lblregistrarse.setBounds(90, 218, 185, 16);
		pnldatos.add(lblregistrarse);
		
		
		
		
		
		
		
		
		/*PANEL REGISTRO*/
		pnldatosregistrarse = new JPanel();
		pnldatosregistrarse.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		pnldatosregistrarse.setBounds(502, 118, 368, 359);
		pnldatosregistrarse.setLayout(null);
		this.add(pnldatosregistrarse);
		
		lblemailregistro = new JLabel("Email:");
		lblemailregistro.setBounds(32, 49, 81, 16);
		pnldatosregistrarse.add(lblemailregistro);
		
		txtemailregistro = new JTextField();
		txtemailregistro.setBounds(32, 82, 287, 38);
		pnldatosregistrarse.add(txtemailregistro);
		txtemailregistro.setColumns(10);
		
		lblpasswordregistro = new JLabel("Password:");
		lblpasswordregistro.setBounds(32, 138, 81, 16);
		pnldatosregistrarse.add(lblpasswordregistro);
		
		btnloginregistro = new JButton("Registrarse");
		
		
		lblgoback = new JLabel("<- Volver ");
		lblgoback.setBounds(12, 318, 72, 16);
		pnldatosregistrarse.add(lblgoback);
		// creamos el panel con la imagen de mi spotify inicial
		
		
		//pnlcarga = new PnlCarga();
		btnloginregistro.setBounds(105, 252, 126, 38);
		pnldatosregistrarse.add(btnloginregistro);
		
		txtpasswordregistro = new JPasswordField();
		txtpasswordregistro.setBounds(32, 167, 287, 38);
		pnldatosregistrarse.add(txtpasswordregistro);
		
		lblemailcorrectoregistro = new JLabel("");
		lblemailcorrectoregistro.setBounds(331, 88, 16, 27);
		pnldatosregistrarse.add(lblemailcorrectoregistro);
		
		lblpasscorrectoregistro = new JLabel("");
		lblpasscorrectoregistro.setBounds(331, 167, 16, 27);
		pnldatosregistrarse.add(lblpasscorrectoregistro);
		
		
		
		
		
		
		/*PANEL CARGA*/
		pnlCarga = new PnlCarga();
		pnlCarga.setBounds(61, 82, 385, 400);
		add(pnlCarga);
		
		//txtusername.addFocusListener(this);
		//txtpassword.addActionListener(this);
		
		va = new Validar();
		btnlogin.addActionListener(this);
		btnloginregistro.addActionListener(this);
		
	
		
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
			
		
		/*lblregistrarse ActionListener*/
		lblregistrarse.addMouseListener(new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent arg0) {
						// TODO Auto-generated method stub
						pnldatos.setVisible(false);
						pnldatos.setEnabled(false);
						pnldatosregistrarse.setVisible(true);
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
						// TODO Auto-generated method stub
						lblregistrarse.setForeground(Color.blue);
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
						// TODO Auto-generated method stub
						lblregistrarse.setForeground(Color.black);
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
						// TODO Auto-generated method stub
						
					}
			
				});
		
		/*PANEL LOGIN CORRECTO*/
		
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
		
		
		/*PANEL REGISTER CORRECTO*/
		
		txtemailregistro.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(va.validarEmail(txtemailregistro.getText()))
				{
					lblemailcorrectoregistro.setIcon(icorrecto);
					System.out.print("Correcto y perdemos el foco");
				}
				else
				{
					lblemailcorrectoregistro.setIcon(ierror);
					System.out.print("error y perdemos el foco");
				}
			}
	
	
	
	
	
	
	
		});

		txtpasswordregistro.addFocusListener(new FocusListener(){
		
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
				
				
			}
		
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if(va.validarPassword(txtpasswordregistro.getText()))
				{
					lblpasscorrectoregistro.setIcon(icorrecto);
					System.out.println("correcto y perdemos el foco");
				}
				else
				{
					lblpasscorrectoregistro.setIcon(ierror);
					System.out.println("error y perdemos el foco");
				}
				
				
			}
			
			
			
		});
		
		
		lblgoback.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
				pnldatosregistrarse.setVisible(false);
				pnldatosregistrarse.setEnabled(false);
				pnldatos.setVisible(true);
				pnldatos.setEnabled(true);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblgoback.setForeground(Color.yellow);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				lblgoback.setForeground(Color.BLACK);
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		
		
		
		
		
		

		setOpaque(false);
		repaint();
		
	}
	
	public boolean login()
	{
		String mail;
		String password;
		correcto=false;
		Validar va = new Validar();
		
		
		mail = txtemail.getText();
		password = txtpassword.getText();
		
		if(va.validarEmail(mail) && va.validarPassword(password))	
			correcto=true;
		else
			correcto=false;
			
		
		return correcto;
	
	}
	
	public boolean loginregistro()
	{
		String mail;
		String password;
		correcto=false;
		Validar va = new Validar();
		
		
		mail = txtemailregistro.getText();
		password = txtpasswordregistro.getText();
		
		if(va.validarEmail(mail) && va.validarPassword(password))	
			correcto=true;
		else
			correcto=false;
			
		
		return correcto;
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		
		if(e.getSource() == btnlogin)
		{
			
			// obtenemos el usuario cargado en la base de datos	
			//pnlCarga.start();
			// WHILE(pnlCarga.isEnabled)
			// no hacemos nada sino lanzamos cuadrar tiempos
			System.out.print("comprobando si es correcto...");
			if(login())
			{
				
				
				System.out.println("login devuelto:" + login());
					
					
					// sacamos los datos de las cajas de texto
					email = txtemail.getText();
					password = txtpassword.getText();
					
	
					// sacamos el usuario de la base de datos pasandole el email de busqueda
					System.out.println("Buscamos usuario...");
					UsuarioDTO miusuario = InteractuarController.getInstance().buscarUsuario(email, password);
					
					System.out.println("Clave del usuario: " + miusuario.getPassword());
					// comprobamos si es correcto el login
					System.out.println("Comprobamos...");
					if(email.equals(miusuario.getcorreo()) && password.equals(miusuario.getPassword()))
					{
						JOptionPane.showMessageDialog(this, "Login correcto");
						new VInteractuar();
						
						System.out.println("correcto");
							
						cerrar = true;
					}
					else
					{
						JOptionPane.showMessageDialog(this, "El usuario no existe o no coinciden los datos");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Datos mal introducidos");
					
					
				}
			
			
			
			
		}else if(e.getSource() == btnloginregistro)
		{
			// registramos el usuario en la base de datos
			pnlCarga.start();
			System.out.print("comprobando si es correcto...");
			
	
			UsuarioDTO miusuario;
			boolean existe=false;
			
			if(loginregistro())
			{
				String emailregistro = txtemailregistro.getText();
				String password = txtpasswordregistro.getText();
				
				
				
				//Usuario user = InteractuarController.getInstance().login(user, pass)(emailregistro, password);
				if(InteractuarController.getInstance().login(emailregistro, password))
				{
					JOptionPane.showMessageDialog(this, "El usuario ya existe");
				}else
				{
					existe = InteractuarController.getInstance().registrarUsuario(emailregistro, password);
					// buscamos y lo mandamos
					
					//miusuario = InteractuarController.getInstance().buscarUsuario(txtemail.getText());
					JOptionPane.showMessageDialog(this, "Registro correcto");
					
					new VInteractuar();
					
				}
				
				
				
				cerrar = true;
				// carga del usuario a la base de datos
				
			}else
			{
				JOptionPane.showMessageDialog(this, "Datos mal Introducidos");
			
			}
			
		}
		
	}
}
