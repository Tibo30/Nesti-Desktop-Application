import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class Connexion extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion frame = new Connexion();
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
	public Connexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 476);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(124, 62, 72, 58);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Utilisateur\\Documents\\Saliha_CDA_2020_2021\\eclipse-workspace\\ProjetNestiPart2\\ProjetNestiPart2\\src\\assets\\logo.jpg"));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblUerName_Connexion = new JLabel("User Name");
		lblUerName_Connexion.setBounds(86, 155, 160, 20);
		lblUerName_Connexion.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblUerName_Connexion);
		
		textField = new JTextField();
		textField.setBounds(86, 176, 160, 20);
		textField.setColumns(10);
		textField.setBackground(new Color(205, 133, 63));
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 230, 160, 20);
		textField_1.setColumns(10);
		textField_1.setBackground(new Color(205, 133, 63));
		contentPane.add(textField_1);
		
		JLabel lblPassword_Connexion = new JLabel("Password");
		lblPassword_Connexion.setBounds(86, 207, 161, 20);
		lblPassword_Connexion.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblPassword_Connexion);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogin.setBounds(124, 331, 89, 35);
		btnLogin.setBackground(new Color(160, 82, 45));
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Utilisateur\\Documents\\Saliha_CDA_2020_2021\\eclipse-workspace\\ProjetNestiPart2\\ProjetNestiPart2\\src\\assets\\NESTi.jpg"));
		lblNewLabel.setBounds(0, 11, 313, 426);
		contentPane.add(lblNewLabel);
	}
}
