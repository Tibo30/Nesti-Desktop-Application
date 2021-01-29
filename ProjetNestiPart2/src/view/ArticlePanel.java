package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entities.Article;
import entities.Product;
import entities.Supplier;
import entities.SupplierSell;
import entities.UnitMeasure;
import model.QueryArticle;
import model.QuerySupplier;
import model.QuerySupplierSell;

public class ArticlePanel extends JPanel {
	private static JTable table_3;
	public static Label[] label;
	public static Button[] button;
	public static ComboBox[] combo;
	public static TextField[] textField;
	static QueryArticle queryArt;
	static QuerySupplierSell querySell;

	public ArticlePanel() throws Exception {
		this.setBackground(new Color(213, 167, 113));
		this.setLayout(null);
		this.queryArt = new QueryArticle();

		Button btnArticleLaunch = new Button("Article_Launch", 541, 36, 86, 23);
		this.add(btnArticleLaunch);

		Button btnArticleCreate = new Button("Article_Create", 563, 371, 113, 32);
		this.add(btnArticleCreate);

		Button btnArticleModify = new Button("Article_Modify", 177, 371, 113, 32);
		this.add(btnArticleModify);

		

		Button[] articleButton = { btnArticleLaunch, btnArticleCreate, btnArticleModify };
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
		
		
		
		Label[] articleLabel = { lblArticleSearch, lblArticleRef, lblArticleProduct, lblArticleQuantity,
				lblArticleUnit, lblArticlePackaging, lblArticleStock,lblArticleCreatDate,lblArticleUpdateDate };
		label = articleLabel;

		ScrollPane scrollPane_Article = new ScrollPane(55, 158, 476, 172);
		this.add(scrollPane_Article);

		ComboBox listArticle = new ComboBox("listArt", 192, 31, 339, 32);
		this.add(listArticle);

		ComboBox listUnitArticle = new ComboBox("listArtUni", 484, 90, 60, 31);
		this.add(listUnitArticle);

		ComboBox listProductArticle = new ComboBox("listArtProd", 179, 91, 189, 31);
		this.add(listProductArticle);
		
		ComboBox listPackaging = new ComboBox("packaging", 585, 89, 86, 31);
		this.add(listPackaging);


		ComboBox[] articleComboBox = { listArticle, listUnitArticle, listProductArticle,listPackaging };
		combo = articleComboBox;

		TextField tfArticle = new TextField("article", 391, 90, 60, 32);
		this.add(tfArticle);

		
		TextField tfArticleRef = new TextField("articleRef", 39, 90, 109, 32);
		this.add(tfArticleRef);

		
		TextField tfStock = new TextField("stock", 708, 91, 55, 30);
		tfStock.setEnabled(false);
		this.add(tfStock);
		
		TextField tfArticleCreatDate = new TextField("Creating Date", 601, 179, 121, 23);
		tfArticleCreatDate.setEnabled(false);
		this.add(tfArticleCreatDate);

		TextField tfArticleUpdateDate = new TextField("Update Date", 601, 236, 121, 23);
		tfArticleUpdateDate.setEnabled(false);
		this.add(tfArticleUpdateDate);
		
		TextField[] articleTextField = { tfArticle,  tfArticleRef, tfStock,tfArticleCreatDate,tfArticleUpdateDate };
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
				ArrayList<Supplier> listSupplier = new ArrayList<Supplier>();
				ArrayList<Double> listPriceForUnit = new ArrayList<Double>();
				ArrayList<Double> listPrice = new ArrayList<Double>();
				Article article = ((Article)listArticle.getSelectedItem());
				Product product = article.getProduct();
				listProductArticle.addItem(product);
				tfArticle.setText(String.valueOf(article.getQuantity()));
				listUnitArticle.addItem(product.getUnit() );
				listPackaging.addItem(article.getPackaging());
				tfStock.setText(String.valueOf(article.getRealQuant()));
				tfArticleCreatDate.setText(String.valueOf(article.getCreationDate()));
				tfArticleUpdateDate.setText(String.valueOf(article.getUpdateDate()));
				creatTable3(article.getId());
				tfArticleRef.setText(creatRefNameOfArticle(article.getId() ,product));
				
			}
		});
		btnArticleCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnArticleModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		
	}
	public String creatRefNameOfArticle(int Idarticle, Product name) {
	String Refname = Idarticle+ name.getName().substring(0, 1);
		return "REF"+Refname;
	}
	
	public static void creatListOfArticle()throws Exception { 
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
	
	public static void creatTable3(int IdArticle) {
		
		try {
			ArrayList<SupplierSell> suppliersSell = queryArt.giveTableInfo(IdArticle);
		
			DefaultTableModel model = (DefaultTableModel) ArticlePanel.table_3.getModel();
			for (int i = 0; i < suppliersSell.size(); i++) {
				// add the list elements to the search combo box
				// System.out.println(listProd.get(i).getState());
				Product pro = suppliersSell.get(i).getProduct();
				double buyingprice=suppliersSell.get(i).getBuyingPrice();
				UnitMeasure unit = pro.getUnit();
				int quantity = (int) ((Article)combo[0].getSelectedItem()).getQuantity();
				
				
				Object[] row = { suppliersSell.get(i).getSupplier(),buyingprice+"/"+unit,quantity*buyingprice };

				model.addRow(row);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*public void listOfSupplierforArticle()	{
	
	ArrayList<Product> listSupplier;
	try {
		listSupplier = queryArt.giveArticleInfo();

		DefaultTableModel model = (DefaultTableModel) ProductPanel.table_1.getModel();
		for (int i = 0; i < listSupplier.size(); i++) {
			// add the list elements to the search combo box
			// System.out.println(listProd.get(i).getState());
			Object[] row = { listSupplier.get(i).getName(), };

			model.addRow(row);
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}*/
	
	}
