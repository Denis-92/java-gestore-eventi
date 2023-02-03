package org.lessons.java.events;

import java.time.LocalDate;

public class Evento {
	
	private String titolo;
	private LocalDate data;
	private int postiTotali;
	private int postiPrenotati;
	private LocalDate dataAttuale = LocalDate.now();
	
	public Evento (String titolo, LocalDate data, int postiTotali) throws Exception {
		this.titolo = titolo;
		this.data = data;
		validazioneData(data);
		this.postiTotali = postiTotali;
		validazionePostiTotali(postiTotali);
		this.postiPrenotati = 0;
	}
	
	public void validazioneData(LocalDate data) throws Exception {
		if (dataAttuale.isBefore(data))
			throw new Exception();
	}
	
	public void validazionePostiTotali(int postiTotali) throws Exception {
		if (postiTotali < 1)
			throw new Exception();
	}
	
}
