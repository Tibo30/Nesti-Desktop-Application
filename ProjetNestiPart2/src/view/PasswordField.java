package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPasswordField;

public class PasswordField extends JPasswordField {
	private String nameField;

	public PasswordField(String name, int x, int y, int L, int l) {
		this.nameField = name;

		this.setFont(new Font("Rockwell Nova", Font.PLAIN, 14));
		this.setBounds(x, y, L, l);
		this.setBackground(new Color(255, 222, 173));
		this.setColumns(10);

		switch (name) {
		case "Profil Password": {

			break;
		}
		case "Profil NewPassword": {

			break;
		}
		case "Profil Conform Password": {

			break;
		}
		case "Manage Password": {

			break;
		}
		case "Manage Conf Password": {

			break;
		}
		}

	}
}
