package components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import view.ValueNeeded;

public class Label extends JLabel {
	private String nameField;
	private ValueNeeded object;

	public Label(String name, int x, int y, int L, int l) {
		this.nameField = name;

		this.setBounds(x, y, L, l);
		this.setText(nameField);
		this.setFont(new Font("Tahoma", Font.BOLD, 15));

		if (name.equals("Search") || name.equals("Launch") || name.equals("Search Article") || name.equals("Search Order") || (name.equals("Supplier"))) {
			this.setFont(new Font("Tahoma", Font.BOLD, 12));
		}
		if (name.equals("Welcome")) {
			this.setForeground(new Color(255, 250, 250));
			this.setHorizontalAlignment(SwingConstants.CENTER);
			this.setFont(new Font("Times New Roman", Font.BOLD, 40));
		}
		if ((name.equals("Supplier Name")) || (name.equals("Supplier Address")) || (name.equals("Supplier Town"))
				|| (name.equals("Contact Name")) || (name.equals("Contact Fistname")) || (name.equals("Contact phone"))
				|| (name.equals("Product Price")) || (name.equals("Unit Product"))|| (name.equals("Supplier Product"))
				|| (name.equals("Article Ref"))|| (name.equals("Article Name"))|| (name.equals("Quantity Article"))
				|| (name.equals("Unit Article"))|| (name.equals("Packaging Article"))|| (name.equals("Stock Article"))
				|| (name.equals("Product"))|| (name.equals("Packaging"))|| (name.equals("Quantity Order")) || (name.equals("Quantity"))|| (name.equals("Unit")) || (name.equals("Date")) || (name.equals("Total"))  || (name.equals("Product Article"))
				|| (name.equals("Ingredient"))
				|| (name.equals("Product Unit"))) {
			this.setFont(new Font("Tahoma", Font.BOLD, 11));
			
		}
	
	}
	
}
