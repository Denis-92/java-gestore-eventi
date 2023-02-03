package org.lessons.java.events;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Benvenuto! Inserisci i dati dell'evento:");
			
		// Aperto inputContainer
		Scanner inputContainer = new Scanner(System.in);
		
		Evento eventoTest = null;
		
		try {
			System.out.print("Titolo evento: ");
			String titolo = inputContainer.nextLine();
			
			System.out.print("Data dell'evento (inserire anno 4 cifre): ");
			int dataAnno = Integer.parseInt(inputContainer.nextLine());
			
			System.out.print("Data dell'evento (inserire mese da 1 a 12): ");
			int dataMese = Integer.parseInt(inputContainer.nextLine());
			
			System.out.print("Data dell'evento (inserire giorno): ");
			int dataGiorno = Integer.parseInt(inputContainer.nextLine());
			
			LocalDate dataEvento = LocalDate.of(dataAnno, dataMese, dataGiorno);
			
			System.out.print("Posti totali: ");
			int postiTotali = Integer.parseInt(inputContainer.nextLine());
		
			eventoTest = new Evento(titolo, dataEvento, postiTotali);
				
		} catch (Exception e) {
			System.out.println("Errore: uno o più campi non sono stati inseriti o non sono validi!");
			e.printStackTrace();
		}
		
		//System.out.println("Oggetto test evento: " + eventoTest.toString());
		
		int postiPrenotati = 0;
		boolean farePrenotazione = true;
		
		while (farePrenotazione) {
			try {
				System.out.print("Vuoi prenotare dei posti? (s/n)");
				farePrenotazione = inputContainer.nextLine().equals("s");
				if (farePrenotazione) {
					System.out.print("Quanti posti vuoi prenotare? ");
					postiPrenotati = Integer.parseInt(inputContainer.nextLine());
					if (postiPrenotati < 1 || postiPrenotati > eventoTest.getPostiTotali())
						System.out.println("Numero non valido, intervallo accettato da 1 a " + eventoTest.getPostiTotali());
					else
						farePrenotazione = false;
				}
				
			} catch (Exception error) {
				System.out.println("Input non valido. Inserire solo un numero intero!");
			}
		}
		
		LocalDate adesso = LocalDate.now();
		
		for (int i=0; i < postiPrenotati; i++) {
			try {
				eventoTest.prenota(adesso);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Posti prenotati: " + eventoTest.getPostiPrenotati());
		System.out.println("Posti disponibili: " + eventoTest.getPostiDisponibili());
		
		int postiRestituiti= 0;
		boolean fareDisdetta = true;
		
		while (fareDisdetta) {
			try {
				System.out.print("Vuoi disdire dei posti? (s/n)");
				fareDisdetta = inputContainer.nextLine().equals("s");
				if (fareDisdetta) {
					if (postiPrenotati < 1) {
						System.out.println("Non ci sono posti prenotati, non è possibile effettuare una disdetta...");
						fareDisdetta = false;
					} else {
						System.out.print("Quanti posti vuoi disdire? ");
						postiRestituiti = Integer.parseInt(inputContainer.nextLine());
						if (postiRestituiti < 1 || postiRestituiti > eventoTest.getPostiPrenotati())
							System.out.println("Numero non valido, intervallo accettato da 1 a " + eventoTest.getPostiPrenotati());
						else
							fareDisdetta = false;
					}
				}
				
			} catch (Exception error) {
				System.out.println("Input non valido. Inserire solo un numero intero!");
			}
		}
		
		for (int i=0; i < postiRestituiti; i++) {
			try {
				eventoTest.disdici(adesso);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Posti prenotati: " + eventoTest.getPostiPrenotati());
		System.out.println("Posti disponibili: " + eventoTest.getPostiDisponibili());

		LocalTime testOra = LocalTime.of(16, 19);
		BigDecimal prezzo = new BigDecimal ("15.5784");
		Concerto concertoTest = null;
		try {
			concertoTest = new Concerto("titoloTest", eventoTest.getData(), eventoTest.getPostiTotali(), testOra, prezzo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Oggetto test concerto: " + concertoTest.toString());
		
		System.out.println("Programma terminato!");
		
		inputContainer.close();
		// Chiuso inputContainer
		
	}

}
