package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventObject;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import components.Button;
import components.Label;
import components.PasswordField;
import components.TextField;
import entities.Admin;
import model.QueryAdmin;
import tools.Check;
import view.TabbedPaneChangeListener;

/**
 * 
 * @author SAL.BEDDEK
 *
 */
public class ManagePanel extends JPanel {

	/**
	 * Class Attributes
	 */
	private static final long serialVersionUID = 1L;
	public static JComboBox<Admin> combo;
	public static JTabbedPane TabbedPane;
	private PasswordField pwManagePassword;
	private PasswordField pwManageConfPassword;
	private TextField tfManageUsername;
	private TextField tfManageLastname;
	private TextField tfManageFirstname;
	private Button btnManageBlockAdmin;
	private Button btnManageLaunch;
	private Button btnManageCreate;
	private Button btnManageModifyProfile;
	private Button btnManageModifyPassWord;
	private int idAdminSelected;

	/**
	 * Constructor of the panel "Manage"
	 * 
	 * @throws Exception
	 */

	public ManagePanel() throws Exception {
<<<<<<< Updated upstream
		
=======
	//	Admin adm = new Admin();
		
	//	if (adm.isSuperAdmin() == true) {

>>>>>>> Stashed changes
			this.setBackground(new Color(213, 167, 113));
			this.setLayout(null);

			// Buttons
			btnManageModifyProfile = new Button("Manage_Modify_Profile", 154, 372, 138, 29);
			this.add(btnManageModifyProfile);
			btnManageModifyPassWord = new Button("Manage_Modify_PassWord", 507, 372, 147, 34);
			this.add(btnManageModifyPassWord);
			btnManageBlockAdmin = new Button("Manage_Block / Unblock", 324, 315, 147, 29);
			this.add(btnManageBlockAdmin);
			btnManageLaunch = new Button("Manage_Launch", 539, 48, 86, 23);
			this.add(btnManageLaunch);
			btnManageCreate = new Button("Create Profile", 344, 372, 113, 32);
			this.add(btnManageCreate);

			// labels
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

			// TextFields
			this.tfManageFirstname = new TextField("manageFirstname", 59, 151, 160, 20);
			this.add(tfManageFirstname);
			this.tfManageLastname = new TextField("manageLastname", 59, 205, 160, 20);
			this.add(tfManageLastname);
			this.tfManageUsername = new TextField("", 59, 258, 160, 20);
			this.add(tfManageUsername);

			// Passwords
			this.pwManagePassword = new PasswordField("Manage Password", 584, 159, 138, 20);
			this.add(pwManagePassword);
			this.pwManageConfPassword = new PasswordField("Manage Conf Password", 584, 212, 138, 20);
			this.add(pwManageConfPassword);

			// Combo
			combo = new JComboBox<>();
			combo.setBounds(190, 43, 339, 32);
			this.add(combo);

			/**
			 * ActionListener to launch the search of an admin
			 */
			btnManageLaunch.addActionListener((ActionListener) new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					handleManageLaunch();
				}

			});

			//

			/**
			 * ActionListener to block unblock an admin
			 */

			btnManageBlockAdmin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						Admin adm = (Admin) combo.getSelectedItem();
						QueryAdmin queryAdmin = new QueryAdmin();

						if (adm.isBlocked()) {
							queryAdmin.updateState(adm.getId(), "Unblocked");
							btnManageBlockAdmin.unblocked();
						} else {
							queryAdmin.updateState(adm.getId(), "Blocked");
							btnManageBlockAdmin.blocked();

						}

						actualizeManagePanel();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});

			/**
			 * ActionListener to create an admin
			 */

			btnManageCreate.addActionListener((ActionListener) new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					try {

						// 1)Get the data (lastname, firstname, username, psw, confpsw)

						String lastname = tfManageLastname.getText();
						String firstname = tfManageFirstname.getText();
						String username = tfManageUsername.getText();
						char[] psw = pwManagePassword.getPassword();
						char[] confpsw = pwManageConfPassword.getPassword();

						// 2) Check the validity of Textfields and Passwordfilds

						if (Check.isValidLogin(username) == false) {

							JOptionPane.showMessageDialog(null, "Please enter a valid username (At least 8 characters like : JohnDoe7)", "creation aborded", JOptionPane.ERROR_MESSAGE);

						} else if (Check.isValidName(lastname) == false) {

							JOptionPane.showMessageDialog(null, "Last name is incorrect", "creation aborded",
									JOptionPane.ERROR_MESSAGE);

						} else if (Check.isValidName(firstname) == false) {

							JOptionPane.showMessageDialog(null, "First name is incorrect", "creation aborded",
									JOptionPane.ERROR_MESSAGE);

						} else if (Check.isValidPsw(psw) == false) {

							JOptionPane.showMessageDialog(null, "Please enter a valid password (At least 8 characters like : Xxxyx@123)", "creation aborded", JOptionPane.ERROR_MESSAGE);

						} else if (!Check.isValidConf(psw, confpsw)) {

							JOptionPane.showMessageDialog(null, "Confirmation password doesn't match",
									"creation aborded", JOptionPane.ERROR_MESSAGE);

						} else {

							// 3) Query

							Admin adm = new Admin(lastname, firstname, username, String.valueOf(psw), "Unblocked");
							// Call the Qyery Objet (or model) "QueryAdmin"

							QueryAdmin qa = new QueryAdmin();

							// 4) Treat the answer

							if (qa.createPrepared(adm) == false) {

								JOptionPane.showMessageDialog(null, "Error in Admin insert", "creation aborded",
										JOptionPane.ERROR_MESSAGE);

							} else {

								JOptionPane.showMessageDialog(null, "Admin was successfully inserted",
										"creation succeded", JOptionPane.INFORMATION_MESSAGE);

							}
							;

						}
					} catch (Exception ex) {

						JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);

					}

				}

			});

			/**
			 * ActionListener to modify Admin profile
			 */

			btnManageModifyProfile.addActionListener((ActionListener) new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					try {

//					
						// 1)Get the data (lastname, firstname, username, psw, confpsw)

						String lastname = tfManageLastname.getText();
						String firstname = tfManageFirstname.getText();
						String username = tfManageUsername.getText();

						// 2) Check the validity of Textfields

						if (Check.isValidLogin(username) == false) {

							JOptionPane.showMessageDialog(null, "Username is incorrect", "Creation aborded",
									JOptionPane.ERROR_MESSAGE);

						} else if (Check.isValidName(lastname) == false) {

							JOptionPane.showMessageDialog(null, "Last name is incorrect", "Creation aborded",
									JOptionPane.ERROR_MESSAGE);

						} else if (Check.isValidName(firstname) == false) {

							JOptionPane.showMessageDialog(null, "First name is incorrect", "Creation aborded",
									JOptionPane.ERROR_MESSAGE);

						} else {

							Admin adm = new Admin(lastname, firstname, username, null, "Unblocked");

							adm.setId(idAdminSelected);

							QueryAdmin qa = new QueryAdmin();

							if (qa.updatePrepared(adm) == false) {

								JOptionPane.showMessageDialog(null, "Error in Admin modification",
										"Modification aborded", JOptionPane.ERROR_MESSAGE);

							} else {

								JOptionPane.showMessageDialog(null, "Admin was successfully modified",
										"Modification succeded", JOptionPane.INFORMATION_MESSAGE);

								actualizeManagePanel();
							}
							;

						}

					} catch (Exception e1) {

						e1.printStackTrace();
					}

				}
			});

			/**
			 * ActionListener to modify Admin's password
			 */
			btnManageModifyPassWord.addActionListener((ActionListener) new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {

						char[] psw = pwManagePassword.getPassword();
						char[] confpsw = pwManageConfPassword.getPassword();
						System.out.println(psw);
						if (Check.isValidPsw(psw) == false) {

							JOptionPane.showMessageDialog(null, "Password is incorrect", "Update password aborded",
									JOptionPane.ERROR_MESSAGE);

						} else if (!Check.isValidConf(psw, confpsw)) {

							JOptionPane.showMessageDialog(null, "Confirmation password doesn't match",
									"Update password aborded", JOptionPane.ERROR_MESSAGE);
						} else {

							QueryAdmin qa = new QueryAdmin();

							if (qa.updatePasswordPrepared(psw, idAdminSelected)) {
								JOptionPane.showMessageDialog(null, "Password was succussfully changed",
										"Update password", JOptionPane.INFORMATION_MESSAGE);

							} else {
								JOptionPane.showMessageDialog(null, "Password was not changed",
										"Update password aborded", JOptionPane.ERROR_MESSAGE);

							}

						}

					} catch (Exception e1) {

						e1.printStackTrace();
					}
				}
			});

			actualizeManagePanel();

