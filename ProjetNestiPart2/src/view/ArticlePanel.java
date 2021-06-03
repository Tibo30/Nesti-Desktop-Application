package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import components.Button;
import components.ComboBox;
import components.Label;
import components.TextField;
import entities.Article;
import entities.Packaging;
import entities.Product;
import entities.Supplier;
import entities.SupplierSell;
import entities.UnitMeasure;
import model.QueryArticle;
import model.QueryPackaging;
import model.QueryProduct;
import model.QuerySupplierSell;
import tools.Check;

public class ArticlePanel extends JPanel {
	private static JTable table_3;
	public static Label[] label;
	public static Button[] button;
	public static ComboBox[] combo;
	public static ComboBox[] combo1;
	public static TextField[] textField;
	static QueryArticle queryArt;
	static QuerySupplierSell querySell;
	private static QueryProduct queryProd;
	private static QueryPackaging queryPack;

	/**
	 * 
	 * @throws Exception
	 */
	public ArticlePanel() throws Exception {
		this.setBackground(new Color(213, 167, 113));
		this.setLayout(null);
		this.queryArt = new QueryArticle();
		this.queryProd = new QueryProduct();
		this.queryPack = new QueryPackaging();
		Button btnArticleLaunch = new Button("Article_Launch", 541, 36, 86, 23);
		this.add(btnArticleLaunch);

		Button btnArticleBlock = new Button("SupplierBlock / Unblock", 10, 72, 122, 23);
		btnArticleBlock.setSize(115, 23);
		btnArticleBlock.setLocation(10, 36);
		btnArticleBlock.setEnabled(false);
		this.add(btnArticleBlock);

		Button btnArticleCreate = new Button("Article_Create", 563, 371, 113, 32);
		btnArticleCreate.setVisible(false);
		this.add(btnArticleCreate);

		Button btnArticleModify = new Button("Article_Modify", 177, 371, 113, 32);
		btnArticleModify.setVisible(false);
		this.add(btnArticleModify);

		Button[] articleButton = { btnArticleLaunch, btnArticleCreate, btnArticleModify, btnArticleBlock };
		button = articleButton;

		Label lblArticleSearch = new Label("Search", 135, 34, 95, 27);
		this.add(lblArticleSearch);

		Label lblArticleRef = new Label("Article Ref", 39, 70, 109, 14);
		this.add(lblArticleRef);

		Label lblArticleProduct = new Label("Product Article", 204, 73, 131, 14);
		this.add(lblArticleProduct);

		Label lblArticleQuantity = new Label("Quantity Article", 378, 70, 101, 14);
		this.add(lblArticleQuantity);

		Label lblArticleUnit = new Label("Unit Article", 489, 69, 59, 20);
		this.add(lblArticleUnit);

		Label lblArticlePackaging = new Label("Packaging Article", 574, 70, 102, 14);
		this.add(lblArticlePackaging);

		Label lblArticleStock = new Label("Stock Article", 697, 70, 86, 14);
		this.add(lblArticleStock);

		Label lblArticleCreatDate = new Label("Creating Date", 600, 159, 118, 14);
		this.add(lblArticleCreatDate);

		Label lblArticleUpdateDate = new Label("Update Date", 600, 216, 118, 14);
		this.add(lblArticleUpdateDate);

		Label[] articleLabel = { lblArticleSearch, lblArticleRef, lblArticleProduct, lblArticleQuantity, lblArticleUnit,
				lblArticlePackaging, lblArticleStock, lblArticleCreatDate, lblArticleUpdateDate };
		label = articleLabel;

		ScrollPane scrollPane_Article = new ScrollPane(55, 158, 476, 172);
		this.add(scrollPane_Article);

		ComboBox listArticle = new ComboBox("listArt", 192, 31, 339, 32);

		this.add(listArticle);

		ComboBox listUnitArticle = new ComboBox("listArtUni", 484, 90, 60, 31);
		listUnitArticle.setEnabled(false);
		listUnitArticle.setEditable(false);
		this.add(listUnitArticle);

		ComboBox listProductArticle = new ComboBox("listArtProd", 179, 91, 189, 31);
		listProductArticle.setEnabled(false);
		this.add(listProductArticle);

		ComboBox listPackaging = new ComboBox("packaging", 585, 89, 86, 31);
		listPackaging.setEnabled(false);
		this.add(listPackaging);

		ComboBox[] articleComboBox = { listArticle, listUnitArticle, listProductArticle, listPackaging };
		ComboBox[] articleActivComboBox = { listUnitArticle, listProductArticle, listPackaging };
		combo = articleComboBox;
		combo1 = articleActivComboBox;

		TextField tfArticle = new TextField("article", 391, 90, 60, 32);
		tfArticle.setEnabled(false);
		tfArticle.setDisabledTextColor(Color.BLACK);
		this.add(tfArticle);

		TextField tfArticleRef = new TextField("articleRef", 39, 90, 109, 32);
		tfArticleRef.setEnabled(false);
		tfArticleRef.setDisabledTextColor(Color.BLACK);
		this.add(tfArticleRef);

		TextField tfStock = new TextField("stock", 708, 91, 55, 30);
		tfStock.setDisabledTextColor(Color.BLACK);
		tfStock.setEnabled(false);
		this.add(tfStock);

		TextField tfArticleCreatDate = new TextField("Creating Date", 601, 179, 121, 23);
		tfArticleCreatDate.setEnabled(false);
		tfArticleCreatDate.setDisabledTextColor(Color.BLACK);
		this.add(tfArticleCreatDate);

		TextField tfArticleUpdateDate = new TextField("Update Date", 601, 236, 121, 23);
		tfArticleUpdateDate.setDisabledTextColor(Color.BLACK);
		tfArticleUpdateDate.setEnabled(false);
		this.add(tfArticleUpdateDate);

		TextField[] articleTextField = { tfArticle, tfArticleRef, tfStock, tfArticleCreatDate, tfArticleUpdateDate };
		textField = articleTextField;

		table_3 = new JTable() {
			public boolean isCellEditable(int d, int c) {
				return false;
			}
		};
		table_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (table_3.getSelectedRow() != 0) {
					btnArticleCreate.setEnabled(true);
					btnArticleModify.setEnabled(true);
					btnArticleModify.setBackground(new Color(232, 250, 126));
				}
				int row = table_3.getSelectedRow();
			}
		});

		table_3.setBackground(new Color(255, 222, 173));
		DefaultTableModel model2 = new DefaultTableModel(new Object[][] {,},
				new String[] { "Supplier", "Price/Unit", "Article Price" });
		table_3.setModel(model2);
		scrollPane_Article.setViewportView(table_3);

		btnArticleLaunch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					clearTable();
					tfArticleRef.setEditable(false);

					tfStock.setEnabled(false);
					btnArticleBlock.setEnabled(false);
					
					if (!String.valueOf(listArticle.getSelectedItem()).equals("Create New Article")) {
				
						tfArticle.setEnabled(true);
						tfArticle.setEditable(true);
						
						ArrayList<Supplier> listSupplier = new ArrayList<Supplier>();
						ArrayList<Double> listPriceForUnit = new ArrayList<Double>();
						ArrayList<Double> listPrice = new ArrayList<Double>();
						// get the value of the item in listArticle
						Article article = ((Article) listArticle.getSelectedItem());
						Product product = article.getProduct();
						// Change state of button
						tfArticleRef.setEditable(false);

						btnArticleBlock.setEnabled(true);
						listProductArticle.setEnabled(false);
						listPackaging.setEnabled(false);
						listUnitArticle.setEnabled(false);

						btnArticleCreate.setVisible(false);
						btnArticleModify.setVisible(true);
						btnArticleModify.setEnabled(true);
						// Give value of textfiel and list
						listPackaging.getModel().setSelectedItem(article.getPackaging());
						listProductArticle.addItem(product);
						tfArticle.setText(String.valueOf(formatD((Double) article.getQuantity())));

						listUnitArticle.addItem(product.getUnit());
						listUnitArticle.getModel().setSelectedItem(product.getUnit());

						listPackaging.getModel().setSelectedItem(article.getPackaging());

						tfStock.setText(String.valueOf(article.getRealQuant()));
						tfArticleCreatDate.setText(String.valueOf(article.getCreationDate()));
						tfArticleUpdateDate.setText(String.valueOf(article.getUpdateDate()));
						creatTable3(article.getId());

						tfArticleRef.setText(creatRefNameOfArticle(article.getId(), product));

						btnArticleBlock.setText(article.getState());

						if (btnArticleBlock.getText().equals("Blocked")) {
							btnArticleBlock.setBackground(new Color(243, 101, 101));
						} else {
							btnArticleBlock.setBackground(new Color(173, 246, 100));
						}

					} else {
						
						// For the case of a new article : change style
						btnArticleBlock.setEnabled(false);
						tfStock.setEditable(false);
						tfArticleRef.setEditable(false);
						emptyTextField();
						emptyCombobox();
						// and give combo choose
						giveComboChoose();

						tfArticleRef.setEditable(false);
						btnArticleBlock.setText("Unblocked");
						tfStock.setEnabled(false);
						btnArticleBlock.setBackground(new Color(173, 246, 100));
						btnArticleCreate.setVisible(true);
						btnArticleCreate.setEnabled(true);
						btnArticleModify.setEnabled(true);
						btnArticleModify.setVisible(false);

						for (int i = 0; i < articleTextField.length - 2; i++) {
							articleTextField[i].setEnabled(true);
						}
						for (int i = 0; i < articleComboBox.length; i++) {
							articleComboBox[i].setEnabled(true);
						}

						btnArticleBlock.setEnabled(false);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		/**
         * Action listener on the list of product
         */
		listProductArticle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    if (listProductArticle.getSelectedIndex() != -1) {
                    	System.out.println(listProductArticle.getSelectedIndex());
                    	for (int i = 0; i < combo[1].getItemCount(); i++) {
                    	 	System.out.println(String.valueOf(combo[1].getItemAt(i)));
                    	 	System.out.println(((Product) listProductArticle.getSelectedItem()).getUnit().getName());
   						if (String.valueOf(combo[1].getItemAt(i)).equals(((Product) listProductArticle.getSelectedItem()).getUnit().getName())) {
   							combo[1].setSelectedIndex(i);
   						
   						}
   						
   					}
                    	listUnitArticle.setEnabled(false);
    					listUnitArticle.setEditable(false);
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
		
		btnArticleCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

//					
					Product name = (Product) listProductArticle.getSelectedItem();
					Packaging pack = (Packaging) listPackaging.getSelectedItem();
					// Controle value of textfield
					if (name != null && pack != null && (Check.isNumeric(tfArticle.getText()))) {

						Article ArticleCreate = new Article(Double.parseDouble(tfArticle.getText()), 0, pack, name);
						// check if exist an article in dbb with this compose
						if (queryArt.checkArticle(ArticleCreate.getProduct().getName(),
								ArticleCreate.getPackaging().getName(), ArticleCreate.getQuantity()) == null) {

							// add in database
							ArticleCreate.setIdAdmin(Frame.activAdmin.getId());
							queryArt.createPrepared(ArticleCreate);
							creatListOfArticle();
							JOptionPane.showMessageDialog(null, "Article added");
						} else {
							JOptionPane.showMessageDialog(null, "This article already exists");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Empty field");
					}
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}

		});
		btnArticleModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Article article = ((Article) listArticle.getSelectedItem());

				try {
					// Change state of article
					queryArt.updatePrepared("state", btnArticleBlock.getText(), article.getId());

					article.setQuantity(Double.parseDouble(tfArticle.getText()));

					queryArt.updatePrepared("quantity", formatD(article.getQuantity()), article.getId());

					clearTable();

					updateListArticle();
					for (int i = 0; i < combo[0].getItemCount(); i++) {
						if (String.valueOf(combo[0].getItemAt(i)).equals(article.toString())) {
							combo[0].setSelectedIndex(i);
						}
					}

					creatTable3(article.getId());

					JOptionPane.showMessageDialog(null, "Article updated");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnArticleBlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// Change style and text of State button
					if (btnArticleBlock.getText().equals("Unblocked")) {
						btnArticleBlock.setText("Blocked");
						btnArticleBlock.setBackground(new Color(243, 101, 101));
					} else if (btnArticleBlock.getText().equals("Blocked")) {
						btnArticleBlock.setText("Unblocked");
						btnArticleBlock.setBackground(new Color(173, 246, 100));
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	// Clear row of table
	public static void clearTable() {
		DefaultTableModel model = (DefaultTableModel) table_3.getModel();
		for (int j = model.getRowCount() - 1; j >= 0; j--) {
			model.removeRow(j);
		}
	}

	// Clear Textfield
	public static void emptyTextField() {
		for (TextField text : textField) {
			text.setText("");
		}
	}

	// Clear combobox
	public static void emptyCombobox() {
		for (ComboBox text : combo1) {
			text.removeAllItems();
		}
	}

	/**
	 * 
	 * @param Idarticle
	 * @param name
	 * @return
	 */
	public String creatRefNameOfArticle(int Idarticle, Product name) {
		String Refname = Idarticle + name.getName().substring(0, 1);
		return "REF" + Refname;
	}

	/**
	 * 
	 * @param Idarticle
	 * @param name
	 * @return
	 */
	public String setRefNameOfArticle(int Idarticle, String name) {
		String Refname = Idarticle + name.substring(0, 1);
		return "REF" + Refname;
	}

	/**
	 * 
	 * @throws Exception
	 */
	public static void creatListOfArticle() throws Exception {
		combo[0].removeAllItems();
		ArrayList<Article> listArt = new ArrayList<Article>();
		for (Article art : queryArt.listAllArticle()) {
			listArt.add(art);
		}
		for (int i = 0; i < listArt.size(); i++) {
			// add the list elements to the search combo box
			combo[0].addItem(listArt.get(i));

		}

		combo[0].setSelectedIndex(0);
	}

	/**
	 * 
	 * @param IdArticle
	 */
	public static void creatTable3(int IdArticle) {

		try {
			ArrayList<SupplierSell> suppliersSell = queryArt.giveTableInfo(IdArticle);

			DefaultTableModel model = (DefaultTableModel) ArticlePanel.table_3.getModel();
			for (int i = 0; i < suppliersSell.size(); i++) {
				// add the list elements to the search combo box

				Product pro = suppliersSell.get(i).getProduct();
				double buyingprice = suppliersSell.get(i).getBuyingPrice();
				UnitMeasure unit = pro.getUnit();
				double quantity = Double
						.parseDouble(String.valueOf(((Article) combo[0].getSelectedItem()).getQuantity()));
				System.out.println(((Article) combo[0].getSelectedItem()).getQuantity());
				System.out.println(buyingprice + "    " + quantity);
				Object[] row = { suppliersSell.get(i).getSupplier(), buyingprice + "/" + unit, quantity * buyingprice };

				model.addRow(row);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @throws Exception
	 */
	public static void updateListArticle() throws Exception {

		ArrayList<Article> listArt = new ArrayList<Article>();
		combo[0].removeAllItems();
		combo[0].addItem("Create New Article");
		for (Article sup : queryArt.listAllArticle()) {
			listArt.add(sup);
		}
		for (int i = 0; i < listArt.size(); i++) {
			// add the list elements to the search combo box
			combo[0].addItem(listArt.get(i));

		}

		combo[0].setSelectedIndex(0);
	}

	/**
	 * 
	 * @throws Exception
	 */
	public void giveComboChoose() throws Exception {
		ArrayList<Product> prod = queryProd.listAllProduct();
		for (Product product : prod) {

			if (product.getState().equals("Unblocked")) {
				ArticlePanel.combo[2].addItem(product);
			}
		}
		ArrayList<UnitMeasure> list2 = queryArt.listUnit();
		for (UnitMeasure unit : list2) {

			ArticlePanel.combo[1].addItem(unit);

		}
		ArrayList<Packaging> list3 = queryPack.listAllPackaging();
		for (Packaging pack : list3) {

			ArticlePanel.combo[3].addItem(pack);
		}
	}

	/**
	 * This method is used to format the number (used to not display 2.0 but 2)
	 * 
	 * @param number
	 * @return
	 */
	public static String formatI(int number) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("#.##########", otherSymbols);
		String resultFormat = df.format(number);
		return resultFormat;
	}

	public static String formatD(double number) {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat df = new DecimalFormat("#.##########", otherSymbols);
		String resultFormat = df.format(number);
		return resultFormat;
	}

}
