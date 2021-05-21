package main;

import java.awt.EventQueue;

import model.MyConnection;
import view.LoginFrame;

public class Main {

public static void main(String[] args) {
		
		MyConnection co= new MyConnection();
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	try {
		co.closeConnection();
	} catch (Exception e) {
		System.err.println("Erreur à la fermeture de la connexion");
		e.printStackTrace();
	}
}
}
