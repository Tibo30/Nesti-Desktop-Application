package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ValueNeededAdmin {
	Frame frame;
	Label[] label;
	ComboBox[] combo;
	TextField[] textField;
	PasswordField passwordField[];
	Button[] button;
	JPanel panel;
	JTabbedPane TabbedPane;
	
	
	public ValueNeededAdmin (Frame frame, Label[] label, ComboBox[] combo,TextField[] textField, Button[] button, Panel panel, JTabbedPane TabbedPane) {
		this.frame=frame;
		this.label=label;
		this.combo=combo;
		this.textField=textField;
		this.button=button;
		this.panel=panel;
		this.TabbedPane=TabbedPane;
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


	public ComboBox[] getCombo() {
		return combo;
	}


	public void setCombo(ComboBox[] combo) {
		this.combo = combo;
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


	public JPanel getPanel() {
		return panel;
	}


	public void setPanel(JPanel panel) {
		this.panel = panel;
	}


	public JTabbedPane getTabbedPane() {
		return TabbedPane;
	}


	public void setTabbedPane(JTabbedPane tabbedPane) {
		TabbedPane = tabbedPane;
	}
	
	
}
