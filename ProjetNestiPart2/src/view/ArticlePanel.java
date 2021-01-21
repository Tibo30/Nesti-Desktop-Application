package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ArticlePanel extends JPanel{
	private JTable table_3;
	
	
	
	
	public ArticlePanel() throws Exception {
		this.setBackground(new Color (213,167,113));
		this.setLayout(null);
	
	
	
	
	

	Button btnArticleLaunch = new Button("Article_Launch", 541, 36, 86, 23);
	this.add(btnArticleLaunch);

	Button btnArticleCreate = new Button("Article_Create", 563, 371, 113, 32);
	this.add(btnArticleCreate);

	Button btnArticleModify = new Button("Article_Modify", 177, 371, 113, 32);
	this.add(btnArticleModify);

	Button btnArticleCreatDate = new Button("Creating Date", 601, 179, 121, 23);
	this.add(btnArticleCreatDate);

	Button btnArticleUpdateDate = new Button("Update Date", 601, 236, 121, 23);
	this.add(btnArticleUpdateDate);

	Label lblArticleSearch = new Label("Search", 135, 34, 95, 27);
	this.add(lblArticleSearch);

	Label lblArticleRef = new Label("Article Ref", 39, 70, 109, 14);
	this.add(lblArticleRef);

	Label lblArticleName = new Label("Article Name", 192, 72, 80, 14);
	this.add(lblArticleName);

	Label lblArticleProduct = new Label("Product Article", 282, 70, 86, 14);
	this.add(lblArticleProduct);

	Label lblArticleQuantity = new Label("Quantity Article", 378, 70, 101, 14);
	this.add(lblArticleQuantity);

	Label lblArticleUnit = new Label("Unit Article", 489, 70, 76, 14);
	this.add(lblArticleUnit);

	Label lblArticlePackaging = new Label("Packaging Article", 574, 70, 102, 14);
	this.add(lblArticlePackaging);

	Label lblArticleStock = new Label("Stock Article", 697, 70, 86, 14);
	this.add(lblArticleStock);

	ScrollPane scrollPane_Article = new ScrollPane(55, 158, 476, 172);

	this.add(scrollPane_Article);

	ComboBox listArticle = new ComboBox("listArt", 192, 31, 339, 32);
	this.add(listArticle);

	ComboBox listUnitArticle = new ComboBox("listArtUni", 489, 90, 76, 32);
	this.add(listUnitArticle);

	ComboBox listProductArticle = new ComboBox("listArtProd", 282, 90, 86, 32);
	this.add(listProductArticle);

	TextField tfArticle = new TextField("article", 378, 90, 55, 32);
	this.add(tfArticle);

	TextField tfArticleName = new TextField("articleName", 196, 90, 76, 32);
	this.add(tfArticleName);

	TextField tfArticleRef = new TextField("articleRef", 39, 90, 109, 32);
	this.add(tfArticleRef);

	TextField tfPackaging = new TextField("packaging", 528, 90, 76, 32);
	this.add(tfPackaging);

	TextField tfStock = new TextField("stock", 621, 90, 55, 32);
	this.add(tfStock);

	table_3 = new JTable();
	table_3.setBackground(new Color(255, 222, 173));
	 DefaultTableModel model2 = new DefaultTableModel(new Object[][] {,},
			new String[] { "Supplier", "Price/Unit", "Article Price" });
			  table_3.setModel(model2);
	scrollPane_Article.setViewportView(table_3);

	}
	
}
