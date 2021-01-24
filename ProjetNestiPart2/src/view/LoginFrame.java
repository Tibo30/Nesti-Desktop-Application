package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private TextField username;
	private PasswordField password;
	private Label UserName;
	private QueryAdmin queryAdmin;

//	private Label password;
	/**
	 * Launch the application.
	 */

//	public static void main(String[] args) {
//		
//		MyConnection co= new MyConnection();
//		
//		
//		
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					LoginFrame frame = new LoginFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

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

		TextField tfUsername = new TextField("username", 86, 176, 160, 20);
		contentPane.add(tfUsername);

		tfUsername.setColumns(10);
		tfUsername.setBackground(new Color(205, 133, 63));

		PasswordField password = new PasswordField("password", 86, 230, 160, 20);

		password.setColumns(10);
		password.setBackground(new Color(205, 133, 63));
		contentPane.add(password);

		Label lblBackground = new Label("background", 0, 0, 313, 437);

		Image img = new ImageIcon(Frame.class.getResource("/assets/NESTi.jpg")).getImage();
		Image newimg = img.getScaledInstance(313, 437, java.awt.Image.SCALE_SMOOTH);
		lblBackground.setIcon(new ImageIcon(newimg));

		contentPane.add(lblBackground);

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
				char[] psw = password.getPassword();

//				Ecrire en dur le mot de passe et username

				try {
					if (queryAdmin.checkPassword(user, String.valueOf(psw))) {
						JOptionPane.showMessageDialog(null, "Connection successful");
						
						
						Frame window = new view.Frame() ;
						window.show();
						dispose();
						

						Frame.activAdmin = queryAdmin.selectAdminInfo("JohnnyDoe35");

					} else {
						JOptionPane.showMessageDialog(null, "Invalid Username or Password");

					}
				} catch (Exception exp) {
					System.err.println("Error in Admin informations" + exp.getMessage());
				}
			}

		});

	}
}
