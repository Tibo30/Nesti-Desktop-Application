package view;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Dimension;

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
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Icon;
import javax.swing.JPasswordField;

//Test commit
public class Frame {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField UserName;
	private JPasswordField Password;
	private JPasswordField NewPassword;
	private JPasswordField Conform_Password;
	private JTextField textFieldFirstname;
	private JTextField textField_Lastname;
	private JTextField textField_Username;
	private JPasswordField textField_Password;
	private JPasswordField textField_Conf_Password;
	private JTextField textField_Supplier_Name;
	private JTextField textField_Supplier_Adress;
	private JTextField textField_Supplier_Town;
	private JTextField textField_Contact_Name;
	private JTextField textField_Contact_Fistname;
	private JTextField textField_Contact_tel;
	private JTextField textField_Product_Price;
	private JTextField textField_Unit_Product;
	private JTextField Product_textfiel;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_Order;
	private JTextField Order_Number;
	private JTextField txtState;
	private JTextField textField_Quantity_Article;
	private JTextField textField_Article_Name;
	private JTextField textField_Article_Ref;
	private JTextField textField_Packaging_Article;
	private JTextField textField_Stock_Article;
	private JTable table_3;

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
		panel.setBackground(new Color(  	66, 5, 5));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTabbedPane TabbedPane = new JTabbedPane(JTabbedPane.TOP);
		TabbedPane.setFont(new Font("Tahoma", Font.BOLD, 13));
		TabbedPane.setBackground(new Color(213, 167, 113));
		TabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		TabbedPane.setBounds(10, 11, 815, 458);
	
		panel.add(TabbedPane);
		
		
		
		
		/**
		 * Home
		 */
		
		
		
		
		JPanel panel_Home = new JPanel();
		
