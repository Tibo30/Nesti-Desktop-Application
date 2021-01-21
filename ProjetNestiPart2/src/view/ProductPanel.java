package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Product;
import model.QueryProduct;
import model.QuerySupplier;

public class ProductPanel extends JPanel {
	private JTable table_1;
	public static ValueNeededProduct prod;

	public ProductPanel() throws Exception {
		this.setBackground(new Color(213, 167, 113));
		this.setLayout(null);

		Button btnProductBlock = new Button("Block /Unblock selected Element", 166, 368, 211, 30);
		this.add(btnProductBlock);

		Button btnProductSave = new Button("Save", 505, 366, 99, 29);
		this.add(btnProductSave);

		Button btnProductAddTextfield = new Button("+_Product", 26, 285, 89, 46);
		this.add(btnProductAddTextfield);

		Button btnProductModify = new Button("Product Modify", 121, 284, 89, 46);
		this.add(btnProductModify);

		Button[] productButton = { btnProductBlock, btnProductSave, btnProductAddTextfield };

		Label lblProductIngredient = new Label("Type of product", 31, 84, 121, 14);
		this.add(lblProductIngredient);

		Label lblProductUnit = new Label("Product Unit", 26, 224, 78, 14);

		this.add(lblProductUnit);
		Label lblProduct = new Label("Product", 31, 152, 175, 30);
		this.add(lblProduct);

		Label[] productLabel = { lblProductIngredient, lblProductUnit, lblProduct

		};
		ComboBox listProductUnit = new ComboBox("listProdUnit", 26, 242, 180, 32);

		this.add(listProductUnit);

		ComboBox listProductType = new ComboBox("listProdType", 26, 109, 180, 32);
		this.add(listProductType);

		ComboBox[] productComboBox = { listProductUnit, listProductType };

		ScrollPane scrollPane_1 = new ScrollPane(289, 55, 444, 271);
		scrollPane_1.setEnabled(false);
		this.add(scrollPane_1);

		TextField tfProduct = new TextField("product", 26, 181, 180, 32);
		this.add(tfProduct);

		table_1 = new JTable() {
			public boolean isCellEditable(int d, int c) {
				return false;
			}
		};
		;

		table_1.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table_1.getSelectedRow();

				tfProduct.setText((String) table_1.getValueAt(row, 0));
				listProductUnit.setSelectedItem((String) table_1.getValueAt(row, 3));
				listProductType.setSelectedItem((String) table_1.getValueAt(row, 2));
				
				
			// Product toto = new Product((table_1.getValueAt(row, 0).toString()));
			// listProductType.setSelectedItem(toto.getType());
			// System.out.println(toto.getType());
			// System.out.println(toto.getName());
			// System.out.println( (table_1.getValueAt(row, 0).toString()));
				//System.out.println(toto.getType());
				
				

				

			}
		});

		table_1.setShowHorizontalLines(false);
		table_1.setBackground(new Color(255, 222, 173));
		DefaultTableModel model2 = new DefaultTableModel(new Object[][] {,},
				new String[] { "Product", "State","Type" , "Unit","Nb Articles"  });

		table_1.setModel(model2);

		scrollPane_1.setViewportView(table_1);

		prod = new ValueNeededProduct(this, productButton, productLabel, productComboBox, tfProduct, scrollPane_1,
				table_1);

	}

	public void Test() {

	}
}
