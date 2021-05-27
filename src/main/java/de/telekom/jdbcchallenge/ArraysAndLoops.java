package de.telekom.jdbcchallenge;

import java.util.Arrays;

public class ArraysAndLoops {
	
	// Initialisierungsmöglichkeiten
	String[] blumen = new String[] { "Tulpe", "Pfingstrose" , "Sonnenblume" };
	String[] gemuese = { "Tomate", "Gurke", "Karotte" };
	Pflanze[] baeume = new Pflanze[] { 	new Pflanze("Apfel", true),
										new Pflanze("Birne", true) };
	int[] zahlen = new int[10];

	
	void einfacheAusgaben() {
		zahlen[3] = 3;
		System.out.println(blumen[0]);
		System.out.println(gemuese[1]);
		System.out.println(baeume[0]);
	}

	
	void arrayInStringUmwandeln(Pflanze[] pflanzen) {

		String allePflanzenInEinemString;
		allePflanzenInEinemString = Arrays.toString(pflanzen);
		
		System.out.println(allePflanzenInEinemString);
	
	}
	
}