		panel_Home.setBackground(new Color(213, 167, 113));
		TabbedPane.addTab("Home", new ImageIcon(Frame.class.getResource("/assets/home.jpg")), panel_Home, null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(-2, 5, 815, 420);
		Image img = new ImageIcon(Frame.class.getResource("/assets/NESTi2.jpg")).getImage();
        Image newimg = img.getScaledInstance( 815, 420, java.awt.Image.SCALE_SMOOTH);
        lblNewLabel.setIcon(new ImageIcon(newimg));
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
		TabbedPane.setBackgroundAt(0, new Color(213, 167, 113));

		JLabel lblLogo = new JLabel("");
		lblLogo.setLabelFor(lblLogo);
		lblLogo.setIcon(new ImageIcon("C:\\Users\\pc po\\Desktop\\Dev\\GRETTA\\eclipse\\ProjetNestiPart2\\doc\\annexe\\logo.jpg"));
		lblLogo.setBounds(758, 0, 70, 32);
		panel.add(lblLogo);
		
		JPanel panel_Profil = new JPanel();
		
		
		
		
		/**
		 * Profil
		 */
		
		
		
		
		
		
		
		
		FlowLayout flowLayout = (FlowLayout) panel_Profil.getLayout();
		panel_Profil.setBackground(new Color(213, 167, 113));
		TabbedPane.addTab("Profil", new ImageIcon(Frame.class.getResource("/assets/Profil.jpg")), panel_Profil, null);
		panel_Profil.setLayout(null);
		
		FirstName = new JTextField();
		FirstName.setBackground(new Color(255, 222, 173));
		FirstName.setBounds(175, 116, 160, 20);
		panel_Profil.add(FirstName);
		FirstName.setColumns(10);
		
		LastName = new JTextField();
		LastName.setBackground(new Color(255, 222, 173));
		LastName.setBounds(175, 170, 160, 20);
		panel_Profil.add(LastName);
		LastName.setColumns(10);
		
		UserName = new JTextField();
		UserName.setBackground(new Color(255, 222, 173));
		UserName.setBounds(175, 223, 160, 20);
		panel_Profil.add(UserName);
		UserName.setColumns(10);
		
		Password = new JPasswordField();
		Password.setBackground(new Color(255, 222, 173));
		Password.setBounds(439, 113, 138, 20);
		panel_Profil.add(Password);
		Password.setColumns(10);
		
		NewPassword = new JPasswordField();
		NewPassword.setBackground(new Color(255, 222, 173));
		NewPassword.setBounds(439, 167, 138, 20);
		panel_Profil.add(NewPassword);
		NewPassword.setColumns(10);
		
		Conform_Password = new JPasswordField();
		Conform_Password.setBackground(new Color(255, 222, 173));
		Conform_Password.setBounds(439, 220, 138, 20);
		panel_Profil.add(Conform_Password);
		Conform_Password.setColumns(10);
		
		Button btnModify_Profile = new Button("Profil_Modify_Profile",175, 359, 125, 35);
		panel_Profil.add(btnModify_Profile);
		
		Button btnModidy_PassWord = new Button("Profil_Modify_Password",439, 371, 149, 35);
		panel_Profil.add(btnModidy_PassWord);
		
		Button btnSave_Password = new Button("Profil_Save_Password",439, 347, 149, 35);
		panel_Profil.add(btnSave_Password);
		
		JLabel lblFirstName = new JLabel("FirstName");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstName.setBounds(175, 95, 160, 20);
		panel_Profil.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("LastName");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(173, 147, 162, 20);
		panel_Profil.add(lblLastName);
		
		JLabel lblUserName = new JLabel("UserName");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setBounds(174, 201, 161, 20);
		panel_Profil.add(lblUserName);
		
		JLabel lblNPassword = new JLabel("Password");
		lblNPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNPassword.setBounds(439, 95, 138, 14);
		panel_Profil.add(lblNPassword);
		
		JLabel lblNewPassword = new JLabel("New password");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewPassword.setBounds(439, 142, 138, 22);
		panel_Profil.add(lblNewPassword);
		
		JLabel lblConfirm_Password = new JLabel("Confirm password");
		lblConfirm_Password.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConfirm_Password.setBounds(439, 198, 138, 14);
		panel_Profil.add(lblConfirm_Password);
		
		
		
		
		
		
		/**
		 * Supplier
		 */
		
		
		
		
		JPanel panel_Supplier = new JPanel();
		panel_Supplier.setBackground(new Color(213, 167, 113));
		TabbedPane.addTab("Supplier", new ImageIcon(Frame.class.getResource("/assets/Supplier.jpg")), panel_Supplier, null);
		panel_Supplier.setLayout(null);
		
		JLabel lblSearch_Supplier = new JLabel("Search");
		lblSearch_Supplier.setBounds(125, 34, 95, 27);
		panel_Supplier.add(lblSearch_Supplier);
		
		JComboBox list_Supplier = new JComboBox();
		list_Supplier.setBounds(182, 31, 339, 32);
		panel_Supplier.add(list_Supplier);
		
		JButton btnLaunch_Supplier = new JButton("Launch");
		btnLaunch_Supplier.setBounds(531, 36, 86, 23);
		panel_Supplier.add(btnLaunch_Supplier);
		
		Button btnBlockSupplier = new Button("Supplier_Block / Unblock",10, 87, 122, 23);
		panel_Supplier.add(btnBlockSupplier);
		
		textField_Supplier_Name = new JTextField();
		textField_Supplier_Name.setBackground(new Color(255, 222, 173));
		textField_Supplier_Name.setBounds(26, 133, 86, 20);
		panel_Supplier.add(textField_Supplier_Name);
		textField_Supplier_Name.setColumns(10);
		
		textField_Supplier_Adress = new JTextField();
		textField_Supplier_Adress.setBackground(new Color(255, 222, 173));
		textField_Supplier_Adress.setBounds(141, 133, 213, 20);
		panel_Supplier.add(textField_Supplier_Adress);
		textField_Supplier_Adress.setColumns(10);
		
		textField_Supplier_Town = new JTextField();
		textField_Supplier_Town.setBackground(new Color(255, 222, 173));
		textField_Supplier_Town.setBounds(375, 133, 86, 20);
		panel_Supplier.add(textField_Supplier_Town);
		textField_Supplier_Town.setColumns(10);
		
		textField_Contact_Name = new JTextField();
		textField_Contact_Name.setBackground(new Color(255, 222, 173));
		textField_Contact_Name.setBounds(26, 172, 86, 20);
		panel_Supplier.add(textField_Contact_Name);
		textField_Contact_Name.setColumns(10);
		
		textField_Contact_Fistname = new JTextField();
		textField_Contact_Fistname.setBackground(new Color(255, 222, 173));
		textField_Contact_Fistname.setBounds(168, 172, 86, 20);
		panel_Supplier.add(textField_Contact_Fistname);
		textField_Contact_Fistname.setColumns(10);
		
		textField_Contact_tel = new JTextField();
		textField_Contact_tel.setBackground(new Color(255, 222, 173));
		textField_Contact_tel.setBounds(299, 172, 86, 20);
		panel_Supplier.add(textField_Contact_tel);
		textField_Contact_tel.setColumns(10);
		
		JComboBox list_Supplier_Product = new JComboBox();
		list_Supplier_Product.setBounds(26, 301, 184, 32);
		panel_Supplier.add(list_Supplier_Product);
		
		textField_Product_Price = new JTextField();
		textField_Product_Price.setBackground(new Color(255, 222, 173));
		textField_Product_Price.setBounds(268, 307, 86, 20);
		panel_Supplier.add(textField_Product_Price);
		textField_Product_Price.setColumns(10);
		
		textField_Unit_Product = new JTextField();
		textField_Unit_Product.setBackground(new Color(255, 222, 173));
		textField_Unit_Product.setBounds(364, 307, 97, 20);
		panel_Supplier.add(textField_Unit_Product);
		textField_Unit_Product.setColumns(10);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setBounds(471, 306, 50, 23);
		panel_Supplier.add(btnNewButton);
		
		Button btnCreate = new Button("Supplier_Create",141, 387, 113, 32);
		panel_Supplier.add(btnCreate);
		
		Button btnSupplier_Modify = new Button("Supplier_Modify",471, 387, 113, 32);
		panel_Supplier.add(btnSupplier_Modify);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(602, 133, 160, 227);
		panel_Supplier.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setBackground(new Color(255, 222, 173));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"Product"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_2.setViewportView(table_2);
		
		JButton btnDEL = new JButton("DEL");
		btnDEL.setBackground(new Color(243,101,101));
		btnDEL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDEL.setBounds(699, 365, 62, 32);
		panel_Supplier.add(btnDEL);
		
		
		
		
		/**
		 * Order
		 */
		
		
		
		
		
		JPanel panel_Order = new JPanel();
		panel_Order.setBackground(new Color(213, 167, 113));
		TabbedPane.addTab("Order", new ImageIcon(Frame.class.getResource("/assets/Order.jpg")), panel_Order, null);
		panel_Order.setLayout(null);
		
		JLabel lblSearch_Order = new JLabel("Search with order number");
		lblSearch_Order.setBounds(60, 36, 149, 45);
		panel_Order.add(lblSearch_Order);
		
		JComboBox list_Order = new JComboBox();
		list_Order.setBounds(219, 42, 339, 32);
		panel_Order.add(list_Order);
		
		JButton btnLaunch_Order = new JButton("Launch");
		btnLaunch_Order.setBounds(568, 47, 86, 23);
		panel_Order.add(btnLaunch_Order);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(50, 163, 574, 178);
		panel_Order.add(scrollPane_3);
		
		table_Order = new JTable();
		table_Order.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Product", "Packaging", "Quantity", "Price"
			}
		));
		table_Order.setBackground(new Color(255, 222, 173));
		scrollPane_3.setViewportView(table_Order);
		
		JButton btnOrder_Add_Textfield = new JButton("+");
		btnOrder_Add_Textfield.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOrder_Add_Textfield.setBounds(634, 182, 45, 23);
		panel_Order.add(btnOrder_Add_Textfield);
		
		JButton btnOrder_Minus_Textfield = new JButton("-");
		btnOrder_Minus_Textfield.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOrder_Minus_Textfield.setBounds(689, 182, 41, 23);
		panel_Order.add(btnOrder_Minus_Textfield);
		
		JButton btnOder_Remove_Textfield = new JButton("x");
		btnOder_Remove_Textfield.setBackground(new Color(243, 101, 101));
		btnOder_Remove_Textfield.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOder_Remove_Textfield.setBounds(736, 182, 41, 23);
		panel_Order.add(btnOder_Remove_Textfield);
		
		JComboBox list_Supplier_Order = new JComboBox();
		list_Supplier_Order.setBounds(50, 111, 158, 32);
		panel_Order.add(list_Supplier_Order);
		
		Order_Number = new JTextField();
		Order_Number.setText("Order number");
		Order_Number.setBounds(50, 77, 86, 20);
		panel_Order.add(Order_Number);
		Order_Number.setColumns(10);
		
		JComboBox list_Product_Order = new JComboBox();
		list_Product_Order.setBounds(218, 111, 86, 32);
		panel_Order.add(list_Product_Order);
		
		JComboBox list_Packaging_Order = new JComboBox();
		list_Packaging_Order.setBounds(314, 111, 86, 32);
		panel_Order.add(list_Packaging_Order);
		
		JButton btnOrder_Add_Textfield_1 = new JButton("+");
		btnOrder_Add_Textfield_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOrder_Add_Textfield_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnOrder_Add_Textfield_1.setBounds(414, 116, 50, 23);
		panel_Order.add(btnOrder_Add_Textfield_1);
		
		Button btnOrder_Submit = new Button("Order_Submit",330, 371, 113, 32);
		panel_Order.add(btnOrder_Submit);
		
		Button btnOrder_Modify = new Button("Order_Modify",154, 371, 113, 32);
		panel_Order.add(btnOrder_Modify);
		
		Button btnOrder_Create = new Button("Create",496, 371, 113, 32);
		panel_Order.add(btnOrder_Create);
		
		txtState = new JTextField();
		txtState.setText("State");
		txtState.setBounds(685, 326, 86, 20);
		panel_Order.add(txtState);
		txtState.setColumns(10);
		
		
		
		
		
		
		
		/**
		 * Article
		 */
		
		
		
		
		
		
		JPanel panel_Article = new JPanel();
		panel_Article.setBackground(new Color(213, 167, 113));
		TabbedPane.addTab("Article", new ImageIcon(Frame.class.getResource("/assets/Article.jpg")), panel_Article, null);
		panel_Article.setLayout(null);
		
		JLabel lblSearch_Article = new JLabel("Search");
		lblSearch_Article.setBounds(135, 34, 95, 27);
		panel_Article.add(lblSearch_Article);
		
		JComboBox list_Article = new JComboBox();
		list_Article.setBounds(192, 31, 339, 32);
		panel_Article.add(list_Article);
		
		JButton btnLaunch_Article = new JButton("Launch");
		btnLaunch_Article.setBounds(541, 36, 86, 23);
		panel_Article.add(btnLaunch_Article);
		
		JComboBox list_Unit_Article = new JComboBox();
		list_Unit_Article.setBounds(443, 90, 76, 32);
		panel_Article.add(list_Unit_Article);
		
		JComboBox list_Product_Article = new JComboBox();
		list_Product_Article.setBounds(282, 90, 86, 32);
		panel_Article.add(list_Product_Article);
		
		textField_Quantity_Article = new JTextField();
		textField_Quantity_Article.setBounds(378, 90, 55, 32);
		panel_Article.add(textField_Quantity_Article);
		textField_Quantity_Article.setColumns(10);
		
		textField_Article_Name = new JTextField();
		textField_Article_Name.setColumns(10);
		textField_Article_Name.setBounds(196, 90, 76, 32);
		panel_Article.add(textField_Article_Name);
		
		textField_Article_Ref = new JTextField();
		textField_Article_Ref.setColumns(10);
		textField_Article_Ref.setBounds(39, 90, 109, 32);
		panel_Article.add(textField_Article_Ref);
		
		textField_Packaging_Article = new JTextField();
		textField_Packaging_Article.setColumns(10);
		textField_Packaging_Article.setBounds(528, 90, 76, 32);
		panel_Article.add(textField_Packaging_Article);
		
		textField_Stock_Article = new JTextField();
		textField_Stock_Article.setColumns(10);
		textField_Stock_Article.setBounds(621, 90, 55, 32);
		panel_Article.add(textField_Stock_Article);
		
		Button btnArticle_Create = new Button("Article_Create",563, 371, 113, 32);
		panel_Article.add(btnArticle_Create);
		
		Button btnArticle_Modify = new Button("Article_Modify",177, 371, 113, 32);
		panel_Article.add(btnArticle_Modify);
		
		Button btnArticle_CreatDate = new Button("Creating Date",601, 179, 121, 23);
		panel_Article.add(btnArticle_CreatDate);
		
		Button btnArticle_UpdateDate = new Button("Update Date",601, 236, 121, 23);
		panel_Article.add(btnArticle_UpdateDate);
		
		JScrollPane scrollPane_Article = new JScrollPane();
		scrollPane_Article.setBounds(55, 158, 476, 172);
		panel_Article.add(scrollPane_Article);
		
		table_3 = new JTable();
		table_3.setBackground(new Color(255, 222, 173));
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Supplier", "Price/Unit", "Article Price"
			}
		));
		scrollPane_Article.setViewportView(table_3);
		
		
		
		
		
		
		
		
		/**
		 * Product
		 */
		
		
		
		
		
		
		
		
		JPanel panel_Product = new JPanel();
		panel_Product.setBackground(new Color(213, 167, 113));
		TabbedPane.addTab("Product", new ImageIcon(Frame.class.getResource("/assets/Product.jpg")), panel_Product, null);
		panel_Product.setLayout(null);
		
		JLabel lblSearch_Supplier_1 = new JLabel("Search");
		lblSearch_Supplier_1.setBounds(142, 36, 95, 27);
		panel_Product.add(lblSearch_Supplier_1);
		
		JTextField list_Product_search = new JTextField();
		list_Product_search.setBackground(new Color(255, 222, 173));
		list_Product_search.setBounds(199, 33, 339, 32);
		panel_Product.add(list_Product_search);
		
		JButton btnLaunch_Product = new JButton("Launch");
		btnLaunch_Product.setBounds(548, 38, 85, 23);
		panel_Product.add(btnLaunch_Product);
		
		JComboBox list_ingredient = new JComboBox();
		list_ingredient.setBounds(26, 109, 180, 32);
		panel_Product.add(list_ingredient);
		
		JButton btnProduct_Add_Textfield = new JButton("+");
		btnProduct_Add_Textfield.setBounds(165, 161, 41, 23);
		panel_Product.add(btnProduct_Add_Textfield);
		
		Product_textfiel = new JTextField();
		Product_textfiel.setBackground(new Color(255, 222, 173));
		Product_textfiel.setBounds(26, 156, 180, 32);
		panel_Product.add(Product_textfiel);
		Product_textfiel.setColumns(10);
		
		JComboBox list_Product_Unit = new JComboBox();
		list_Product_Unit.setBounds(26, 201, 180, 32);
		panel_Product.add(list_Product_Unit);
		
		Button btnProduct_Block = new Button("Block /Unblock selected Element",165, 374, 211, 45);
		panel_Product.add(btnProduct_Block);
		
		Button btnProduct_Save = new Button("Save",480, 374, 142, 45);
		panel_Product.add(btnProduct_Save);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(293, 109, 444, 180);
		panel_Product.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setShowHorizontalLines(false);
		table_1.setBackground(new Color(255, 222, 173));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"", null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"Product", "Nb Articles"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * History
		 */
		
		
		
		
		
		
		JPanel panel_History = new JPanel();
		panel_History.setBackground(new Color(213, 167, 113));
		TabbedPane.addTab("History", new ImageIcon(Frame.class.getResource("/assets/History.jpg")), panel_History, null);
		panel_History.setLayout(null);
		
		Button btnHistory_Submit = new Button("History_Submit",525, 381, 89, 23);
		panel_History.add(btnHistory_Submit);
		
		Button btnShow_Completed_Orders = new Button("Orders placed",454, 79, 129, 23);
		panel_History.add(btnShow_Completed_Orders);
		
		Button btnShow_Orders_in_Progress = new Button("Orders in progress",593, 79, 149, 23);
		panel_History.add(btnShow_Orders_in_Progress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(58, 141, 684, 178);
		panel_History.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(255, 222, 173));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Order", "Delivery date", "Validation date", "State"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(2).setPreferredWidth(106);
		scrollPane.setViewportView(table);
		
		
		
		
		
		
		
		
		
		/**
		 * Manage
		 */
		
		
		
		
		
		
		
		JPanel panel_Manage = new JPanel();
		panel_Manage.setBackground(new Color(213, 167, 113));
		TabbedPane.addTab("Manage", new ImageIcon(Frame.class.getResource("/assets/Manage.jpg")), panel_Manage, null);
		panel_Manage.setLayout(null);
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setBounds(133, 46, 95, 27);
		panel_Manage.add(lblSearch);
		
		JComboBox list = new JComboBox();
		list.setBounds(190, 43, 339, 32);
		panel_Manage.add(list);
		
		JButton btnLaunch = new JButton("Launch");
		btnLaunch.setBounds(539, 48, 86, 23);
		panel_Manage.add(btnLaunch);
		
		textFieldFirstname = new JTextField();
		textFieldFirstname.setBackground(new Color(255, 222, 173));
		textFieldFirstname.setColumns(10);
		textFieldFirstname.setBounds(59, 151, 160, 20);
		panel_Manage.add(textFieldFirstname);
		
		JLabel lblFirsName_1 = new JLabel("Firstname");
		lblFirsName_1.setBounds(59, 130, 160, 20);
		panel_Manage.add(lblFirsName_1);
		
		textField_Lastname = new JTextField();
		textField_Lastname.setBackground(new Color(255, 222, 173));
		textField_Lastname.setColumns(10);
		textField_Lastname.setBounds(59, 205, 160, 20);
		panel_Manage.add(textField_Lastname);
		
		JLabel lblLastName_1 = new JLabel("Lastname");
		lblLastName_1.setBounds(57, 182, 162, 20);
		panel_Manage.add(lblLastName_1);
		
		JLabel lblUserName_1 = new JLabel("Username");
		lblUserName_1.setBounds(58, 236, 161, 20);
		panel_Manage.add(lblUserName_1);
		
		textField_Username = new JTextField();
		textField_Username.setBackground(new Color(255, 222, 173));
		textField_Username.setColumns(10);
		textField_Username.setBounds(59, 258, 160, 20);
		panel_Manage.add(textField_Username);
		
		JLabel lblNPassword_1 = new JLabel("Password");
		lblNPassword_1.setBounds(584, 141, 138, 14);
		panel_Manage.add(lblNPassword_1);
		
		textField_Password = new JPasswordField();
		textField_Password.setBackground(new Color(255, 222, 173));
		textField_Password.setColumns(10);
		textField_Password.setBounds(584, 159, 138, 20);
		panel_Manage.add(textField_Password);
		
		JLabel lblConfirm_Password_1 = new JLabel("Confirm password");
		lblConfirm_Password_1.setBounds(584, 190, 138, 14);
		panel_Manage.add(lblConfirm_Password_1);
		
		textField_Conf_Password = new JPasswordField();
		textField_Conf_Password.setBackground(new Color(255, 222, 173));
		textField_Conf_Password.setColumns(10);
		textField_Conf_Password.setBounds(584, 212, 138, 20);
		panel_Manage.add(textField_Conf_Password);
		
		Button btnModify_Profile_1 = new Button("Manage_Modify_Profile",154, 372, 138, 47);
		panel_Manage.add(btnModify_Profile_1);
		
		Button btnModidy_PassWord_1 = new Button("Manage_Modify_PassWord",507, 372, 147, 47);
		panel_Manage.add(btnModidy_PassWord_1);
		
		Button btnBlockAdmin = new Button("Manage_Block / Unblock",324, 315, 147, 40);
		panel_Manage.add(btnBlockAdmin);
		
	}
}
