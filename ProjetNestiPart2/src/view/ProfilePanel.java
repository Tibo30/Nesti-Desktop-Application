package view;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


import entities.Admin;
import model.QueryAdmin;
import tools.Check;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ProfilePanel extends JPanel {
	
/**
	 * 
	 */
private static final long serialVersionUID = 1L; 
public static Label[] label;
public static TextField[] textField;
public static PasswordField[] passwordField;
public static Button[] button;
public static JTabbedPane TabbedPane;
private TextField tfProfilUsername;
private TextField tfProfilFirstname;
private TextField tfProfilLastname;
private PasswordField profilPassword;
private PasswordField profilConfirmPassword;
private PasswordField profilNewPassword;
private Button btnProfilModifyProfile;
private Button btnProfilSaveProfile;
private Button btnProfilModidyPassword;
private Button btnProfilSavePassword;
private int idAdminSelected;
	


	public ProfilePanel() throws Exception {
		
		this.setBackground(new Color(213,167,113));
		//FlowLayout flowLayout = (FlowLayout) this.getLayout();
		this.setLayout(null);

		//Buttons
		btnProfilModifyProfile = new Button("Profil_Modify_Profile", 175, 360, 125, 35);
		btnProfilModifyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnProfilSaveProfile.setVisible(true);
				btnProfilModifyProfile.setVisible(false);
				tfProfilFirstname.setEnabled(true);
				tfProfilLastname.setEnabled(true);
				tfProfilUsername.setEnabled(true);
			
				
			}
		});
		
		this.add(btnProfilModifyProfile);
		
		btnProfilSaveProfile = new Button("Profil_Save_Profil", 175, 360, 125, 35);
		btnProfilSaveProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnProfilSaveProfile.setVisible(false);
				btnProfilModifyProfile.setVisible(true);
				tfProfilFirstname.setEnabled(false);
				tfProfilLastname.setEnabled(false);
				tfProfilUsername.setEnabled(false);
				
try {
					
					// 1)Get the data (lastname, firstname, username, psw, confpsw)
					String lastname = tfProfilLastname.getText();
					String firstname = tfProfilFirstname.getText();
					String username = tfProfilUsername.getText();
					
					// 2) Check the validity of textfields and passwordfilds

					if (Check.isValidLogin(username) == false) {

						JOptionPane.showMessageDialog(null, "Username is incorrect", "Modification aborded",
								JOptionPane.ERROR_MESSAGE);

					} else if (Check.isValidName(lastname) == false) {

						JOptionPane.showMessageDialog(null, "Last name is incorrect", "Modification aborded",
								JOptionPane.ERROR_MESSAGE);

					} else if (Check.isValidName(firstname) == false) {

						JOptionPane.showMessageDialog(null, "First name is incorrect", "Modification aborded",
							JOptionPane.ERROR_MESSAGE);
				
				}else {
					
					// 3) Query

					Admin adm = new Admin(lastname, firstname, username, null, "Unblocked");
					QueryAdmin qa = new QueryAdmin();
													

					// 4) traiter la réponse

					if (qa.createPrepared(adm) == false) {

						JOptionPane.showMessageDialog(null, "Error in Admin modification", "Modification aborded",
								JOptionPane.ERROR_MESSAGE);

					} else {

						JOptionPane.showMessageDialog(null, "Admin was successfully modified", "Modification succeded",
								JOptionPane.INFORMATION_MESSAGE);

					}
					;

				}
			} catch (Exception ex) {

				JOptionPane.showMessageDialog(null, ex.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);

			}
				
			}
		});
		btnProfilSaveProfile.setVisible(false);
		this.add(btnProfilSaveProfile);
		
		btnProfilModidyPassword = new Button("Profil_Modify_Password", 439, 360, 149, 35);
		btnProfilModidyPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnProfilSavePassword.setVisible(true);
				btnProfilModidyPassword.setVisible(false);
				profilPassword.setEnabled(true);
				profilNewPassword.setEnabled(true);
				profilConfirmPassword.setEnabled(true);
				
				
				
				
				
				
			}
		});
		
		this.add(btnProfilModidyPassword);
		
		btnProfilSavePassword = new Button("Profil_Save_Password", 439, 360, 149, 35);
		btnProfilSavePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnProfilSavePassword.setVisible(false);
				btnProfilModidyPassword.setVisible(true);
				profilPassword.setEnabled(false);
				profilNewPassword.setEnabled(false);
				profilConfirmPassword.setEnabled(false);
				
				//ajouter un insert si modification du mot de passe
				
