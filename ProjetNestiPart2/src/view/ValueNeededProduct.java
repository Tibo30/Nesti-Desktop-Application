package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class ValueNeededProduct {
	Frame frame;
	Label[] label;
	ComboBox[] combo;
	TextField textField;
	Button[] button;
	JPanel panel;
	ScrollPane scroll;
	JTable table;
	





	public ValueNeededProduct(Frame frame, Panel panel, Button[] button, Label[] label,
			ComboBox[] combo, TextField textField, ScrollPane scroll, JTable table) {
		this.frame = frame;
		this.label= label;
		this.combo=combo;
		this.textField=textField;
	
		this.button=button;
		this.panel=panel;
		this.scroll=scroll;
		this.table=table;
		
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}

	public Label[] getLabel() {
		return label;
	}

	public void setLabel(Label[] label) {
		this.label = label;
	}

	public TextField getTextField() {
		return textField;
	}

	public void setTextField(TextField textField) {
		this.textField = textField;
	}


	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public ComboBox[] getCombo() {
		return combo;
	}

	public void setCombo(ComboBox[] combo) {
		this.combo = combo;
	}

	public ScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(ScrollPane scroll) {
		this.scroll = scroll;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	
	
	





	
}
