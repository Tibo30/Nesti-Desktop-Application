package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(124, 62, 72, 58);
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/assets/logo.jpg")));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUerName_Connexion = new JLabel("User Name");
		lblUerName_Connexion.setForeground(new Color(0, 0, 0));
		lblUerName_Connexion.setBounds(86, 155, 160, 20);
		lblUerName_Connexion.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblUerName_Connexion);
		
		textField = new JTextField();
		textField.setBounds(86, 176, 160, 20);
		textField.setColumns(10);
		textField.setBackground(new Color(205, 133, 63));
		contentPane.add(textField);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(86, 230, 160, 20);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(205, 133, 63));
		contentPane.add(textField_1);
		
		JLabel lblPassword_Connexion = new JLabel("Password");
		lblPassword_Connexion.setForeground(new Color(0, 0, 0));
		lblPassword_Connexion.setBounds(86, 207, 161, 20);
		lblPassword_Connexion.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblPassword_Connexion);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(124, 331, 89, 35);
		btnLogin.setBackground(new Color(160, 82, 45));
		contentPane.add(btnLogin);
		
		JLabel lblBackground = new JLabel("New label");
		Image img = new ImageIcon(Frame.class.getResource("/assets/NESTi.jpg")).getImage();
        Image newimg = img.getScaledInstance( 313, 437, java.awt.Image.SCALE_SMOOTH);
		lblBackground.setIcon(new ImageIcon(newimg));
        lblBackground.setBounds(0, 0, 313, 437);
		contentPane.add(lblBackground);
		
		
		
	}
}
