package de.telekom.jdbcchallenge;

public class Pflanze {
	
	private String name;
	private Boolean obBaum;
	
	// Construktor
	public Pflanze(String name, Boolean obBaum) {
		this.name=name;
		this.obBaum=obBaum;
	}
	
	@Override
	public String toString() {
		return this.name + " " + " Baum = " + this.obBaum;
	}
}
