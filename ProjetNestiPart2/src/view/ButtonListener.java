package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.QueryUser;

public class ButtonListener implements ActionListener {
	String text;
	ValueNeeded object;
	private QueryUser queryLogin = new QueryUser("127.0.0.1", "root", "", "nesti");
		public ButtonListener() {
		}
			public ButtonListener(String name, ValueNeeded object) {
				this.text = name;
				this.object = object;
				}

				public void actionPerformed(ActionEvent e) {

				}
		}


