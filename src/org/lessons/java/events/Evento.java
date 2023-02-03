package org.lessons.java.events;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

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
	
	public void prenota(LocalDate data) throws Exception {
		if (dataAttuale.isBefore(data))
			throw new Exception();
		if (postiTotali <= postiPrenotati)
			throw new Exception();
		postiPrenotati++;
	}
	
	public void disdici(LocalDate data) throws Exception {
		if (dataAttuale.isBefore(data))
			throw new Exception();
		if (postiPrenotati < 1)
			throw new Exception();
		postiPrenotati--;		
	}
	
	@Override
	public String toString() {
		return "Evento [data evento= " + getDataFormattata(data) + ", titolo evento= " + titolo + "]";
	}
	
		// START - VALIDATIONS
	public void validazioneData(LocalDate data) throws Exception {
		if (dataAttuale.isBefore(data))
			throw new Exception();
	}
	
	public void validazionePostiTotali(int postiTotali) throws Exception {
		if (postiTotali < 1)
			throw new Exception();
	}
		// END - VALIDATIONS

		// START - GETTERS SETTERS
	public String getTitolo() {
		return titolo;
	}

	public LocalDate getData() {
		return data;
	}
	
	public String getDataFormattata(LocalDate data) {
		DateTimeFormatter formattaData = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);
		String dataFormattata = data.format(formattaData);
		return dataFormattata;
	}

	public int getPostiTotali() {
		return postiTotali;
	}

	public int getPostiPrenotati() {
		return postiPrenotati;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setData(LocalDate data) throws Exception {
		validazioneData(data);
		this.data = data;
	}
		// END - GETTERS SETTERS
	
	
	
}
