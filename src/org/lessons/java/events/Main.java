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
		
		System.out.println("Oggetto test evento: " + eventoTest.toString());
		
		
		inputContainer.close();
		// Chiuso inputContainer
		
	}

}
