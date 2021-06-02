package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import components.Button;
import components.Label;
import components.PasswordField;
import components.TextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entities.Admin;
import model.MyConnection;
import model.QueryAdmin;
import tools.Check;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private TextField tfUsername;
	private PasswordField pfPassword;
	private QueryAdmin queryAdmin;

	public static int id;



	/**
	 * Create the frame.
	 */

	public LoginFrame() {

		this.queryAdmin = new QueryAdmin();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Button btnLogin = new Button("login", 124, 331, 89, 35);

		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));

		btnLogin.setBackground(new Color(160, 82, 45));
		contentPane.add(btnLogin);
		
		/*
		 * Add ActionListener on login button
		 */
		
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String user = tfUsername.getText();
				char[] psw = pfPassword.getPassword();

				//Faire les vérifications 
			
				if(Check.isValidLogin(user)==false) {
					
					JOptionPane.showMessageDialog(null, "The user name is not valid", "error message", JOptionPane.ERROR_MESSAGE );
					
				
				} else if (Check.isValidPsw(psw)==false){
					
					JOptionPane.showMessageDialog(null, "The password is not valid", "error message", JOptionPane.ERROR_MESSAGE);			
					
					
					
				}else{
					
					try {
						System.out.println(psw);
						queryAdmin.openConnection();
						if (queryAdmin.checkPassword(user, String.valueOf(psw))) {
							JOptionPane.showMessageDialog(null, "Login successful");
							Frame.activAdmin = queryAdmin.selectAdminInfo(user);

							Frame window = new view.Frame();
							dispose();

						} else {
							JOptionPane.showMessageDialog(null, "Invalid Username or Password");
							queryAdmin.closeConnection();

						}
					} catch (Exception exp) {
						System.err.println("Error in Admin informations" + exp.getMessage());
					}	
					
					
				};
				
				
				
				
				//1) champs non vides  
				
				
				
				//2) champs valides
				//3) requête pr vrifier si c'est le bon psw
				//si oui ouvrir l'appli si non  
				
		
			}

		});

		Label lblLogo = new Label("logo", 124, 62, 72, 58);

		lblLogo.setIcon(new ImageIcon(LoginFrame.class.getResource("/assets/logo.jpg")));
		contentPane.add(lblLogo);

		Label lblUserNameConnexion = new Label("UserName", 86, 155, 160, 20);
		lblUserNameConnexion.setForeground(new Color(0, 0, 0));
		lblUserNameConnexion.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblUserNameConnexion);

		Label lblPassswordConnexion = new Label("password", 86, 207, 161, 20);
		lblPassswordConnexion.setForeground(new Color(0, 0, 0));
		lblPassswordConnexion.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblPassswordConnexion);

		this.tfUsername = new TextField("username", 86, 176, 160, 20);
		contentPane.add(tfUsername);

		tfUsername.setColumns(10);
		tfUsername.setBackground(new Color(205, 133, 63));

		this.pfPassword = new PasswordField("password", 86, 230, 160, 20);

		pfPassword.setColumns(10);
		pfPassword.setBackground(new Color(205, 133, 63));
		contentPane.add(pfPassword);

		Image img = new ImageIcon(Frame.class.getResource("/assets/NESTi.jpg")).getImage();
		Image newimg = img.getScaledInstance(313, 437, java.awt.Image.SCALE_SMOOTH);

		Label lblBackground = new Label("background", 0, 0, 313, 437);
		lblBackground.setIcon(new ImageIcon(newimg));

		contentPane.add(lblBackground);

	

	}
}
