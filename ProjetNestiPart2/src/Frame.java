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
import java.awt.Font;
import javax.swing.SwingConstants;

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
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField Product_textfiel;

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
		panel.setBackground(new Color( 	213, 167, 113));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTabbedPane logo = new JTabbedPane(JTabbedPane.TOP);
		logo.setBounds(10, 11, 815, 458);
		panel.add(logo);
		
		JPanel panel_Home = new JPanel();
		panel_Home.setBackground(new Color(213, 167, 113));
		logo.addTab("Home", null, panel_Home, null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(-2, 5, 815, 420);
		Image img = new ImageIcon(Frame.class.getResource("/assets/NESTi2.jpg")).getImage();
        Image newimg = img.getScaledInstance( 815, 420, java.awt.Image.SCALE_SMOOTH);
        panel_Home.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Joe Smith");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(new Color(248, 248, 255));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        lblNewLabel_2.setBounds(10, 194, 790, 72);
        panel_Home.add(lblNewLabel_2);
        
        JLabel lblNewLabel_1 = new JLabel("Welcome");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
        lblNewLabel_1.setForeground(new Color(255, 250, 250));
        lblNewLabel_1.setBounds(10, 143, 790, 58);
        panel_Home.add(lblNewLabel_1);
        lblNewLabel.setIcon(new ImageIcon(newimg));
		
		
		panel_Home.add(lblNewLabel);
		logo.setBackgroundAt(0, new Color(213, 167, 113));
		
		
		JPanel panel_Profile = new JPanel();
		
		FlowLayout flowLayout = (FlowLayout) panel_Profile.getLayout();
		panel_Profile.setBackground(new Color(213, 167, 113));
		logo.addTab("Profile", null, panel_Profile, null);
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
		btnModify_Profile.setBackground(new Color(232, 250, 126));
		btnModify_Profile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModify_Profile.setBounds(175, 359, 110, 23);
		panel_Profile.add(btnModify_Profile);
		
		JButton btnModidy_PassWord = new JButton("Modidy PassWord");
		btnModidy_PassWord.setBackground(new Color(232, 250, 126));
		btnModidy_PassWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModidy_PassWord.setBounds(450, 371, 138, 23);
		panel_Profile.add(btnModidy_PassWord);
		
		JButton btnSave_Password = new JButton("Save Password");
		btnSave_Password.setBackground(new Color(173, 246, 100));
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
		panel_Supplier.setBackground(new Color(213, 167, 113));
		logo.addTab("Supplier", null, panel_Supplier, null);
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
		btnBlockSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBlockSupplier.setBackground(new Color(191, 244, 255));
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
		
		JList list_Supplier_Listproduct = new JList();
		list_Supplier_Listproduct.setBounds(561, 115, 225, 257);
		panel_Supplier.add(list_Supplier_Listproduct);
		
		JComboBox list_Supplier_Product = new JComboBox();
		list_Supplier_Product.setBounds(26, 301, 184, 32);
		panel_Supplier.add(list_Supplier_Product);
		
		textField_11 = new JTextField();
		textField_11.setBounds(268, 307, 86, 20);
		panel_Supplier.add(textField_11);
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setBounds(364, 307, 97, 20);
		panel_Supplier.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(471, 306, 50, 23);
		panel_Supplier.add(btnNewButton);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreate.setBackground(new Color(232, 250, 126));
		btnCreate.setBounds(141, 396, 89, 23);
		panel_Supplier.add(btnCreate);
		
		JButton btnSupplier_Modify = new JButton("Modify");
		btnSupplier_Modify.setBackground(new Color(232, 250, 126));
		btnSupplier_Modify.setBounds(495, 396, 89, 23);
		panel_Supplier.add(btnSupplier_Modify);
		
		JPanel panel_Order = new JPanel();
		panel_Order.setBackground(new Color(213, 167, 113));
		logo.addTab("Order", null, panel_Order, null);
		panel_Order.setLayout(null);
		
		JPanel panel_Article = new JPanel();
		panel_Article.setBackground(new Color(213, 167, 113));
		logo.addTab("Article", null, panel_Article, null);
		panel_Article.setLayout(null);
		
		JPanel panel_Product = new JPanel();
		panel_Product.setBackground(new Color(213, 167, 113));
		logo.addTab("Product", null, panel_Product, null);
		panel_Product.setLayout(null);
		
		JLabel lblSearch_Supplier_1 = new JLabel("Search");
		lblSearch_Supplier_1.setBounds(142, 36, 95, 27);
		panel_Product.add(lblSearch_Supplier_1);
		
		JTextField list_Product_search = new JTextField();
		list_Product_search.setBounds(199, 33, 339, 32);
		panel_Product.add(list_Product_search);
		
		JButton btnLaunch_Product = new JButton("Launch");
		btnLaunch_Product.setBounds(548, 38, 74, 23);
		panel_Product.add(btnLaunch_Product);
		
		JComboBox list_ingredient = new JComboBox();
		list_ingredient.setBounds(26, 109, 180, 32);
		panel_Product.add(list_ingredient);
		
		JButton btnProduct_Add_Textfield = new JButton("+");
		btnProduct_Add_Textfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProduct_Add_Textfield.setBounds(165, 161, 41, 23);
		panel_Product.add(btnProduct_Add_Textfield);
		
		Product_textfiel = new JTextField();
		Product_textfiel.setBounds(26, 156, 180, 32);
		panel_Product.add(Product_textfiel);
		Product_textfiel.setColumns(10);
		
		JComboBox list_Product_Unit = new JComboBox();
		list_Product_Unit.setBounds(26, 201, 180, 32);
		panel_Product.add(list_Product_Unit);
		
		JList list_Product_Of_Product = new JList();
		list_Product_Of_Product.setBounds(261, 117, 355, 216);
		panel_Product.add(list_Product_Of_Product);
		
		JList list_Product_Nb_Articles = new JList();
		list_Product_Nb_Articles.setBounds(626, 117, 112, 216);
		panel_Product.add(list_Product_Nb_Articles);
		
		JButton btnProduct_Block = new JButton("Block /Unblock selected Element");
		btnProduct_Block.setBackground(new Color(243, 101, 101));
		btnProduct_Block.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProduct_Block.setBounds(165, 379, 194, 40);
		panel_Product.add(btnProduct_Block);
		
		JButton btnProduct_Save = new JButton("Save");
		btnProduct_Save.setBackground(new Color(173, 246, 100));
		btnProduct_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnProduct_Save.setBounds(480, 388, 89, 23);
		panel_Product.add(btnProduct_Save);
		
		JPanel panel_History = new JPanel();
		panel_History.setBackground(new Color(213, 167, 113));
		logo.addTab("History", null, panel_History, null);
		panel_History.setLayout(null);
		
		JList list_History_order = new JList();
		list_History_order.setBounds(23, 154, 317, 121);
		panel_History.add(list_History_order);
		
		JList list_History_Delivery = new JList();
		list_History_Delivery.setBounds(350, 154, 147, 121);
		panel_History.add(list_History_Delivery);
		
		JList list_History_Validation = new JList();
		list_History_Validation.setBounds(521, 154, 147, 121);
		panel_History.add(list_History_Validation);
		
		JList list_History_State = new JList();
		list_History_State.setBounds(694, 154, 84, 121);
		panel_History.add(list_History_State);
		
		JButton btnHistory_Submit = new JButton("Submit");
		btnHistory_Submit.setBackground(new Color(173, 246, 100));
		btnHistory_Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHistory_Submit.setBounds(525, 381, 89, 23);
		panel_History.add(btnHistory_Submit);
		
		JButton btnShow_Completed_Orders = new JButton("Orders finished");
		btnShow_Completed_Orders.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnShow_Completed_Orders.setBackground(new Color(191, 244, 255));
		btnShow_Completed_Orders.setBounds(557, 79, 111, 23);
		panel_History.add(btnShow_Completed_Orders);
		
		JButton btnShow_Orders_in_Progress = new JButton("Orders in progress");
		btnShow_Orders_in_Progress.setBackground(new Color(191, 244, 255));
		btnShow_Orders_in_Progress.setBounds(678, 79, 122, 23);
		panel_History.add(btnShow_Orders_in_Progress);
		
		JPanel panel_Manage = new JPanel();
		panel_Manage.setBackground(new Color(213, 167, 113));
		logo.addTab("Manage", null, panel_Manage, null);
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
		btnModify_Profile_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModify_Profile_1.setBackground(new Color(232, 250, 126));
		btnModify_Profile_1.setBounds(182, 372, 110, 23);
		panel_Manage.add(btnModify_Profile_1);
		
		JButton btnModidy_PassWord_1 = new JButton("Modidy PassWord");
		btnModidy_PassWord_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModidy_PassWord_1.setBackground(new Color(232, 250, 126));
		btnModidy_PassWord_1.setBounds(507, 372, 138, 23);
		panel_Manage.add(btnModidy_PassWord_1);
		
		JButton btnBlockAdmin = new JButton("Block / Unblock");
		btnBlockAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBlockAdmin.setBackground(new Color(191, 244, 255));
		btnBlockAdmin.setBounds(334, 315, 122, 23);
		panel_Manage.add(btnBlockAdmin);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setLabelFor(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\pc po\\Desktop\\Dev\\GRETTA\\eclipse\\ProjetNestiPart2\\doc\\annexe\\logo.jpg"));
		lblNewLabel_3.setBounds(758, 0, 70, 32);
		panel.add(lblNewLabel_3);
	}
}
