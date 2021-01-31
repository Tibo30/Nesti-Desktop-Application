package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Product;
import entities.Supplier;
import entities.UnitMeasure;
import model.QueryProduct;
import model.QuerySupplier;

public class ProductPanel extends JPanel {
	public static JTable table_1;

	public static Label[] label;
	public static ComboBox[] combo;
	public static TextField[] textField;
	public static PasswordField passwordField[];
	public static Button[] button;
	public static SupplierPanel panel;
	public static ScrollPane scroll;
	private QueryProduct queryProd;
	public static Product activProduct;
	
	
	boolean flag;
	public ProductPanel() throws Exception {
		this.setBackground(new Color(213, 167, 113));
		this.setLayout(null);
 this.queryProd = new QueryProduct();
 
 /*Move and change it
  * */
		Button btnProductBlock = new Button("Block /Unblock selected Element", 166, 368, 211, 30);

		this.add(btnProductBlock);

		Button btnProductSave = new Button("Save", 505, 366, 99, 29);
		this.add(btnProductSave);

		Button btnProductAddTextfield = new Button("+_Product", 26, 285, 89, 46);

		this.add(btnProductAddTextfield);

		Button btnProductModify = new Button("Product Modify", 121, 284, 89, 46);

		this.add(btnProductModify);

		Button[] productButton = { btnProductBlock, btnProductSave, btnProductAddTextfield };
		button = productButton;
		Label lblProductIngredient = new Label("Type of product", 31, 84, 121, 14);
		this.add(lblProductIngredient);

		Label lblProductUnit = new Label("Product Unit", 26, 224, 78, 14);
		this.add(lblProductUnit);
		
		Label lblProduct = new Label("Product", 31, 152, 175, 30);
		this.add(lblProduct);

		Label[] productLabel = { lblProductIngredient, lblProductUnit, lblProduct };
		label = productLabel;
		
		ComboBox listProductUnit = new ComboBox("listProdUnit", 26, 242, 180, 32);
		this.add(listProductUnit);

		ComboBox listProductType = new ComboBox("listProdType", 26, 109, 180, 32);
		this.add(listProductType);

		ComboBox[] productComboBox = { listProductUnit, listProductType };
		combo = productComboBox;
	
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
				flag = true ;
				int row = table_1.getSelectedRow();

				tfProduct.setText((String) table_1.getValueAt(row, 0));
				listProductUnit.setSelectedItem((String) table_1.getValueAt(row, 3));
				listProductType.setSelectedItem((String) table_1.getValueAt(row, 2));
				try {
					Product Product = queryProd
							.createProductInfo((String) table_1.getValueAt(row, 0));
					activProduct = Product;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
		});

		table_1.setShowHorizontalLines(false);
		table_1.setBackground(new Color(255, 222, 173));
		DefaultTableModel model2 = new DefaultTableModel(new Object[][] {,},
				new String[] { "Product", "State", "Type", "Unit", "Nb Articles" });

		table_1.setModel(model2);

		scrollPane_1.setViewportView(table_1);

		
		btnProductAddTextfield.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				UnitMeasure unit = new UnitMeasure(listProductUnit.getSelectedItem().toString());
				int mousetrue;
				if ( flag == true ) {
					 mousetrue = table_1.getSelectedRow();
				}else {
					mousetrue = table_1.getRowCount()-1 ;
				}
				Product product = new Product(tfProduct.getText(), table_1.getValueAt(mousetrue, 1).toString(),
						listProductType.getSelectedItem().toString(), unit);

				Object[] row = product.toRowProduct();
				
				DefaultTableModel model = (DefaultTableModel) table_1.getModel();
				model.addRow(row);
				 try {
					 UnitMeasure unitinfo = queryProd.createUnitInfo((String) listProductUnit.getSelectedItem());
	                    Product pro = new Product(tfProduct.getText(),"Unblocked",(String) listProductType.getSelectedItem(), unitinfo);
	                   queryProd.createPrepared(pro);
	                } catch (Exception e) {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
				
			}
		});
		btnProductModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table_1.getSelectedRow();

			
				
				
				/*TODO 
				 * **/
					 try {
						if (!activProduct.getName().equals(tfProduct.getText())) {
							if (SupplierPanel.isNameTaken(tfProduct.getText()) == false) {
								queryProd.UpdateProductPrepared("name", tfProduct.getText(), activProduct.getName());
								activProduct.setName(tfProduct.getText());
							}else {
								JOptionPane.showMessageDialog(null, "This Product's name is already taken");
							}
						}
						if (!activProduct.getType().equals(listProductType.getSelectedItem().toString())) {
							queryProd.UpdateProductPrepared("type", listProductType.getSelectedItem().toString(), activProduct.getName());
						}
						System.out.println(activProduct.getUnit().getName());
						System.out.println(listProductUnit.getSelectedItem().toString());
						if (!activProduct.getUnit().getName().equals(listProductUnit.getSelectedItem().toString())) {
					
							queryProd.UpdateProductPrepared("unit", listProductUnit.getSelectedItem().toString(), activProduct.getName());
						}
						/* 
						String  state = table_1.getValueAt(table_1.getSelectedRow(), 1).toString();
						 UnitMeasure unitinfo = queryProd.createUnitInfo((String) listProductUnit.getSelectedItem());
		                    Product pro = new Product(tfProduct.getText(),state,(String) listProductType.getSelectedItem(), unitinfo);
		            
		                    queryProd.UpdateProductPrepared(pro);
						
		                    activProduct = queryProd.createProductInfo(activProduct.getName());
					 
					 }catch (Exception e) {
		                    // TODO Auto-generated catch block
		                    e.printStackTrace();
		                }
*/
					
						DefaultTableModel model = (DefaultTableModel) table_1.getModel();
						String[] product = { tfProduct.getText(), "Unblocked",
								combo[1].getSelectedItem().toString(), combo[0].getSelectedItem().toString(), "" };
						for (int i = 0; i < table_1.getColumnCount(); i++) {
							model.setValueAt(product[i], row, i);
							}
					 
				}catch (Exception e) {
                   System.out.println("modify error");
                    e.printStackTrace();
                }
			
		}});

			/*
			 * Change to the same of Supplier effect
			 * */
		btnProductBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int row =  table_1.getSelectedRow();
				boolean only = true;
				
				
				if ( table_1.getValueAt(row, 1).equals("Unblocked") && (only == true)) {
					// Block
					only = false;
					Object toto = "Blocked";
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();
					model.setValueAt(toto, row, 1);
					
				} else {
					only = true;
					Object toto = "Unblocked";
					DefaultTableModel model = (DefaultTableModel)  table_1.getModel();
					model.setValueAt(toto, row, 1);
					
				}
				if (!activProduct.getState().equals(table_1.getValueAt(row, 1))) {
					try {
					
						queryProd.UpdateProductPrepared("state", table_1.getValueAt(row, 1).toString(), activProduct.getName());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
	}
}