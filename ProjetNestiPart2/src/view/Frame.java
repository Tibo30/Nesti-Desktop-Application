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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import model.QuerySupplier;

import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Icon;
import javax.swing.JPasswordField;

//Test commit
public class Frame {

	private JFrame frame;
	private final JPanel panel = new JPanel();

	private JTable table;
	private JTable table_1;
	
	private JTable table_Order;
	private JTable table_3;
	
	public static ValueNeededProduct prod;
	public static ValueNeededAdmin adm;

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
	 * 
	 * @throws Exception
	 */
	public Frame() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 854, 526);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setBackground(new Color(66, 5, 5));
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
		Image newimg = img.getScaledInstance(815, 420, java.awt.Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(newimg));

		Label lblNewLabel_2 = new Label("Joe Smith", 10, 194, 790, 72);
		panelHome.add(lblNewLabel_2);

		Label lblNewLabel_1 = new Label("Welcome", 10, 143, 790, 58);
		panelHome.add(lblNewLabel_1);

		lblNewLabel.setIcon(new ImageIcon(newimg));
		panelHome.add(lblNewLabel);
		TabbedPane.setBackgroundAt(0, new Color(213, 167, 113));

		JLabel lblLogo = new JLabel("");
        lblLogo.setLabelFor(lblLogo);
        lblLogo.setIcon(new ImageIcon(Frame.class.getResource("/assets/logo.jpg")));
        lblLogo.setBounds(758, 0, 70, 32);
        panel.add(lblLogo);

		/**
		 * Profil
		 */

		Panel panel_Profil = new Panel("panelProfile");

		FlowLayout flowLayout = (FlowLayout) panel_Profil.getLayout();

		TabbedPane.addTab("Profil", new ImageIcon(Frame.class.getResource("/assets/Profil.jpg")), panel_Profil, null);
		panel_Profil.setLayout(null);

		Button btnProfilModifyProfile = new Button("Profil_Modify_Profile", 175, 359, 125, 35);
		panel_Profil.add(btnProfilModifyProfile);

		Button btnProfilModidyPassWord = new Button("Profil_Modify_Password", 439, 371, 149, 35);
		panel_Profil.add(btnProfilModidyPassWord);

		Button btnProfilSavePassword = new Button("Profil_Save_Password", 439, 347, 149, 35);
		panel_Profil.add(btnProfilSavePassword);

		Button btnProfilSaveProfil = new Button("Profil_Save_Profil", 175, 347, 125, 35);
		panel_Profil.add(btnProfilSaveProfil);

		Label lblProfilFirstname = new Label("FirstName", 175, 95, 160, 20);
		panel_Profil.add(lblProfilFirstname);

		Label lblProfilLastname = new Label("LastName", 173, 147, 162, 20);
		panel_Profil.add(lblProfilLastname);

		Label lblProfilUsername = new Label("UserName", 174, 201, 161, 20);
		panel_Profil.add(lblProfilUsername);

		Label lblProfilPassword = new Label("Password", 439, 95, 138, 14);
		panel_Profil.add(lblProfilPassword);

		Label lblProfilNewPassword = new Label("New password", 439, 142, 138, 22);
		panel_Profil.add(lblProfilNewPassword);

		Label lblProfilConfirmPassword = new Label("Confirm password", 439, 198, 138, 14);
		panel_Profil.add(lblProfilConfirmPassword);

		TextField tfProfilFirstname = new TextField("profilFirstname", 175, 116, 160, 20);
		panel_Profil.add(tfProfilFirstname);

		TextField tfProfilLastname = new TextField("profilLastname", 175, 170, 160, 20);
		panel_Profil.add(tfProfilLastname);

		TextField TfProfilUsername = new TextField("profilUsername", 175, 223, 160, 20);
		panel_Profil.add(TfProfilUsername);

		PasswordField profilPassword = new PasswordField("Profil Password", 439, 113, 138, 20);
		panel_Profil.add(profilPassword);

		PasswordField profilNewPassword = new PasswordField("Profil NewPassword", 439, 167, 138, 20);
		panel_Profil.add(profilNewPassword);

		PasswordField profilConfirmPassword = new PasswordField("Profil Conform Password", 439, 220, 138, 20);
		panel_Profil.add(profilConfirmPassword);

		/**
		 * Supplier
		 */

		SupplierPanel panelSupplier = new SupplierPanel();

		TabbedPane.addTab("Supplier", new ImageIcon(Frame.class.getResource("/assets/Supplier.jpg")), panelSupplier,
				null);
		
		
		/**
		 * Order
		 */

		Panel panelOrder = new Panel("panelOrder");

		TabbedPane.addTab("Order", new ImageIcon(Frame.class.getResource("/assets/Order.jpg")), panelOrder, null);
		panelOrder.setLayout(null);

		Button btnOrderAddTextfield = new Button("+_Order1", 634, 182, 45, 23);
		panelOrder.add(btnOrderAddTextfield);

		Button btnOrderMinusTextfield = new Button("-_Order", 689, 182, 41, 23);
		panelOrder.add(btnOrderMinusTextfield);

		Button btnOderRemoveTextfield = new Button("x_Order", 736, 182, 41, 23);
		panelOrder.add(btnOderRemoveTextfield);

		Button btnOrderLaunch = new Button("Order_Launch", 568, 47, 86, 23);
		panelOrder.add(btnOrderLaunch);

		Button btnOrderAddTextfield2 = new Button("+_Order2", 414, 116, 50, 23);
		panelOrder.add(btnOrderAddTextfield2);

		Button btnOrderSubmit = new Button("Order_Submit", 330, 371, 113, 32);
		panelOrder.add(btnOrderSubmit);

		Button btnOrderModify = new Button("Order_Modify", 154, 371, 113, 32);
		panelOrder.add(btnOrderModify);

		Button btnOrderCreate = new Button("Order_Create", 496, 371, 113, 32);
		panelOrder.add(btnOrderCreate);

		Label lblOrderSearch = new Label("Search with order number", 31, 36, 178, 45);
		panelOrder.add(lblOrderSearch);

		Label lblSupplierOrder = new Label("Supplier Order", 50, 92, 159, 22);
		panelOrder.add(lblSupplierOrder);

		Label lblOrderProduct = new Label("Product Order", 218, 91, 86, 23);
		panelOrder.add(lblOrderProduct);

		Label lblOrderPackaging = new Label("Packaging Order", 314, 89, 113, 29);
		panelOrder.add(lblOrderPackaging);

		ComboBox listOrderSupplier = new ComboBox("listOrdSuppl", 50, 111, 158, 32);
		panelOrder.add(listOrderSupplier);

		ComboBox listOrder = new ComboBox("listOrder", 219, 42, 339, 32);
		panelOrder.add(listOrder);

		ComboBox listOrderProduct = new ComboBox("listOrdProd", 218, 111, 86, 32);
		panelOrder.add(listOrderProduct);

		ComboBox listOrderPackaging = new ComboBox("listOrdPack", 314, 111, 86, 32);
		panelOrder.add(listOrderPackaging);

		ComboBox listOrderOfState = new ComboBox("listOrdState", 686, 291, 84, 22);
		listOrderOfState.setMaximumRowCount(4);
		panelOrder.add(listOrderOfState);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_3.setBounds(50, 163, 574, 178);
		panelOrder.add(scrollPane_3);

		table_Order = new JTable();
		table_Order.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
				new String[] { "Product", "Packaging", "Quantity", "Price" }));
		table_Order.setBackground(new Color(255, 222, 173));
		scrollPane_3.setViewportView(table_Order);

		TextField tfOrderNumber = new TextField("orderNumber", 50, 77, 86, 20);
		panelOrder.add(tfOrderNumber);

		TextField tfState = new TextField("state", 685, 326, 86, 20);
		panelOrder.add(tfState);

		/**
		 * Article
		 */

		Panel panelArticle = new Panel("panelArticle");

		TabbedPane.addTab("Article", new ImageIcon(Frame.class.getResource("/assets/Article.jpg")), panelArticle, null);
		panelArticle.setLayout(null);

		Button btnArticleLaunch = new Button("Article_Launch", 541, 36, 86, 23);
		panelArticle.add(btnArticleLaunch);

		Button btnArticleCreate = new Button("Article_Create", 563, 371, 113, 32);
		panelArticle.add(btnArticleCreate);

		Button btnArticleModify = new Button("Article_Modify", 177, 371, 113, 32);
		panelArticle.add(btnArticleModify);

		Button btnArticleCreatDate = new Button("Creating Date", 601, 179, 121, 23);
		panelArticle.add(btnArticleCreatDate);

		Button btnArticleUpdateDate = new Button("Update Date", 601, 236, 121, 23);
		panelArticle.add(btnArticleUpdateDate);

		Label lblArticleSearch = new Label("Search", 135, 34, 95, 27);
		panelArticle.add(lblArticleSearch);

		Label lblArticleRef = new Label("Article Ref", 39, 70, 109, 14);
		panelArticle.add(lblArticleRef);

		Label lblArticleName = new Label("Article Name", 192, 72, 80, 14);
		panelArticle.add(lblArticleName);

		Label lblArticleProduct = new Label("Product Article", 282, 70, 86, 14);
		panelArticle.add(lblArticleProduct);

		Label lblArticleQuantity = new Label("Quantity Article", 378, 70, 101, 14);
		panelArticle.add(lblArticleQuantity);

		Label lblArticleUnit = new Label("Unit Article", 489, 70, 76, 14);
		panelArticle.add(lblArticleUnit);

		Label lblArticlePackaging = new Label("Packaging Article", 574, 70, 102, 14);
		panelArticle.add(lblArticlePackaging);

		Label lblArticleStock = new Label("Stock Article", 697, 70, 86, 14);
		panelArticle.add(lblArticleStock);

		JScrollPane scrollPane_Article = new JScrollPane();
		scrollPane_Article.setBounds(55, 158, 476, 172);
		panelArticle.add(scrollPane_Article);

		ComboBox listArticle = new ComboBox("listArt", 192, 31, 339, 32);
		panelArticle.add(listArticle);

		ComboBox listUnitArticle = new ComboBox("listArtUni", 489, 90, 76, 32);
		panelArticle.add(listUnitArticle);

		ComboBox listProductArticle = new ComboBox("listArtProd", 282, 90, 86, 32);
		panelArticle.add(listProductArticle);

		TextField tfArticle = new TextField("article", 378, 90, 55, 32);
		panelArticle.add(tfArticle);

		TextField tfArticleName = new TextField("articleName", 196, 90, 76, 32);
		panelArticle.add(tfArticleName);

		TextField tfArticleRef = new TextField("articleRef", 39, 90, 109, 32);
		panelArticle.add(tfArticleRef);

		TextField tfPackaging = new TextField("packaging", 528, 90, 76, 32);
		panelArticle.add(tfPackaging);

		TextField tfStock = new TextField("stock", 621, 90, 55, 32);
		panelArticle.add(tfStock);

		table_3 = new JTable();
		table_3.setBackground(new Color(255, 222, 173));
		table_3.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null },
						{ null, null, null }, { null, null, null }, { null, null, null }, { null, null, null }, },
				new String[] { "Supplier", "Price/Unit", "Article Price" }));
		scrollPane_Article.setViewportView(table_3);

		/**
         * Product
         */

        Panel panelProduct = new Panel("panelProduct");

        TabbedPane.addTab("Product", new ImageIcon(Frame.class.getResource("/assets/Product.jpg")), panelProduct, null);

        Button btnProductBlock = new Button("Block /Unblock selected Element", 166, 368, 211, 30);
        panelProduct.add(btnProductBlock);

        Button btnProductSave = new Button("Save", 505, 366, 99, 29);
        panelProduct.add(btnProductSave);
        
        Button btnProductAddTextfield = new Button("+_Product",26, 285, 180, 41);
        panelProduct.add(btnProductAddTextfield);
        
        Button[] productButton = { btnProductBlock, btnProductSave, btnProductAddTextfield};
        
        Label lblProductIngredient = new Label("Type of product",31, 84, 121, 14);
        panelProduct.add(lblProductIngredient);
        
        Label lblProductUnit = new Label("Product Unit",26, 224, 78, 14);

        panelProduct.add(lblProductUnit);
        Label lblProduct = new Label("Product",31, 152, 175, 30);
        panelProduct.add(lblProduct);
        
        Label[] productLabel = {lblProductIngredient,lblProductUnit,lblProduct
                
        };
        ComboBox listProductUnit = new ComboBox("listProdUnit",26, 242, 180, 32);

        panelProduct.add(listProductUnit);
        
        ComboBox listProductType = new ComboBox("listProdType",26, 109, 180, 32);
        panelProduct.add(listProductType);
        
        ComboBox[] productComboBox = {listProductUnit,listProductType};
        ScrollPane scrollPane_1 = new ScrollPane(289, 55, 444, 271);
        scrollPane_1.setEnabled(false);
        
        panelProduct.add(scrollPane_1);

        TextField tfProduct = new TextField("product",26, 181, 180, 32);
        panelProduct.add(tfProduct);


        
        
        table_1 = new JTable();
        table_1.setShowHorizontalLines(false);
        table_1.setBackground(new Color(255, 222, 173));
        table_1.setModel(new DefaultTableModel(
            new Object[][] {
                {"", null, null, null},
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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
            },
            new String[] {
                "Product", "State", "Nb Articles", "Unit"
            }
        ) {
            Class[] columnTypes = new Class[] {
                String.class, Object.class, Object.class, Object.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        scrollPane_1.setViewportView(table_1);
        
        
        prod = new ValueNeededProduct(this, panelProduct, productButton, productLabel, productComboBox, tfProduct,scrollPane_1,
                table_1);

		/**
		 * History
		 */

		Panel panelHistory = new Panel("panelHistory");

		TabbedPane.addTab("History", new ImageIcon(Frame.class.getResource("/assets/History.jpg")), panelHistory, null);

		Button btnHistorySubmit = new Button("History_Submit", 525, 381, 89, 23);
		panelHistory.add(btnHistorySubmit);

		Button btnHistoryShowCompletedOrders = new Button("Orders placed", 454, 79, 129, 23);
		panelHistory.add(btnHistoryShowCompletedOrders);

		Button btnHistoryShowOrdersInProgress = new Button("Orders in progress", 593, 79, 149, 23);
		panelHistory.add(btnHistoryShowOrdersInProgress);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(58, 141, 684, 178);
		panelHistory.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 222, 173));
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
						{ null, null, null, null }, { null, null, null, null }, { null, null, null, null }, },
				new String[] { "Order", "Delivery date", "Validation date", "State" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

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

		Button btnManageModifyProfile = new Button("Manage_Modify_Profile", 154, 372, 138, 29);
		panelManage.add(btnManageModifyProfile);

		Button btnManageModifyPassWord = new Button("Manage_Modify_PassWord", 507, 372, 147, 34);
		panelManage.add(btnManageModifyPassWord);

		Button btnManageBlockAdmin = new Button("Manage_Block / Unblock", 324, 315, 147, 29);
		panelManage.add(btnManageBlockAdmin);

		Button btnManageLaunch = new Button("Manage_Launch", 539, 48, 86, 23);
		panelManage.add(btnManageLaunch);

		Label lblManageSearch = new Label("Search", 133, 46, 95, 27);
		panelManage.add(lblManageSearch);

		ComboBox list = new ComboBox("listAdmin", 190, 43, 339, 32);
		panelManage.add(list);

		TextField tfManageFirstname = new TextField("manageFirstname", 59, 151, 160, 20);
		panelManage.add(tfManageFirstname);

		Label lblManageFirsName = new Label("Firstname", 59, 130, 160, 20);
		panelManage.add(lblManageFirsName);

		TextField tfManageLastname = new TextField("manageLastname", 59, 205, 160, 20);
		panelManage.add(tfManageLastname);

		Label lblManageLastName = new Label("Lastname", 57, 182, 162, 20);
		panelManage.add(lblManageLastName);

		Label lblManageUserName = new Label("Username", 58, 236, 161, 20);
		panelManage.add(lblManageUserName);

		TextField tfManageUsername = new TextField("", 59, 258, 160, 20);
		panelManage.add(tfManageUsername);

		Label lblManagePassword = new Label("Password", 584, 141, 138, 14);
		panelManage.add(lblManagePassword);

		PasswordField pwManagePassword = new PasswordField("Manage Password", 584, 159, 138, 20);
		panelManage.add(pwManagePassword);

		Label lblManageConfirmPassword = new Label("Confirm password", 584, 190, 138, 14);
		panelManage.add(lblManageConfirmPassword);

		PasswordField pwManageConfPassword = new PasswordField("Manage Conf Password", 584, 212, 138, 20);
		panelManage.add(pwManageConfPassword);
		
		Button btnManageCreate = new Button("Create Profile", 496, 371, 113, 32);
        panelManage.add(btnManageCreate);
        btnManageCreate.setBounds(344, 372, 113, 32);
		
		// add a changeListener to the tabbedPane
		TabbedPane.addChangeListener(new TabbedPaneChangeListener());


	}
}
