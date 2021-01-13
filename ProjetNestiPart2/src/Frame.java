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

public class Frame {

	private JFrame frame;
	private final JPanel panel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		flowLayout.setAlignOnBaseline(true);
		panel_Profile.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Profile", null, panel_Profile, null);
		panel_Profile.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(52, 92, 86, 20);
		panel_Profile.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(52, 146, 86, 20);
		panel_Profile.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(52, 199, 86, 20);
		panel_Profile.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(577, 92, 86, 20);
		panel_Profile.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(577, 146, 86, 20);
		panel_Profile.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(577, 199, 86, 20);
		panel_Profile.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(175, 359, 89, 23);
		panel_Profile.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(451, 359, 89, 23);
		panel_Profile.add(btnNewButton_1);
		
		JPanel panel_Supplier = new JPanel();
		panel_Supplier.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Supplier", null, panel_Supplier, null);
		panel_Supplier.setLayout(null);
		
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
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(749, 0, 76, 27);
		panel.add(lblLogo);
	}
}
