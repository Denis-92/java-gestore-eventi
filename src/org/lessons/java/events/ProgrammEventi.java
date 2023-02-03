package org.lessons.java.events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {
	
	private String titolo;
	private List<Evento> eventi;
	
	public ProgrammEventi (Evento evento) {
		this.titolo = evento.getTitolo();
		eventi = new ArrayList<>();
	}
	
	public void addEventoToList (Evento evento) {
		eventi.add(evento);
	}
	
	// TODO - IMPLEMENTARE IL CONTROLLO SE DATA == TRUE
	public List<Evento> getEventiPerDate(LocalDate data) {
		List<Evento> eventiodierni = new ArrayList<>();
		for (int i = 0; i < eventi.size(); i++) {
			if (true)
				eventiodierni.add(eventi.get(i));
			}
		return eventiodierni;
	}
	
	public int getNumeroEventi() {
		return eventi.size();
	}
	
	public void deleteEventi() {
		for (int i = 0; i < eventi.size(); i++) {
			eventi.remove(i);
		}
	}

}
