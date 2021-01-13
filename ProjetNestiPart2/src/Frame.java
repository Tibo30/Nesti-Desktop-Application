import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JLabel;

public class Frame {

	private JFrame frame;
	private final JPanel panel = new JPanel();

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
		frame.setBounds(100, 100, 851, 519);
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
		
		JPanel panel_Profile = new JPanel();
		panel_Profile.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Profile", null, panel_Profile, null);
		
		JPanel panel_Supplier = new JPanel();
		panel_Supplier.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Supplier", null, panel_Supplier, null);
		
		JPanel panel_Order = new JPanel();
		panel_Order.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Order", null, panel_Order, null);
		
		JPanel panel_Article = new JPanel();
		panel_Article.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Article", null, panel_Article, null);
		
		JPanel panel_Product = new JPanel();
		panel_Product.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Product", null, panel_Product, null);
		
		JPanel panel_History = new JPanel();
		panel_History.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("History", null, panel_History, null);
		
		JPanel panel_Manage = new JPanel();
		panel_Manage.setBackground(new Color(210, 105, 30));
		tabbedPane.addTab("Manage", null, panel_Manage, null);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setBounds(749, 0, 76, 27);
		panel.add(lblLogo);
	}
}
