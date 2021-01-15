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
	private JPasswordField Profil_Password;
	private JPasswordField Profil_NewPassword;
	private JPasswordField Profil_Conform_Password;
	private JTextField textFieldFirstname;
	private JTextField textField_Lastname;
	private JTextField textField_Username;
	private JPasswordField Manage_Password;
	private JPasswordField Manage_Conf_Password;
	private JTextField textField_Supplier_Name;
	private JTextField textField_Supplier_Adress;
	private JTextField textField_Supplier_Town;
	private JTextField textField_Contact_Name;
	private JTextField textField_Contact_Fistname;
	private JTextField textField_Contact_phone;
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
        
        Label lblNewLabel_2 = new Label("Joe Smith",10, 194, 790, 72);
        panel_Home.add(lblNewLabel_2);
        
        Label lblNewLabel_1 = new Label("Welcome",10, 143, 790, 58);
        panel_Home.add(lblNewLabel_1);
        
        
        lblNewLabel.setIcon(new ImageIcon(newimg));
		panel_Home.add(lblNewLabel);
		TabbedPane.setBackgroundAt(0, new Color(213, 167, 113));

		JLabel lblLogo = new JLabel("");
		lblLogo.setLabelFor(lblLogo);
		lblLogo.setIcon(new ImageIcon("C:\\Users\\pc po\\Desktop\\Dev\\GRETTA\\eclipse\\ProjetNestiPart2\\doc\\annexe\\logo.jpg"));
		lblLogo.setBounds(758, 0, 70, 32);
		panel.add(lblLogo);
		
		
		
		
		
		/**
		 * Profil
		 */
		
		
		
		
		
		
		JPanel panel_Profil = new JPanel();
		
		FlowLayout flowLayout = (FlowLayout) panel_Profil.getLayout();
		panel_Profil.setBackground(new Color(213, 167, 113));
		TabbedPane.addTab("Profil", new ImageIcon(Frame.class.getResource("/assets/Profil.jpg")), panel_Profil, null);
		panel_Profil.setLayout(null);
		
		Button btnModify_Profile = new Button("Profil_Modify_Profile",175, 359, 125, 35);
		panel_Profil.add(btnModify_Profile);
		
		Button btnModidy_PassWord = new Button("Profil_Modify_Password",439, 371, 149, 35);
		panel_Profil.add(btnModidy_PassWord);
		
		Button btnSave_Password = new Button("Profil_Save_Password",439, 347, 149, 35);
		panel_Profil.add(btnSave_Password);
		
		Label lblFirstName = new Label("FirstName",175, 95, 160, 20);
		panel_Profil.add(lblFirstName);
		
		Label lblLastName = new Label("LastName",173, 147, 162, 20);
		panel_Profil.add(lblLastName);
		
		Label lblUserName = new Label("UserName",174, 201, 161, 20);
		panel_Profil.add(lblUserName);
		
		Label lblNPassword = new Label("Password",439, 95, 138, 14);
		panel_Profil.add(lblNPassword);
		
		Label lblNewPassword = new Label("New password",439, 142, 138, 22);
		panel_Profil.add(lblNewPassword);
		
		Label lblConfirm_Password = new Label("Confirm password",439, 198, 138, 14);
		panel_Profil.add(lblConfirm_Password);
		
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
		
		Profil_Password = new PasswordField("Profil Password",439, 113, 138, 20);
		panel_Profil.add(Profil_Password);
		
		Profil_NewPassword = new PasswordField("Profil NewPassword",439, 167, 138, 20);	
		panel_Profil.add(Profil_NewPassword);

		
		Profil_Conform_Password = new PasswordField("Profil Conform Password",439, 220, 138, 20);
		panel_Profil.add(Profil_Conform_Password);

		
		
		
		
		
		
		
		
		/**
		 * Supplier
		 */
		
		
		
		
		JPanel panel_Supplier = new JPanel();
		panel_Supplier.setBackground(new Color(213, 167, 113));
		TabbedPane.addTab("Supplier", new ImageIcon(Frame.class.getResource("/assets/Supplier.jpg")), panel_Supplier, null);
		panel_Supplier.setLayout(null);
		
		Button btnLaunch_Supplier = new Button("Launch",531, 36, 86, 23);
		panel_Supplier.add(btnLaunch_Supplier);
		
		Button btnBlockSupplier = new Button("Supplier_Block / Unblock",10, 72, 122, 23);
		panel_Supplier.add(btnBlockSupplier);
		
		Button btnNewButton = new Button("+",471, 306, 50, 23);
		panel_Supplier.add(btnNewButton);
		
		Button btnCreate = new Button("Supplier_Create",141, 365, 113, 32);
		panel_Supplier.add(btnCreate);
		
		Button btnSupplier_Modify = new Button("Supplier_Modify",471, 365, 113, 32);
		panel_Supplier.add(btnSupplier_Modify);
		
		Button btnDEL = new Button("DEL",699, 365, 62, 32);
		panel_Supplier.add(btnDEL);
		
		Label lblSearch_Supplier = new Label("Search",125, 34, 95, 27);
		panel_Supplier.add(lblSearch_Supplier);
		
		Label lblSupplier_Name = new Label("Supplier Name",20, 108, 92, 14);
		panel_Supplier.add(lblSupplier_Name);
		
		Label lblSupplier_Adress = new Label("Supplier Adress",141, 108, 199, 14);
		panel_Supplier.add(lblSupplier_Adress);
		
		Label lblSupplier_Town = new Label("Supplier Town",376, 108, 85, 14);
		panel_Supplier.add(lblSupplier_Town);
		
		Label lblContact_Name = new Label("Contact Name",26, 164, 86, 14);
		panel_Supplier.add(lblContact_Name);
		
		Label lblContact_Fistname = new Label("Contact Fistname",177, 161, 127, 14);
		panel_Supplier.add(lblContact_Fistname);
		
		Label lblContact_phone = new Label("Contact phone",347, 161, 91, 14);
		panel_Supplier.add(lblContact_phone);
		
		Label lblProduct_Price = new Label("Product Price",267, 282, 87, 14);
		panel_Supplier.add(lblProduct_Price);
		
		Label lblUnit_Product = new Label("Unit Product",364, 282, 97, 14);
		panel_Supplier.add(lblUnit_Product);
		
		Label lblSupplier_Product = new Label("Supplier Product",26, 276, 106, 14);
		panel_Supplier.add(lblSupplier_Product);
		
		
		ComboBox list_Supplier = new ComboBox(182, 31, 339, 32);
		panel_Supplier.add(list_Supplier);
		
		ComboBox list_Supplier_Product = new ComboBox(26, 301, 184, 32);
		panel_Supplier.add(list_Supplier_Product);
		
		
		
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
		textField_Contact_Name.setBounds(26, 186, 122, 20);
		panel_Supplier.add(textField_Contact_Name);
		textField_Contact_Name.setColumns(10);
		
		textField_Contact_Fistname = new JTextField();
		textField_Contact_Fistname.setBackground(new Color(255, 222, 173));
		textField_Contact_Fistname.setBounds(177, 186, 137, 20);
		panel_Supplier.add(textField_Contact_Fistname);
		textField_Contact_Fistname.setColumns(10);
		
		textField_Contact_phone = new JTextField();
		textField_Contact_phone.setBackground(new Color(255, 222, 173));
		textField_Contact_phone.setBounds(352, 186, 86, 20);
		panel_Supplier.add(textField_Contact_phone);
		textField_Contact_phone.setColumns(10);
		
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
		
		
		
		
		
		
		/**
		 * Order
		 */
		
		
		
		
		
		JPanel panel_Order = new JPanel();
		panel_Order.setBackground(new Color(213, 167, 113));
		TabbedPane.addTab("Order", new ImageIcon(Frame.class.getResource("/assets/Order.jpg")), panel_Order, null);
		panel_Order.setLayout(null);
		
		Button btnOrder_Add_Textfield = new Button("+",634, 182, 45, 23);
		panel_Order.add(btnOrder_Add_Textfield);
		
		Button btnOrder_Minus_Textfield = new Button("-",689, 182, 41, 23);
		panel_Order.add(btnOrder_Minus_Textfield);
		
		Button btnOder_Remove_Textfield = new Button("x",736, 182, 41, 23);
		panel_Order.add(btnOder_Remove_Textfield);
		
		Button btnLaunch_Order = new Button("Launch",568, 47, 86, 23);
		panel_Order.add(btnLaunch_Order);
		
		Button btnOrder_Add_Textfield_1 = new Button("+",414, 116, 50, 23);
		panel_Order.add(btnOrder_Add_Textfield_1);
		
		Button btnOrder_Submit = new Button("Order_Submit",330, 371, 113, 32);
		panel_Order.add(btnOrder_Submit);
		
		Button btnOrder_Modify = new Button("Order_Modify",154, 371, 113, 32);
		panel_Order.add(btnOrder_Modify);
		
		Button btnOrder_Create = new Button("Order_Create",496, 371, 113, 32);
		panel_Order.add(btnOrder_Create);
		
		Label lblSearch_Order = new Label("Search with order number",31, 36, 178, 45);
		panel_Order.add(lblSearch_Order);
		
		Label lblSupplier_Order = new Label("Supplier Order",50, 92, 159, 22);
		panel_Order.add(lblSupplier_Order);
		
		Label lblProduct_Order = new Label("Product Order",218, 91, 86, 23);
		panel_Order.add(lblProduct_Order);
		
		Label lblPackaging_Order = new Label("Packaging Order",314, 89, 113, 29);
		panel_Order.add(lblPackaging_Order);
		
		ComboBox list_Supplier_Order = new ComboBox(50, 111, 158, 32);
		panel_Order.add(list_Supplier_Order);
		
		ComboBox list_Order = new ComboBox(219, 42, 339, 32);
		panel_Order.add(list_Order);
		
		ComboBox list_Product_Order = new ComboBox(218, 111, 86, 32);
		panel_Order.add(list_Product_Order);
		
		ComboBox list_Packaging_Order = new ComboBox(314, 111, 86, 32);
		panel_Order.add(list_Packaging_Order);
		
		ComboBox list_of_State = new ComboBox(686, 291, 84, 22);
		list_of_State.setMaximumRowCount(4);
		panel_Order.add(list_of_State);
		
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
		
		
		Order_Number = new JTextField();
		Order_Number.setText("Order number");
		Order_Number.setBounds(41, 73, 86, 20);
		panel_Order.add(Order_Number);
		Order_Number.setColumns(10);
		
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
		
		
		Button btnLaunch_Article = new Button("Launch",541, 36, 86, 23);
		panel_Article.add(btnLaunch_Article);
		
		Button btnArticle_Create = new Button("Article_Create",563, 371, 113, 32);
		panel_Article.add(btnArticle_Create);
		
		Button btnArticle_Modify = new Button("Article_Modify",177, 371, 113, 32);
		panel_Article.add(btnArticle_Modify);
		
		Button btnArticle_CreatDate = new Button("Creating Date",601, 179, 121, 23);
		panel_Article.add(btnArticle_CreatDate);
		
		Button btnArticle_UpdateDate = new Button("Update Date",601, 236, 121, 23);
		panel_Article.add(btnArticle_UpdateDate);


		Label lblSearch_Article = new Label("Search",135, 34, 95, 27);
		panel_Article.add(lblSearch_Article);

		Label lblArticle_Ref = new Label("Article Ref",39, 70, 109, 14);
		panel_Article.add(lblArticle_Ref);
		
		Label lblArticle_Name = new Label("Article Name",192, 72, 80, 14);
		panel_Article.add(lblArticle_Name);
		
		Label lblProduct_Article = new Label("Product Article",282, 70, 86, 14);
		panel_Article.add(lblProduct_Article);
		
		Label lblQuantity_Article = new Label("Quantity Article",378, 70, 101, 14);
		panel_Article.add(lblQuantity_Article);
		
		Label lblUnit_Article = new Label("Unit Article",489, 70, 76, 14);
		panel_Article.add(lblUnit_Article);
		
		Label lblPackaging_Article = new Label("Packaging Article",574, 70, 102, 14);
		panel_Article.add(lblPackaging_Article);
		
		Label lblStock_Article = new Label("Stock Article",697, 70, 86, 14);
		panel_Article.add(lblStock_Article);
		
		JScrollPane scrollPane_Article = new JScrollPane();
		scrollPane_Article.setBounds(55, 158, 476, 172);
		panel_Article.add(scrollPane_Article);
		
		ComboBox list_Article = new ComboBox(192, 31, 339, 32);
		panel_Article.add(list_Article);
		
		ComboBox list_Unit_Article = new ComboBox(489, 90, 76, 32);
		panel_Article.add(list_Unit_Article);
		
		ComboBox list_Product_Article = new ComboBox(282, 90, 86, 32);
		panel_Article.add(list_Product_Article);
		
		textField_Quantity_Article = new JTextField();
		textField_Quantity_Article.setBounds(388, 90, 76, 32);
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
		textField_Packaging_Article.setBounds(574, 90, 102, 32);
		panel_Article.add(textField_Packaging_Article);
		
		textField_Stock_Article = new JTextField();
		textField_Stock_Article.setColumns(10);
		textField_Stock_Article.setBounds(697, 90, 69, 32);
		panel_Article.add(textField_Stock_Article);
		
		
		table_3 = new JTable();
		table_3.setBackground(new Color(255, 222, 173));
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
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

		Button btnProduct_Block = new Button("Block /Unblock selected Element",166, 368, 211, 30);
		panel_Product.add(btnProduct_Block);
		
		Button btnProduct_Save = new Button("Save",505, 366, 99, 29);
		panel_Product.add(btnProduct_Save);
		
		Button btnLaunch_Product = new Button("Launch",548, 38, 85, 23);
		panel_Product.add(btnLaunch_Product);
		
		Button btnProduct_Add_Textfield = new Button("+",165, 161, 41, 23);
		panel_Product.add(btnProduct_Add_Textfield);
		
		Label lblSearch_Supplier_1 = new Label("Search",142, 36, 95, 27);
		panel_Product.add(lblSearch_Supplier_1);
		
		Label lblIngredient = new Label("Ingredient",31, 84, 121, 14);
		panel_Product.add(lblIngredient);
		
		Label lblProduct_Unit = new Label("Product Unit",26, 199, 78, 14);
		panel_Product.add(lblProduct_Unit);
		
		ComboBox list_Product_Unit = new ComboBox(26, 217, 180, 32);
		panel_Product.add(list_Product_Unit);
		
		ComboBox list_ingredient = new ComboBox(26, 109, 180, 32);
		panel_Product.add(list_ingredient);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(293, 109, 444, 180);
		panel_Product.add(scrollPane_1);
		
		JTextField list_Product_search = new JTextField();
		list_Product_search.setBackground(new Color(255, 222, 173));
		list_Product_search.setBounds(199, 33, 339, 32);
		panel_Product.add(list_Product_search);
	

		Product_textfiel = new JTextField();
		Product_textfiel.setBackground(new Color(255, 222, 173));
		Product_textfiel.setBounds(26, 156, 180, 32);
		panel_Product.add(Product_textfiel);
		Product_textfiel.setColumns(10);
		
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

		Button btnModify_Profile_1 = new Button("Manage_Modify_Profile",154, 372, 138, 29);
		panel_Manage.add(btnModify_Profile_1);
		
		Button btnModidy_PassWord_1 = new Button("Manage_Modify_PassWord",507, 372, 147, 34);
		panel_Manage.add(btnModidy_PassWord_1);
		
		Button btnBlockAdmin = new Button("Manage_Block / Unblock",324, 315, 147, 29);
		panel_Manage.add(btnBlockAdmin);
		
		Button btnLaunch = new Button("Launch",539, 48, 86, 23);
		panel_Manage.add(btnLaunch);
		
		Label lblSearch = new Label("Search",133, 46, 95, 27);
		panel_Manage.add(lblSearch);
		
		ComboBox list = new ComboBox(190, 43, 339, 32);
		panel_Manage.add(list);
		
		
		
		textFieldFirstname = new JTextField();
		textFieldFirstname.setBackground(new Color(255, 222, 173));
		textFieldFirstname.setColumns(10);
		textFieldFirstname.setBounds(59, 151, 160, 20);
		panel_Manage.add(textFieldFirstname);
		
		Label lblFirsName_1 = new Label("Firstname",59, 130, 160, 20);
		panel_Manage.add(lblFirsName_1);
		
		textField_Lastname = new JTextField();
		textField_Lastname.setBackground(new Color(255, 222, 173));
		textField_Lastname.setColumns(10);
		textField_Lastname.setBounds(59, 205, 160, 20);
		panel_Manage.add(textField_Lastname);
		
		Label lblLastName_1 = new Label("Lastname",57, 182, 162, 20);
		panel_Manage.add(lblLastName_1);
		
		Label lblUserName_1 = new Label("Username",58, 236, 161, 20);
		panel_Manage.add(lblUserName_1);
		
		textField_Username = new JTextField();
		textField_Username.setBackground(new Color(255, 222, 173));
		textField_Username.setColumns(10);
		textField_Username.setBounds(59, 258, 160, 20);
		panel_Manage.add(textField_Username);
		
		Label lblNPassword_1 = new Label("Password",584, 141, 138, 14);
		panel_Manage.add(lblNPassword_1);
		
		Manage_Password = new PasswordField("Manage Password",584, 159, 138, 20);
		panel_Manage.add(Manage_Password);
		
		Label lblConfirm_Password_1 = new Label("Confirm password",584, 190, 138, 14);
		panel_Manage.add(lblConfirm_Password_1);
		
		Manage_Conf_Password = new PasswordField("Manage Conf Password",584, 212, 138, 20);
		panel_Manage.add(Manage_Conf_Password);
		
		
	}
}
