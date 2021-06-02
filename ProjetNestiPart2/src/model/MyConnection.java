package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class MyConnection {
	static Connection accessDataBase = null;
	protected String login;
	private String mdp;
	private String bdd;

	/**
	 * Testons la connexion
	 * 
	 * @param args
	 */
	/*
	 */
	public MyConnection() {
		setUrl("jdbc:mysql://" + Config.HOSTNAME + "/" + Config.DATABASE);
		setLogin(Config.USERNAME);
		setMdp(Config.PASSWORD);

	}

	/**
	 * Connection to database NESTI
	 * 
	 * @throws Exception
	 * 
	 * @throws SQLException
	 */
	public void openConnection() throws Exception {

		try {
			System.out.println("try to connect");
			// we add the parameters
			accessDataBase = DriverManager.getConnection(getUrl(), getLogin(), getMdp());
		} catch (SQLException ex) {
			throw new Exception("Erreur connexion");
		}
	}

	/**
	 * True if connection is successful
	 *
	 * @return
	 * @throws Exception
	 */
	public boolean testConnection() throws Exception {
		boolean flag = false;
		try {
			if (accessDataBase != null) {
				if (!accessDataBase.isClosed()) {
					System.out.println("Connexion au serveur... OK");
					flag = true;
				}
			}
		} catch (SQLException ex) {
			throw new Exception("Erreur test");
		}
		return flag;
	}

	public void closeConnection() {
		if (accessDataBase != null) {
			try {
				accessDataBase.close();
				System.out.println("Close connection");
			} catch (SQLException e) {
				System.out.println("Erreur de fermeture");
			}
		}
	}

	private String url;

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the bdd
	 */
	public String getBdd() {
		return bdd;
	}

	/**
	 * @param bdd the bdd to set
	 */
	public void setBdd(String bdd) {
		this.bdd = bdd;
	}

}
