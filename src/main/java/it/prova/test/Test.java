package it.prova.test;

import java.util.Date;

import it.prova.dao.EntityManagerUtil;
import it.prova.model.Applicazione;
import it.prova.model.Marca;
import it.prova.model.Modello;
import it.prova.service.MyServiceFactory;
import it.prova.service.applicazione.IApplicazioneService;
import it.prova.service.marca.IMarcaService;
import it.prova.service.modello.IModelloService;

public class Test {
	
	public static void main(String[] args) {
		
		IMarcaService marcaServiceInstance = MyServiceFactory.getMarcaServiceInstance();
		IModelloService modelloServiceInstance = MyServiceFactory.getModelloServiceInstance();
		IApplicazioneService applicazioneServiceInstance = MyServiceFactory.getApplicazioneServiceInstance();
		
		try {
			
			/* ----------< TEST MARCA >---------- */
			
			Marca xiaomi = new Marca("Xiaomi", new Date(), 3);
			Marca xiaomi2 = marcaServiceInstance.caricaSingoloElemento(3L);
//			marcaServiceInstance.inserisciNuovo(xiaomi);
//			xiaomi.setNome("XIAOMI");
//			marcaServiceInstance.aggiorna(xiaomi);
//			System.out.println("TUTTE LE MARCHE: " + marcaServiceInstance.listAll());
//			System.out.println("SINGOLO MARCHIO: " + marcaServiceInstance.caricaSingoloElemento(2L));
//			marcaServiceInstance.rimuovi(xiaomi2);  OK

			/* ----------< TEST MODELLO >---------- */
			
			Modello redmiNote8T = new Modello("Xiaomi Redmi Note 8 T", new Date(), 180.0, 64);
			Modello redmiNote8T2 = modelloServiceInstance.caricaSingoloElemento(6L);
//			modelloServiceInstance.inserisciNuovo(redmiNote8T);
//			redmiNote8T.setPrezzo(140.0);
//			modelloServiceInstance.aggiorna(redmiNote8T);
			System.out.println("TUTTI I MODELLI: " + modelloServiceInstance.listAll());
			System.out.println("SINGOLO MODELLO: " + modelloServiceInstance.caricaSingoloElemento(6L));
//			modelloServiceInstance.aggiungiMarca(redmiNote8T2, xiaomi2);
			
			modelloServiceInstance.rimuovi(redmiNote8T2); 
			
			/* ----------< TEST APPLICAZIONE >---------- */
			
			Applicazione instagram = new Applicazione("Instagram", 52.5, 500000000.0, "Social");
			Applicazione instagram2 = applicazioneServiceInstance.caricaSingoloElemento(1L);
//			applicazioneServiceInstance.inserisciNuovo(instagram);
//			instagram.setPeso(55.2);
//			applicazioneServiceInstance.aggiorna(instagram);
			System.out.println("TUTTE LE APPLICAZIONI: " + applicazioneServiceInstance.listAll());
			System.out.println("SINGOLA APPLICAZIONE: " + applicazioneServiceInstance.caricaSingoloElemento(1L));
			
			// AGGIUNGO L'APPLICAZIONE AL MODELLO    OK 
//			modelloServiceInstance.aggiungiApplicazione(redmiNote8T2, instagram2);
//			applicazioneServiceInstance.aggiungiModello(instagram2, redmiNote8T2);
			
			applicazioneServiceInstance.rimuovi(instagram2);
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}
		
	}

}
