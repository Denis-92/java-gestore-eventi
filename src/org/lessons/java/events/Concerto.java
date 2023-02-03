package org.lessons.java.events;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento {
	
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	private LocalTime ora;
	private BigDecimal prezzo;
	
	public Concerto (String titolo, LocalDate data, int postiTotali, LocalTime ora, BigDecimal prezzo) throws Exception {
		super(titolo, data, postiTotali);
		this.ora = ora;
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Concerto [ data concerto= " +
				getDataFormattata(getData()) +
				", ora concerto= " +
				getOraFormattata(ora) +
				", titolo concerto= " +
				getTitolo() +
				", prezzo biglietto= " +
				df.format(prezzo) +
				"€ ]";
	}
	
	
		// START - GETTERS SETTERS
	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	
	public String getOraFormattata(LocalTime ora) {
		DateTimeFormatter formattaOra = DateTimeFormatter.ofPattern("hh:mm").withLocale(Locale.ITALY);
		String oraFormattata = ora.format(formattaOra);
		if (ora.getHour() > 12)
			return oraFormattata + " PM";
		else
			return oraFormattata + " AM";
	}

	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
//	public String getPrezzoFormattato(BigDecimal prezzo) {
//		
//	}
		// END - GETTERS SETTERS

}
