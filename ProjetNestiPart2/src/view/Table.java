package view;

import javax.swing.JTable;

public class Table extends JTable{
		int id;
		String name;
		String state;
		String unitMeasure;
	
	
	
	
	public Table(int id, String name, String state, String unitMeasure) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.unitMeasure=unitMeasure;
		
		
		
	}
	
	
}
