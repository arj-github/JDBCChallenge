package de.telekom.jdbcchallenge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			String prepared;
			String injection;
			Connection connection = DriverManager.getConnection(URL);
			Statement statement = connection.createStatement();
			PreparedStatement prepStatement; 
			ResultSet resultSet = statement.executeQuery("select count(*) from personen");
			

			while (resultSet.next()) {
				System.out.println("Es gibt " + resultSet.getInt(1) + " einträge in der Tabelle personen.");
				System.out.println("delete from personen where id=6");
				System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			}
			
			statement.execute("delete from personen where id=6");
			
			resultSet = statement.executeQuery("select * from personen");
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1));
				System.out.print(resultSet.getInt(2));
				System.out.print(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
			}
			
			System.out.println("insert into personen (id, anrede, vorname, nachname) values (6,2,'uli','oli')");
			System.out.println("vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv");
			
			statement.execute("insert into personen (id, anrede, vorname, nachname) values (6,2,'uli','oli')");
			
			resultSet = statement.executeQuery("select * from personen");
			while (resultSet.next()) {
				System.out.print(resultSet.getInt(1));
				System.out.print(resultSet.getInt(2));
				System.out.print(resultSet.getString(3));
				System.out.println(resultSet.getString(4));
			}
			
			
			//INJECTION and PreparedStatement
			var id = 7l;
			Short anrede = 1;
			var vorname = "Patrik)'; select * from personen;";
			var nachname ="Alt)'; select * from personen;--'";
			
			
//			statement.execute("insert into personen (id, anrede, vorname, nachname) values (" + id + "," + anrede + ",'" + vorname + "'," + "'" + nachname +"'");
			

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
	}
}
