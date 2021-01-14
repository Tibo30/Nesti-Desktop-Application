package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.QueryAdmin;

public class ButtonListener implements ActionListener {
	String text;
	ValueNeeded object;
	private QueryAdmin queryLogin = new QueryAdmin("127.0.0.1", "root", "", "nesti");
		public ButtonListener() {
		}
			public ButtonListener(String name) {
				this.text = name;
			
				}

				public void actionPerformed(ActionEvent e) {
					switch (text) {
					case "Profil_Modify_Profile":
							
					
						break;
					case "Profil_Modify_Password":
						
						
						break;
				}
		}


}