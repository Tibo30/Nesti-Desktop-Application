import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class Frame {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextField FirsName;
	private JTextField LastName;
	private JTextField UserName;
	private JTextField Password;
	private JTextField NewPassword;
	private JTextField Conform_Password;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 854, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBackground(new Color(210, 105, 30));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 815, 458);
		panel.add(tabbedPane);
		
		JPanel panel_Home = new JPanel();
		panel_Home.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Home", null, panel_Home, null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(-2, 5, 815, 420);
		Image img = new ImageIcon(Frame.class.getResource("/assets/NESTi2.jpg")).getImage();
        Image newimg = img.getScaledInstance( 815, 420, java.awt.Image.SCALE_SMOOTH);
        panel_Home.setLayout(null);
        lblNewLabel.setIcon(new ImageIcon(newimg));
		
		
		panel_Home.add(lblNewLabel);
		tabbedPane.setBackgroundAt(0, new Color(173, 255, 47));
		
		
		JPanel panel_Profile = new JPanel();
		
		FlowLayout flowLayout = (FlowLayout) panel_Profile.getLayout();
		panel_Profile.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Profile", null, panel_Profile, null);
		panel_Profile.setLayout(null);
		
		FirsName = new JTextField();
		FirsName.setBounds(52, 92, 160, 20);
		panel_Profile.add(FirsName);
		FirsName.setColumns(10);
		
		LastName = new JTextField();
		LastName.setBounds(52, 146, 160, 20);
		panel_Profile.add(LastName);
		LastName.setColumns(10);
		
		UserName = new JTextField();
		UserName.setBounds(52, 199, 160, 20);
		panel_Profile.add(UserName);
		UserName.setColumns(10);
		
		Password = new JTextField();
		Password.setBounds(577, 92, 138, 20);
		panel_Profile.add(Password);
		Password.setColumns(10);
		
		NewPassword = new JTextField();
		NewPassword.setBounds(577, 146, 138, 20);
		panel_Profile.add(NewPassword);
		NewPassword.setColumns(10);
		
		Conform_Password = new JTextField();
		Conform_Password.setBounds(577, 199, 138, 20);
		panel_Profile.add(Conform_Password);
		Conform_Password.setColumns(10);
		
		JButton btnModify_Profile = new JButton("Modify Profile");
		btnModify_Profile.setBackground(new Color(173, 255, 47));
		btnModify_Profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModify_Profile.setBounds(175, 359, 110, 23);
		panel_Profile.add(btnModify_Profile);
		
		JButton btnModidy_PassWord = new JButton("Modidy PassWord");
		btnModidy_PassWord.setBackground(new Color(173, 255, 47));
		btnModidy_PassWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModidy_PassWord.setBounds(450, 371, 138, 23);
		panel_Profile.add(btnModidy_PassWord);
		
		JButton btnSave_Password = new JButton("Save Password");
		btnSave_Password.setBackground(new Color(173, 255, 47));
		btnSave_Password.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave_Password.setBounds(450, 359, 138, 23);
		panel_Profile.add(btnSave_Password);
		
		JLabel lblFirsName = new JLabel("Firstname");
		lblFirsName.setBounds(52, 71, 160, 20);
		panel_Profile.add(lblFirsName);
		
		JLabel lblLastName = new JLabel("Lastname");
		lblLastName.setBounds(50, 123, 162, 20);
		panel_Profile.add(lblLastName);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setBounds(51, 177, 161, 20);
		panel_Profile.add(lblUserName);
		
		JLabel lblNPassword = new JLabel("Password");
		lblNPassword.setBounds(577, 74, 138, 14);
		panel_Profile.add(lblNPassword);
		
		JLabel lblNewPassword = new JLabel("Newpassword");
		lblNewPassword.setBounds(577, 121, 138, 22);
		panel_Profile.add(lblNewPassword);
		
		JLabel lblConfirm_Password = new JLabel("Confirm password");
		lblConfirm_Password.setBounds(577, 177, 138, 14);
		panel_Profile.add(lblConfirm_Password);
		
		
		JPanel panel_Supplier = new JPanel();
		panel_Supplier.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Supplier", null, panel_Supplier, null);
		panel_Supplier.setLayout(null);
		
		JLabel lblSearch_Supplier = new JLabel("Search");
		lblSearch_Supplier.setBounds(125, 34, 95, 27);
		panel_Supplier.add(lblSearch_Supplier);
		
		JComboBox list_Supplier = new JComboBox();
		list_Supplier.setBounds(182, 31, 339, 32);
		panel_Supplier.add(list_Supplier);
		
		JButton btnLaunch_Supplier = new JButton("Launch");
		btnLaunch_Supplier.setBounds(531, 36, 74, 23);
		panel_Supplier.add(btnLaunch_Supplier);
		
		JButton btnBlockSupplier = new JButton("Block / Unblock");
		btnBlockSupplier.setBackground(new Color(175, 238, 238));
		btnBlockSupplier.setBounds(10, 87, 122, 23);
		panel_Supplier.add(btnBlockSupplier);
		
		textField_5 = new JTextField();
		textField_5.setBounds(26, 133, 86, 20);
		panel_Supplier.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(141, 133, 213, 20);
		panel_Supplier.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(375, 133, 86, 20);
		panel_Supplier.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(26, 172, 86, 20);
		panel_Supplier.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(168, 172, 86, 20);
		panel_Supplier.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(299, 172, 86, 20);
		panel_Supplier.add(textField_10);
		textField_10.setColumns(10);
		
		JList list_Product = new JList();
		list_Product.setBounds(561, 115, 225, 257);
		panel_Supplier.add(list_Product);
		
		JPanel panel_Order = new JPanel();
		panel_Order.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Order", null, panel_Order, null);
		panel_Order.setLayout(null);
		
		JPanel panel_Article = new JPanel();
		panel_Article.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Article", null, panel_Article, null);
		panel_Article.setLayout(null);
		
		JPanel panel_Product = new JPanel();
		panel_Product.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Product", null, panel_Product, null);
		panel_Product.setLayout(null);
		
		JPanel panel_History = new JPanel();
		panel_History.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("History", null, panel_History, null);
		panel_History.setLayout(null);
		
		JPanel panel_Manage = new JPanel();
		panel_Manage.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Manage", null, panel_Manage, null);
		panel_Manage.setLayout(null);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(133, 46, 95, 27);
		panel_Manage.add(lblSearch);
		
		JComboBox list = new JComboBox();
		list.setBounds(190, 43, 339, 32);
		panel_Manage.add(list);
		
		JButton btnLaunch = new JButton("Launch");
		btnLaunch.setBounds(539, 48, 74, 23);
		panel_Manage.add(btnLaunch);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(59, 151, 160, 20);
		panel_Manage.add(textField);
		
		JLabel lblFirsName_1 = new JLabel("Firstname");
		lblFirsName_1.setBounds(59, 130, 160, 20);
		panel_Manage.add(lblFirsName_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(59, 205, 160, 20);
		panel_Manage.add(textField_1);
		
		JLabel lblLastName_1 = new JLabel("Lastname");
		lblLastName_1.setBounds(57, 182, 162, 20);
		panel_Manage.add(lblLastName_1);
		
		JLabel lblUserName_1 = new JLabel("Username");
		lblUserName_1.setBounds(58, 236, 161, 20);
		panel_Manage.add(lblUserName_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(59, 258, 160, 20);
		panel_Manage.add(textField_2);
		
		JLabel lblNPassword_1 = new JLabel("Password");
		lblNPassword_1.setBounds(584, 141, 138, 14);
		panel_Manage.add(lblNPassword_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(584, 159, 138, 20);
		panel_Manage.add(textField_3);
		
		JLabel lblConfirm_Password_1 = new JLabel("Confirm password");
		lblConfirm_Password_1.setBounds(584, 190, 138, 14);
		panel_Manage.add(lblConfirm_Password_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(584, 212, 138, 20);
		panel_Manage.add(textField_4);
		
		JButton btnModify_Profile_1 = new JButton("Modify Profile");
		btnModify_Profile_1.setBackground(new Color(173, 255, 47));
		btnModify_Profile_1.setBounds(182, 372, 110, 23);
		panel_Manage.add(btnModify_Profile_1);
		
		JButton btnModidy_PassWord_1 = new JButton("Modidy PassWord");
		btnModidy_PassWord_1.setBackground(new Color(173, 255, 47));
		btnModidy_PassWord_1.setBounds(507, 372, 138, 23);
		panel_Manage.add(btnModidy_PassWord_1);
		
		JButton btnBlockAdmin = new JButton("Block / Unblock");
		btnBlockAdmin.setBackground(new Color(175, 238, 238));
		btnBlockAdmin.setBounds(334, 315, 122, 23);
		panel_Manage.add(btnBlockAdmin);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(749, 0, 76, 27);
		panel.add(lblLogo);
	}
}
