package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;

import model.QuerySupplier;

public class ComboBox extends JComboBox {
	private String nameField;
	

	public ComboBox(String name, int x, int y, int L, int l) throws Exception {
		this.setBounds(x, y, L, l);
		this.nameField = name;
		
		if ((name.equals("listArtUni"))||(name.equals("listArtProd"))||(name.equals("packaging"))) {
			this.setRenderer(new DefaultListCellRenderer() {
		        @Override
		        public void paint(Graphics g) {
		            setForeground(Color.BLACK);
		            super.paint(g);
		        }
		    });
		}
	}

	
}