<<<<<<< Updated upstream
	}
=======
		} //else {
		//	JOptionPane.showMessageDialog(null, "You can't access the Manage Tab", "Access denied",
		//			JOptionPane.INFORMATION_MESSAGE);
		//}
//	}
>>>>>>> Stashed changes

	/**
	 * Function to handle the launch button
	 */

	private void handleManageLaunch() {

		try {

			// create the object admin from the database according to its first name,
			// last name and username selected in the drop down combo box search

			System.out.println(combo.getSelectedItem());
			idAdminSelected = 0;
			if (combo.getSelectedItem() != null) {

				Admin adm = (Admin) combo.getSelectedItem();

				if (adm.getUsername() == null) {
					// creation
					tfManageLastname.clear();
					tfManageFirstname.clear();
					tfManageUsername.clear();
					btnManageCreate.setEnabled(true);
					btnManageModifyProfile.setEnabled(false);
					btnManageModifyPassWord.setEnabled(false);
				} else {

					// modification
					if (adm.getState().equals("Blocked")) {
						btnManageBlockAdmin.blocked();
					} else {
						btnManageBlockAdmin.unblocked();
					}
					btnManageCreate.setEnabled(false);
					btnManageModifyProfile.setEnabled(true);
					btnManageModifyPassWord.setEnabled(true);

					// add all the information in the TextField
					tfManageFirstname.setText(adm.getFirstname());
					tfManageLastname.setText(adm.getLastname());
					tfManageUsername.setText(adm.getUsername());
					idAdminSelected = adm.getId();
				}

			}

		} catch (Exception e1) {
			System.err.println("message base de donnée non connectée");

			e1.printStackTrace();
		}

	}

	/**
	 * Function to actualize the Manage panel and create new Admin
	 * 
	 * @throws Exception
	 */

	public static void actualizeManagePanel() throws Exception {
		Admin adm1 = new Admin();
		adm1.setLastname("Create New Admin");
		int admSelected = combo.getSelectedIndex();
		QueryAdmin queryAdmin = new QueryAdmin();
		ArrayList<Admin> listAdmin = queryAdmin.listAllAdmin();
		combo.removeAllItems();
		combo.addItem(adm1);

		System.out.println("ManagePanelAdmin");
		try {

			for (int i = 0; i < listAdmin.size(); i++) {

				ManagePanel.combo.addItem(listAdmin.get(i));

			}
			combo.setSelectedIndex(admSelected);

		} catch (Exception e1) {
			e1.printStackTrace();

		}
		combo.setSelectedIndex(0);
	}

}
