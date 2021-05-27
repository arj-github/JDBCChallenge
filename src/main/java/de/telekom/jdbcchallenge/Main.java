package de.telekom.jdbcchallenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Driverstring für den mysql Driver - muss man raussuchen
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		try {

			// unverzichtbar - keine Ahnung warum?
			Class.forName(DRIVER);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// AdressString für den DB-Zugriff
		final String URL = "jdbc:mysql://localhost:3306/seadb?user=seauser&password=seapass";

		try {

			Connection connection = DriverManager.getConnection(URL);
			Statement statement = connection.createStatement();
			PreparedStatement prepStatement; 
			ResultSet resultSet = statement.executeQuery("select count(*) from personen");
			

			while (resultSet.next()) {
				System.out.println("Es gibt " + resultSet.getInt(1) + " einträge in der Tabelle personen.");
				System.out.println("delete from personen where vorname in ('Patrik', 'uli')");
				System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			}
			
			statement.execute("delete from personen where vorname in ('Patrik', 'uli') ");

			resultSet = statement.executeQuery("select * from personen");
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1));
				System.out.print(resultSet.getInt(2));
				System.out.print(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
			}
			
			System.out.println("insert into personen (id, anrede, vorname, nachname) values (6,2,'Patrik','oli')");
			System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			
			statement.execute("insert into personen (id, anrede, vorname, nachname) values (6,2,'Patrik','oli')");
			
			resultSet = statement.executeQuery("select * from personen");
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1));
				System.out.print(resultSet.getInt(2));
				System.out.print(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
			}
			
			
			//INJECTION and PreparedStatement
			var id = 9l;
			Short anrede = 1;
			var vorname = "Patrik";
			var nachname ="Blub');";
			
			String injection = "INSERT INTO personen ("
					+ " id,"
					+ " anrede,"
					+ " vorname,"
					+ " nachname ) VALUES ("
					+ 10
					+ ","
					+ anrede
					+ ", '"
					+ vorname
					+ "',"
					+ "'"
					+ nachname
					+ "";
					
			// 	Vorbeugung der Injection!!! - Patrik Alt') wird als String und nicht sql-Abschluss interpr.
			String prepQuery = "INSERT INTO personen ("
					+ " id,"
					+ " anrede,"
					+ " vorname,"
					+ " nachname ) VALUES ("
					+ "?, ?, ?, ?)";
			

			
			prepStatement = connection.prepareStatement(prepQuery);
			prepStatement.setLong(1, id);
			prepStatement.setShort(2, anrede);
			prepStatement.setString(3, vorname);
			prepStatement.setString(4, nachname);
			prepStatement.executeUpdate();
			
			
			// Bei Injection wirkt Alt') als abschluss eines sqls
			System.out.println(injection);
			statement.execute(injection);

			

			resultSet = statement.executeQuery("select * from personen");
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1));
				System.out.print(resultSet.getInt(2));
				System.out.print(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
			}

			// Alles schließen
			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

/////////////////////////////////////

// Arrays and Loops

/////////////////////////////////////		

		ArraysAndLoops aal = new ArraysAndLoops();
		String[] beete = {"Blumenbeet", "Gemüsebeet"};
		String[] blumen = new String[] { "Tulpe", "Pfingstrose", "Sonnenblume", "Rose" };
		String[] gemuese = { "Tomate", "Gurke", "Karotte" };
		Pflanze[] baeume = new Pflanze[] { new Pflanze("Apfel", true), new Pflanze("Birne", true) };

		String[][] garten = { blumen, gemuese, beete };

		System.out.println(gemuese[1]);
		System.out.println(baeume[0]);
		/*
		 * Ausgabe Gurke Apfel Baum = true
		 */

		aal.arrayInStringUmwandeln(baeume);
		/*
		 * Ausgabe [Apfel Baum = true, Birne Baum = true]
		 */

		System.out.println(garten[0]);
		/*
		 * [Ljava.lang.String;@1ee0005
		 */

		System.out.println(Arrays.toString(garten[0]));
		/*
		 * [Tulpe, Pfingstrose, Sonnenblume]
		 */

		System.out.println(garten[0][2]);
		/*
		 * Sonnenblume
		 */

		System.out.println(garten.length); // 2
		System.out.println(blumen.length); // 4
		System.out.println(garten[0].length); // garten[0]=blumen -> 4

// Dauerhaft umsortiert		
		Arrays.sort(blumen);
		System.out.println(Arrays.toString(garten[0]));
// [Pfingstrose, Rose, Sonnenblume, Tulpe]
		System.out.println(garten[0][0]);
		System.out.println(blumen[0]);
//Pfingstrose
//Pfingstrose		

// For
		for (int i = 0; i < blumen.length; i++) {
			System.out.println(blumen[i]);
		}
//Pfingstrose
//Rose
//Sonnenblume
//Tulpe	

		var i = 0;
		while (++i != 10) {
			System.out.print(i);
		}
//123456789

// foreach - Array
		for (String blume : blumen) {

			System.out.println(blume);

		}

		// Rose
		// Sonnenblume
		// Tulpe

		
		// Iteration durch alle Beete und Pflanzen
	
		System.out.println("Mein Garten");
		i=0;
		for (int j=0; j<(garten.length-1) ; j++) {
			System.out.println(garten[2][i++]);
			for (String pflanze : (garten[j])) {

				System.out.print(String.format(" %s", pflanze));
				System.out.println();
			}
		
		}
//		Mein Garten
//		Blumenbeet
//		 Pfingstrose
//		 Rose
//		 Sonnenblume
//		 Tulpe
//		Gemüsebeet
//		 Tomate
//		 Gurke
//		 Karotte
		
	}

}
// Class End
