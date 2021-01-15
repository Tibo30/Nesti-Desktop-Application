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

	private JPasswordField Password;
	private JPasswordField NewPassword;
	private JPasswordField Conform_Password;
	private JPasswordField textField_Password;
	private JPasswordField textField_Conf_Password;

	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_Order;
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
		
		
		
		
		Panel panelHome = new Panel("panelHome");
		
		TabbedPane.addTab("Home", new ImageIcon(Frame.class.getResource("/assets/home.jpg")), panelHome, null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(-2, 5, 815, 420);
		Image img = new ImageIcon(Frame.class.getResource("/assets/NESTi2.jpg")).getImage();
        Image newimg = img.getScaledInstance( 815, 420, java.awt.Image.SCALE_SMOOTH);
        lblNewLabel.setIcon(new ImageIcon(newimg));
		panelHome.setLayout(null);
        
        Label lblNewLabel_2 = new Label("Joe Smith",10, 194, 790, 72);
        panelHome.add(lblNewLabel_2);
        
        Label lblNewLabel_1 = new Label("Welcome",10, 143, 790, 58);
        panelHome.add(lblNewLabel_1);
        
        
        lblNewLabel.setIcon(new ImageIcon(newimg));
		panelHome.add(lblNewLabel);
		TabbedPane.setBackgroundAt(0, new Color(213, 167, 113));

		JLabel lblLogo = new JLabel("");
		lblLogo.setLabelFor(lblLogo);
		lblLogo.setIcon(new ImageIcon("C:\\Users\\pc po\\Desktop\\Dev\\GRETTA\\eclipse\\ProjetNestiPart2\\doc\\annexe\\logo.jpg"));
		lblLogo.setBounds(758, 0, 70, 32);
		panel.add(lblLogo);
		
		
		
		
		
		/**
		 * Profil
		 */
		
		
		
		
		
		
		Panel panel_Profil = new Panel("panelProfile");
		
		FlowLayout flowLayout = (FlowLayout) panel_Profil.getLayout();
		
		TabbedPane.addTab("Profil", new ImageIcon(Frame.class.getResource("/assets/Profil.jpg")), panel_Profil, null);
		
		
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
		
		
		
		TextField tfProfilFirstname = new TextField("profilFirstname",175, 116, 160, 20);
		panel_Profil.add(tfProfilFirstname);
		
				
		TextField tfProfilLastname= new TextField("profilLastname", 175, 170, 160, 20);		
		panel_Profil.add(tfProfilLastname);
		
		
		TextField TfProfilUsername = new TextField("profilUsername", 175, 223, 160, 20);
		panel_Profil.add(TfProfilUsername);

		
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
		
		
		
		
		
		
		
		
		/**
		 * Supplier
		 */
		
		
		
		
		Panel panelSupplier = new Panel("panelSupplier");
		
		TabbedPane.addTab("Supplier", new ImageIcon(Frame.class.getResource("/assets/Supplier.jpg")), panelSupplier, null);
	
		
		Button btnLaunch_Supplier = new Button("Launch",531, 36, 86, 23);
		panelSupplier.add(btnLaunch_Supplier);
		
		Button btnBlockSupplier = new Button("Supplier_Block / Unblock",10, 87, 122, 23);
		panelSupplier.add(btnBlockSupplier);
		
		JButton btnNewButton = new JButton("+");
		btnNewButton.setBounds(471, 306, 50, 23);
		panelSupplier.add(btnNewButton);
		
		Button btnCreate = new Button("Supplier_Create",141, 387, 113, 32);
		panelSupplier.add(btnCreate);
		
		Button btnSupplier_Modify = new Button("Supplier_Modify",471, 387, 113, 32);
		panelSupplier.add(btnSupplier_Modify);
		
		Button btnDEL = new Button("DEL",699, 365, 62, 32);
		panelSupplier.add(btnDEL);
		
		Label lblSearch_Supplier = new Label("Search",125, 34, 95, 27);
		panelSupplier.add(lblSearch_Supplier);
		
		JComboBox list_Supplier = new JComboBox();
		list_Supplier.setBounds(182, 31, 339, 32);
		panelSupplier.add(list_Supplier);
		
		JComboBox list_Supplier_Product = new JComboBox();
		list_Supplier_Product.setBounds(26, 301, 184, 32);
		panelSupplier.add(list_Supplier_Product);
		
		
		
		TextField tfSupplierName = new TextField("supplierName", 26, 133, 86, 20);
		panelSupplier.add(tfSupplierName);
		
		
		TextField tfSupplierAdress = new TextField("supplierAdress", 141, 133, 213, 20);
		panelSupplier.add(tfSupplierAdress);
	
		
		
		TextField tfSupplierTown = new TextField ("supplierTown", 375, 133, 86, 20);
		panelSupplier.add(tfSupplierTown);
		
		
		TextField tfContactName = new TextField("contactName",26, 172, 86, 20);
		panelSupplier.add(tfContactName );

		TextField tfContactFirstname= new TextField("contactFirstname",168, 172, 86, 20);
		panelSupplier.add(tfContactFirstname);

		
		TextField tfContactTel= new  TextField("contactTel",299, 172, 86, 20);
		panelSupplier.add(tfContactTel);

		
		TextField tsProductPrice= new TextField("productPrice",268, 307, 86, 20);
		panelSupplier.add(tsProductPrice);
	
		
		TextField tfUnitProduct = new TextField("unitProduct",364, 307, 97, 20);
		panelSupplier.add(tfUnitProduct);
				
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(602, 133, 160, 227);
		panelSupplier.add(scrollPane_2);
		
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
		
		
		
		
		
		Panel panelOrder = new Panel("panelOrder");
		
		TabbedPane.addTab("Order", new ImageIcon(Frame.class.getResource("/assets/Order.jpg")), panelOrder, null);
		
		
		Button btnOrder_Add_Textfield = new Button("+",634, 182, 45, 23);
		panelOrder.add(btnOrder_Add_Textfield);
		
		Button btnOrder_Minus_Textfield = new Button("-",689, 182, 41, 23);
		panelOrder.add(btnOrder_Minus_Textfield);
		
		Button btnOder_Remove_Textfield = new Button("x",736, 182, 41, 23);
		panelOrder.add(btnOder_Remove_Textfield);
		
		Button btnLaunch_Order = new Button("Launch",568, 47, 86, 23);
		panelOrder.add(btnLaunch_Order);
		
		Button btnOrder_Add_Textfield_1 = new Button("+",414, 116, 50, 23);
		panelOrder.add(btnOrder_Add_Textfield_1);
		
		Button btnOrder_Submit = new Button("Order_Submit",330, 371, 113, 32);
		panelOrder.add(btnOrder_Submit);
		
		Button btnOrder_Modify = new Button("Order_Modify",154, 371, 113, 32);
		panelOrder.add(btnOrder_Modify);
		
		Button btnOrder_Create = new Button("Order_Create",496, 371, 113, 32);
		panelOrder.add(btnOrder_Create);
		
		Label lblSearch_Order = new Label("Search with order number",31, 36, 178, 45);
		panelOrder.add(lblSearch_Order);
		
		JComboBox list_Supplier_Order = new JComboBox();
		list_Supplier_Order.setBounds(50, 111, 158, 32);
		panelOrder.add(list_Supplier_Order);
		
		JComboBox list_Order = new JComboBox();
		list_Order.setBounds(219, 42, 339, 32);
		panelOrder.add(list_Order);
		
		JComboBox list_Product_Order = new JComboBox();
		list_Product_Order.setBounds(218, 111, 86, 32);
		panelOrder.add(list_Product_Order);
		
		JComboBox list_Packaging_Order = new JComboBox();
		list_Packaging_Order.setBounds(314, 111, 86, 32);
		panelOrder.add(list_Packaging_Order);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(50, 163, 574, 178);
		panelOrder.add(scrollPane_3);
		
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
		
		
		TextField tfOrderNumber= new TextField("orderNumber",50, 77, 86, 20);
		panelOrder.add(tfOrderNumber);
		
		TextField tfState= new TextField("state",685, 326, 86, 20);
		panelOrder.add(tfState);

		
		
		
		
		
		
		
		/**
		 * Article
		 */
		
		
		
		
		
		
		Panel panelArticle = new Panel("panelArticle");
	
		TabbedPane.addTab("Article", new ImageIcon(Frame.class.getResource("/assets/Article.jpg")), panelArticle, null);
		
		
		
		Button btnLaunch_Article = new Button("Launch",541, 36, 86, 23);

		panelArticle.add(btnLaunch_Article);
		
		Button btnArticle_Create = new Button("Article_Create",563, 371, 113, 32);
		panelArticle.add(btnArticle_Create);
		
		Button btnArticle_Modify = new Button("Article_Modify",177, 371, 113, 32);
		panelArticle.add(btnArticle_Modify);
		
		Button btnArticle_CreatDate = new Button("Creating Date",601, 179, 121, 23);
		panelArticle.add(btnArticle_CreatDate);
		
		Button btnArticle_UpdateDate = new Button("Update Date",601, 236, 121, 23);
		panelArticle.add(btnArticle_UpdateDate);
		

		Label lblSearch_Article = new Label("Search",135, 34, 95, 27);
		panelArticle.add(lblSearch_Article);
		
		JScrollPane scrollPane_Article = new JScrollPane();
		scrollPane_Article.setBounds(55, 158, 476, 172);
		panelArticle.add(scrollPane_Article);
		
		JComboBox list_Article = new JComboBox();
		list_Article.setBounds(192, 31, 339, 32);
		panelArticle.add(list_Article);
		
		JComboBox list_Unit_Article = new JComboBox();
		list_Unit_Article.setBounds(443, 90, 76, 32);
		panelArticle.add(list_Unit_Article);
		
		JComboBox list_Product_Article = new JComboBox();
		list_Product_Article.setBounds(282, 90, 86, 32);
		panelArticle.add(list_Product_Article);
	
		
		TextField tfArticle= new TextField("article",378, 90, 55, 32);
		panelArticle.add(tfArticle);
	
		TextField tfArticleName= new TextField("articleName",196, 90, 76, 32);
		panelArticle.add(tfArticleName);
		
		TextField tfArticleRef= new TextField("articleRef",39, 90, 109, 32);
		panelArticle.add(tfArticleRef);
		
		
		TextField tfPackaging =new TextField("packaging",528, 90, 76, 32);
		panelArticle.add(tfPackaging);
		
		
		TextField tfStock= new TextField("stock",621, 90, 55, 32);
		panelArticle.add(tfStock);
		
		
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
		
		
		
		
		
		
		
		
		Panel panelProduct = new Panel("panelProduct");
		
		TabbedPane.addTab("Product", new ImageIcon(Frame.class.getResource("/assets/Product.jpg")), panelProduct, null);


		Button btnProduct_Block = new Button("Block /Unblock selected Element",165, 374, 211, 45);
		panelProduct.add(btnProduct_Block);
		
		Button btnProduct_Save = new Button("Save",480, 374, 142, 45);
		panelProduct.add(btnProduct_Save);
		
		JButton btnLaunch_Product = new JButton("Launch");
		btnLaunch_Product.setBounds(548, 38, 85, 23);
		panelProduct.add(btnLaunch_Product);
		
		Button btnProduct_Add_Textfield = new Button("+",165, 161, 41, 23);
		panelProduct.add(btnProduct_Add_Textfield);
		
		Label lblSearch_Supplier_1 = new Label("Search",142, 36, 95, 27);
		panelProduct.add(lblSearch_Supplier_1);
		
		JComboBox list_Product_Unit = new JComboBox();
		list_Product_Unit.setBounds(26, 201, 180, 32);
		panelProduct.add(list_Product_Unit);
		
		JComboBox list_ingredient = new JComboBox();
		list_ingredient.setBounds(26, 109, 180, 32);
		panelProduct.add(list_ingredient);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setEnabled(false);
		scrollPane_1.setBounds(293, 109, 444, 180);
		panelProduct.add(scrollPane_1);
		
		TextField tfProductSearch = new TextField("productSearch",199, 33, 339, 32);
		panelProduct.add(tfProductSearch);
	

		TextField tfProduct = new TextField("product",26, 156, 180, 32);
		panelProduct.add(tfProduct);
		
		
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
		
		
		
		
		
		
		Panel panelHistory = new Panel("panelHistory");

		TabbedPane.addTab("History", new ImageIcon(Frame.class.getResource("/assets/History.jpg")), panelHistory, null);
	
		
		Button btnHistory_Submit = new Button("History_Submit",525, 381, 89, 23);
		panelHistory.add(btnHistory_Submit);
		
		Button btnShow_Completed_Orders = new Button("Orders placed",454, 79, 129, 23);
		panelHistory.add(btnShow_Completed_Orders);
		
		Button btnShow_Orders_in_Progress = new Button("Orders in progress",593, 79, 149, 23);
		panelHistory.add(btnShow_Orders_in_Progress);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(58, 141, 684, 178);
		panelHistory.add(scrollPane);
		
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
		
		
		
		
		
		
		
		Panel panelManage = new Panel("panelManager");

		TabbedPane.addTab("Manage", new ImageIcon(Frame.class.getResource("/assets/Manage.jpg")), panelManage, null);
	

		Button btnModify_Profile_1 = new Button("Manage_Modify_Profile",154, 372, 138, 47);
		panelManage.add(btnModify_Profile_1);
		
		Button btnModidy_PassWord_1 = new Button("Manage_Modify_PassWord",507, 372, 147, 47);
		panelManage.add(btnModidy_PassWord_1);
		
		Button btnBlockAdmin = new Button("Manage_Block / Unblock",324, 315, 147, 40);
		panelManage.add(btnBlockAdmin);
		
		Button btnLaunch = new Button("Launch",539, 48, 86, 23);
		panelManage.add(btnLaunch);
		
		Label lblSearch = new Label("Search",133, 46, 95, 27);

		panelManage.add(lblSearch);
		
		JComboBox list = new JComboBox();
		list.setBounds(190, 43, 339, 32);
		panelManage.add(list);
		
		
		TextField tfManageFirstname = new TextField("manageFirstname",59, 151, 160, 20);
		panelManage.add(tfManageFirstname);
		
		Label lblFirsName_1 = new Label("Firstname",59, 130, 160, 20);
		panelManage.add(lblFirsName_1);
		
		
		TextField tfManageLastname= new TextField ("manageLastname",59, 205, 160, 20);
		panelManage.add(tfManageLastname);
		
		Label lblLastName_1 = new Label("Lastname",57, 182, 162, 20);
		panelManage.add(lblLastName_1);
		
		Label lblUserName_1 = new Label("Username",58, 236, 161, 20);
		panelManage.add(lblUserName_1);
		
		TextField tfManageUsername= new TextField("",59, 258, 160, 20);
		panelManage.add(tfManageUsername);
		
		Label lblNPassword_1 = new Label("Password",584, 141, 138, 14);
		panelManage.add(lblNPassword_1);
		
		textField_Password = new JPasswordField();
		textField_Password.setBackground(new Color(255, 222, 173));
		textField_Password.setColumns(10);
		textField_Password.setBounds(584, 159, 138, 20);
		panelManage.add(textField_Password);
		
		Label lblConfirm_Password_1 = new Label("Confirm password",584, 190, 138, 14);
		panelManage.add(lblConfirm_Password_1);
		
		textField_Conf_Password = new JPasswordField();
		textField_Conf_Password.setBackground(new Color(255, 222, 173));
		textField_Conf_Password.setColumns(10);
		textField_Conf_Password.setBounds(584, 212, 138, 20);
		panelManage.add(textField_Conf_Password);
		
		
	}
}
