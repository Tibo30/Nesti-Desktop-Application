package tools;

import java.awt.Color;


import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import components.TextField;
/**
 * 
 * @author SAL.BEDDEK
 *
 */
public class ToolsUi {
	
	
	/**
	 * Function to clear table
	 * @param table
	 */
	public static void clearTable(JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int j = model.getRowCount() - 1; j >= 0; j--) {
			model.removeRow(j);
		}
	}
	
	
}
