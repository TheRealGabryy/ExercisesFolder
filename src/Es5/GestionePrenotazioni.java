/*Esercizio 5: Simulatore di Sistema di Prenotazione
Descrizione:
Crea un sistema di prenotazione per un hotel che gestisce stanze singole e stanze doppie. Le stanze
hanno un prezzo base, ma le stanze doppie hanno un prezzo maggiore.
Requisiti:
1. Crea una classe base Stanza con i seguenti attributi:
• numeroStanza, prezzoBase, disponibile.
• Metodi:
• prenota(): segna la stanza come prenotata.
• libera(): segna la stanza come libera.
• calcolaPrezzo(): restituisce il prezzo base della stanza.
2. Crea le seguenti classi derivate:
• StanzaSingola: Nessuna aggiunta specifica, ma implementa calcolaPrezzo()
per restituire il prezzo base.
• StanzaDoppia: Aggiungi un attributo supplementoPrezzo e implementa
calcolaPrezzo() per sommare il supplemento al prezzo base.
3. Crea una classe Hotel che:
• Contiene un elenco di stanze.
• Ha metodi per prenotare e liberare stanze.
4. Crea un programma Main che:
• Crea stanze singole e doppie, gestisce le prenotazioni e calcola il prezzo totale di una
prenotazione.*/

package Es5;

import Global.Menu;

import java.util.Scanner;

public class GestionePrenotazioni {
    public static final Scanner input = new Scanner(System.in);
    public static String[] opzionigestioneEventi = {
            "Crea Concerto",
            "Crea Conferenza",
            "Crea Morstra Arte",
            "Elimina Evento",
            "Fine"
    };

    public static void gestionePrenotazioni() { //entry point gestione eventi
        System.out.println("Esercizio gestione prenotazioni");
        boolean fine = false;
        int choice = 0;

        do {
            Menu.printMenu("Gestione Eventi Menu", opzionigestioneEventi);
            switch (choice) {
                case 1:
                    System.out.println("Hai scelto ");
                    break;
                case 2:
                    System.out.println("Hai scelto ");
                    break;
                case 3:
                    System.out.println("Hai scelto ");
                    break;
                case 4:
                    System.out.println("Hai scelto ");
                    break;
                case 5:
                    System.out.println("Hai scelto ");
                    break;
                default: System.out.println("Non hai inserto un'opzione valida.");


            }
        } while (!fine);

    }
}
