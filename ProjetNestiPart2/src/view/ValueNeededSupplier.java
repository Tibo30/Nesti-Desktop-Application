package view;

import javax.swing.JTable;

import components.Button;
import components.ComboBox;
import components.Label;
import components.PasswordField;
import components.TextField;

public class ValueNeededSupplier {
	
	Label[] label;
	ComboBox[] combo;
	TextField[] textField;
	PasswordField passwordField[];
	Button[] button;
	SupplierPanel panel;
	ScrollPane scroll;
	JTable table;

	
	public ValueNeededSupplier(Label[] label, ComboBox[] combo,TextField[] textField, Button[] button, SupplierPanel panel, ScrollPane scroll, JTable table) {
	
		this.label=label;
		this.combo=combo;
		this.textField=textField;
		this.button=button;
		this.panel=panel;
		this.scroll=scroll;
		this.table=table;
		
	}


	public Label[] getLabel() {
		return label;
	}

	public void setLabel(Label[] label) {
		this.label = label;
	}

	public TextField[] getTextField() {
		return textField;
	}

	public void setTextField(TextField[] textField) {
		this.textField = textField;
	}

	public PasswordField[] getPasswordField() {
		return passwordField;
	}

	public void setPasswordField(PasswordField[] passwordField) {
		this.passwordField = passwordField;
	}

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	

	public SupplierPanel getPanel() {
		return panel;
	}


	public void setPanel(SupplierPanel panel) {
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
