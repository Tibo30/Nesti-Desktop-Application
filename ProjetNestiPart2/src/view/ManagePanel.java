package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import entities.Admin;
import model.QueryAdmin;

public class ManagePanel extends JPanel {

	public static Label[] label;
	public static ComboBox combo;
	public static TextField[] textField;
	public static PasswordField passwordField[];
	public static Button[] button;
	public static JTabbedPane TabbedPane;

	public ManagePanel() throws Exception {

		this.setBackground(new Color(213, 167, 113));
		this.setLayout(null);

		Button btnManageModifyProfile = new Button("Manage_Modify_Profile", 154, 372, 138, 29);
		this.add(btnManageModifyProfile);

		Button btnManageModifyPassWord = new Button("Manage_Modify_PassWord", 507, 372, 147, 34);
		this.add(btnManageModifyPassWord);

		Button btnManageBlockAdmin = new Button("Manage_Block / Unblock", 324, 315, 147, 29);
		this.add(btnManageBlockAdmin);

		Button btnManageLaunch = new Button("Manage_Launch", 539, 48, 86, 23);
		this.add(btnManageLaunch);

		Button btnManageCreate = new Button("Create Profile", 344, 372, 113, 32);
		this.add(btnManageCreate);

		Button[] manageButton = { btnManageModifyProfile, btnManageModifyPassWord, btnManageBlockAdmin, btnManageLaunch,
				btnManageCreate };

		this.button = manageButton;

		Label lblManageSearch = new Label("Search", 133, 46, 95, 27);
		this.add(lblManageSearch);

		Label lblManageFirsName = new Label("Firstname", 59, 130, 160, 20);
		this.add(lblManageFirsName);

		Label lblManagePassword = new Label("Password", 584, 141, 138, 14);
		this.add(lblManagePassword);

		Label lblManageLastName = new Label("Lastname", 57, 182, 162, 20);
		this.add(lblManageLastName);

		Label lblManageUserName = new Label("Username", 58, 236, 161, 20);
		this.add(lblManageUserName);

		Label lblManageConfirmPassword = new Label("Confirm password", 584, 190, 138, 14);
		this.add(lblManageConfirmPassword);

		Label[] manageLabel = { lblManageSearch, lblManageFirsName, lblManagePassword, lblManageLastName,
				lblManageUserName, lblManageConfirmPassword };

		this.label = manageLabel;

		TextField tfManageFirstname = new TextField("manageFirstname", 59, 151, 160, 20);
		this.add(tfManageFirstname);

		TextField tfManageLastname = new TextField("manageLastname", 59, 205, 160, 20);
		this.add(tfManageLastname);

		TextField tfManageUsername = new TextField("", 59, 258, 160, 20);
		this.add(tfManageUsername);

		TextField[] manageTextField = { tfManageFirstname, tfManageLastname, tfManageUsername };

		this.textField = manageTextField;

		PasswordField pwManagePassword = new PasswordField("Manage Password", 584, 159, 138, 20);
		this.add(pwManagePassword);

		PasswordField pwManageConfPassword = new PasswordField("Manage Conf Password", 584, 212, 138, 20);
		this.add(pwManageConfPassword);

		PasswordField[] managePassword = { pwManagePassword, pwManageConfPassword };

		this.passwordField = managePassword;

		ComboBox list = new ComboBox("listAdmin", 190, 43, 339, 32);
		this.add(list);

		this.combo = list;

		/*
		 * Action to launch the search of an admin
		 */

		btnManageLaunch.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// create the object admin from the database according to its first name, 
					// last name and username selected in the drop down combo box search 

					String[] username = ((String) list.getSelectedItem()).split(" ");

					Admin adm = QueryAdmin.queryAdm.selectAdminInfo(username[2]);
					// add all the information in the TextField
					tfManageFirstname.setText(adm.getFirstname());
					tfManageLastname.setText(adm.getLastname());
					tfManageUsername.setText(adm.getUsername());
					pwManagePassword.setText("********");
					pwManageConfPassword.setText("********");

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});
		
		
		
		/*
		 * Action to create an admin
		 */
		
		btnManageCreate.addActionListener((ActionListener) new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			
				
				try {
					
					
					
				}catch (Exception ex) {
					
				}
				
			}
			
		});

		
		
		/*
		 * Action to modify Admin profile
		 */

		btnManageModifyProfile.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
//					ToDO

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});

		/*
		 * Action to modify Admin's password
		 */
		btnManageModifyPassWord.addActionListener((ActionListener) new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					
					
//					ToDO

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});

	}
}
