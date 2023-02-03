package org.lessons.java.events;

import java.time.LocalDate;
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

		System.out.println("Programma terminato!");
		
		inputContainer.close();
		// Chiuso inputContainer
		
	}

}
