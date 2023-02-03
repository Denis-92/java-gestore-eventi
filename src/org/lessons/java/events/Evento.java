package org.lessons.java.events;

import java.time.LocalDate;

public class Evento {
	
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	
	public Evento (String titolo, LocalDate data, int postiTotali) {
		this.titolo = titolo;
		this.data = data;
		this.postiTotali = postiTotali;
		this.postiPrenotati = 0;
	}
}
