package main.java.es.deusto.ingenieria.spq.client.GUI;


import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

//import Controller.InteractuarController;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userField;
	private JTextField passField;
	private JLabel lblContrasea;

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
	@SuppressWarnings("deprecation")
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton loginButton = new JButton("Aceptar");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//login();
			}
		});
		loginButton.setBounds(125, 165, 89, 23);
		contentPane.add(loginButton);
		
		userField = new JTextField();
		userField.setBounds(126, 72, 180, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		userField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//login();
			}
		});
		
		passField = new JPasswordField();
		passField.setBounds(126, 103, 180, 20);
		contentPane.add(passField);
		passField.setColumns(10);
		passField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//login();
			}
		});
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(46, 75, 46, 14);
		contentPane.add(lblUsuario);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(27, 106, 89, 14);
		contentPane.add(lblContrasea);
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		this.show();
	}

	/*
	protected void login() {
		if(InteractuarController.getInstance().login(userField.getText(), passField.getText())) {
			new VInteractuar();
			this.dispose();
		} else
			JOptionPane.showMessageDialog(null, "Fallo al conectar");
	}*/
}