try {
					char[] psw = profilPassword.getPassword();
					char[] confpsw = profilConfirmPassword.getPassword();
					char[] newpsw = profilNewPassword.getPassword();
				
					if (Check.isValidPsw(psw) == false) {

						JOptionPane.showMessageDialog(null, "Password is incorrect", "Update password aborded",
								JOptionPane.ERROR_MESSAGE);
						

					} else if (!Check.isValidConf(newpsw, confpsw)) {

						JOptionPane.showMessageDialog(null, "Confirmation password doesn't match", "Update password aborded",
								JOptionPane.ERROR_MESSAGE);
					}else {
						
						QueryAdmin qa = new QueryAdmin();
						
						if(qa.updatePasswordPrepared(psw, idAdminSelected )) {
							JOptionPane.showMessageDialog(null, "Password was succussfully changed", "Update password", JOptionPane.INFORMATION_MESSAGE);
							
						}else {
							JOptionPane.showMessageDialog(null, "Password was not changed", "Update password aborded", JOptionPane.ERROR_MESSAGE);
							
						}
						
						
					}

				} catch (Exception e1) {

					e1.printStackTrace();
				}
					
				
				
				
				
			}
		});
		btnProfilSavePassword.setVisible(false);
		this.add(btnProfilSavePassword);
	
		
		//Button[] profileButton = {btnProfilModifyProfile,btnProfilModidyPassWord,btnProfilSavePassword,btnProfilSaveProfil };
		//this.button= profileButton;
		
		//Labels
		Label lblProfilFirstname = new Label("FirstName", 175, 95, 160, 20);
		this.add(lblProfilFirstname);
		Label lblProfilLastname = new Label("LastName", 173, 147, 162, 20);
		this.add(lblProfilLastname);
		Label lblProfilUsername = new Label("UserName", 174, 201, 161, 20);
		this.add(lblProfilUsername);
		Label lblProfilPassword = new Label("Password", 439, 95, 138, 14);
		this.add(lblProfilPassword);
		Label lblProfilNewPassword = new Label("New password", 439, 142, 138, 22);
		this.add(lblProfilNewPassword);
		Label lblProfilConfirmPassword = new Label("Confirm password", 439, 198, 138, 14);
		this.add(lblProfilConfirmPassword);

		//Label[] profileLabel= {lblProfilFirstname,lblProfilLastname, lblProfilUsername,lblProfilPassword,lblProfilNewPassword,lblProfilConfirmPassword};
		//this.label = profileLabel;
		
		//TextFields
		tfProfilFirstname = new TextField("profilFirstname", 175, 116, 160, 20);
		tfProfilFirstname.setEnabled(false);
		this.add(tfProfilFirstname);
		tfProfilLastname = new TextField("profilLastname", 175, 170, 160, 20);
		tfProfilLastname.setEnabled(false);
		this.add(tfProfilLastname);
		tfProfilUsername = new TextField("profilUsername", 175, 223, 160, 20);
		tfProfilUsername.setEnabled(false);
		this.add(tfProfilUsername);
		//TextField[] ProfilTextField = {tfProfilFirstname, tfProfilLastname, tfProfilUsername};
		//this.textField= ProfilTextField;

		//PasswordFields
		profilPassword = new PasswordField("Profil Password", 439, 113, 138, 20);
		profilPassword.setEnabled(false);
		this.add(profilPassword);
		profilNewPassword = new PasswordField("Profil NewPassword", 439, 167, 138, 20);
		profilNewPassword.setEnabled(false);
		this.add(profilNewPassword);
		profilConfirmPassword = new PasswordField("Profil Conform Password", 439, 220, 138, 20);
		profilConfirmPassword.setEnabled(false);
		this.add(profilConfirmPassword);
		//PasswordField[] profilePasswordField = {profilPassword, profilNewPassword, profilConfirmPassword, profilConfirmPassword};
		//this.passwordField= profilePasswordField; 
		
		this.showAdminInfo();
	
	}
		
	/**
	 * Function to show admin informations after connection
	 */
	private void showAdminInfo() {
		// récuperer id de l'admin
		
		int id = LoginFrame.id;
		
		//requête select pour avoir les infos de l'objet de type admin
		QueryAdmin qa = new QueryAdmin();
		try {
			 Admin admin=qa.selectAdminInfoById(id);
			this.tfProfilUsername.setText(admin.getUsername());
			this.tfProfilFirstname.setText(admin.getFirstname());
			this.tfProfilLastname.setText(admin.getLastname());
			this.profilPassword.setText(admin.getPassword());
			this.profilConfirmPassword.setText(admin.getPassword());
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		// expl : profile textfield : setText()=
		
		// A la connexion 
	}

}
