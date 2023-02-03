package org.lessons.java.events;

public class Evento {
	
	private String titolo;
	private String data;
	private int postiTotali;
	private int postiPrenotati;
	
	public Evento (String titolo, String data, int postiTotali) {
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
	}
}
