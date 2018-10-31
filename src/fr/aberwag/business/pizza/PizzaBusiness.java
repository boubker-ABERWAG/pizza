package fr.aberwag.business.pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.catalina.util.LifecycleMBeanBase;

import fr.aberwag.bean.Pizza;

public class PizzaBusiness {



	public ArrayList<Pizza> getPizzas(){

		ArrayList<Pizza> liste = new ArrayList<>();
		try {
			//DRiver
			Class.forName("org.mariadb.jdbc.Driver");
			//Connection
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pizzeria", "root", "");

			// Execution de la request sql
			Statement statement = cnx.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT id, libelle, reference, prix, url_image FROM pizza");

			while (resultat.next()) {
				Integer id = resultat.getInt("id");
				String libelle = resultat.getString("libelle");
				String ref = resultat.getString("reference");
				Integer prix = resultat.getInt("prix");
				String url = resultat.getString("url_image");

				Pizza p = new Pizza(id, libelle, ref, prix, url);
				liste.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return liste;
	}


	public void ajoutPizza(String libelle, String ref, Integer prix , String url) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pizzeria", "root", "");

			PreparedStatement ps = cnx.prepareStatement("INSERT INTO pizza(libelle, reference, prix, url_image) VALUES(?,?,?,?)");
			ps.setString(1, libelle);
			ps.setString(2, ref);
			ps.setInt(3, prix);
			ps.setString(4, url);

			ps.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Pizza getPizzaById(Integer id) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pizzeria", "root", "");

			PreparedStatement ps = cnx.prepareStatement("SELECT id,libelle, reference, prix, url_image FROM pizza WHERE id = ?");
			ps.setInt(1, id);
			ResultSet resultat = ps.executeQuery();
			while (resultat.next()) {
				Integer idBD = resultat.getInt("id");
				String libelle = resultat.getString("libelle");
				String ref = resultat.getString("reference");
				Integer prix = resultat.getInt("prix");
				String url = resultat.getString("url_image");

				Pizza p = new Pizza(idBD, libelle, ref, prix, url);
				return p;
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void modifierPizza(String libelle, String ref, Integer prix , String url, Integer id) {

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			Connection cnx = DriverManager.getConnection("jdbc:mariadb://localhost:3306/pizzeria", "root", "");

			PreparedStatement ps = cnx.prepareStatement("UPDATE pizza SET libelle = ?, reference = ?, prix = ?, url_image=? WHERE id = ?");
			ps.setString(1, libelle);
			ps.setString(2, ref);
			ps.setInt(3, prix);
			ps.setString(4, url);
			ps.setInt(5, id);

			ps.executeUpdate();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
