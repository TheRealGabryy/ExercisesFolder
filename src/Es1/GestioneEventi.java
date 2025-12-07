package Es1;

/*
*
* Esercizio 1: Sistema di Gestione di Eventi
Descrizione:
Crea un sistema per la gestione di eventi come concerti, conferenze, e mostre d'arte. Ogni tipo di
evento ha alcune caratteristiche comuni, ma si differenziano per modalità di accesso, durata e costo.
Requisiti:
1. Crea una classe base Evento con i seguenti attributi:
• nomeEvento, data, ora, prezzoBiglietto, durata.
• Metodi:
• dettagli(): stampa le informazioni generali dell'evento.
• calcolaPrezzoTotale(int numeroPartecipanti): calcola il
costo totale in base al numero di partecipanti.
2. Crea le seguenti classi derivate:
• Concerto: Aggiungi un attributo artista e un metodo
calcolaPrezzoTotale() che applica uno sconto per i concerti serali.
• Conferenza: Aggiungi un attributo relatore e un metodo
calcolaPrezzoTotale() che applica uno sconto per gruppi di studenti.
• MostraArte: Aggiungi un attributo artistaInMostra e un metodo
calcolaPrezzoTotale() che applica uno sconto per famiglie (più di 3
partecipanti).
3. Crea un programma Main che:
• Crea eventi di tipo Concerto, Conferenza, e Mostra d'Arte.
• Mostra i dettagli e il prezzo totale di ogni evento, sfruttando il polimorfismo per
chiamare il metodo calcolaPrezzoTotale() su oggetti di tipo diverso.
*/

import Global.Menu;

import java.util.Scanner;

public class GestioneEventi {
    public static final Scanner input = new Scanner(System.in);
    public static String[] opzionigestioneEventi = {
            "Crea Concerto",
            "Crea Conferenza",
            "Crea Morstra Arte",
            "Elimina Evento",
            "Fine"
    };

    public static void creaEveneto() { // metodo generale per la creazione degli attributi generali dell'evento
        System.out.println("Inserisci il nome dell'evento: ");
        System.out.println("Inserisci la data dell'evento (GG:MM:YYYY)");
        System.out.println("Insersci l'ora dell'evento (HH:mm)");
        System.out.println("Inserisci il prezzo del biglietto");
    }

    public static void creaConcerto() {
        creaEveneto();
        System.out.println("Inserisci il nome dell'artista");

        // TODO: controllare se l'ora è di sera, se lo è, mettere serale a true;

    }

    public static void creaConferenza() {
        creaEveneto();
        System.out.println("Inserisci il nome del referente");
    }

    public static void creaMostra() {
        creaEveneto();
        System.out.println("inserisci il nome del pittore");

    }

    public static void eliminaEvento() {
        creaEveneto();
    }

    public static void gestioneEventi() { //entry point gestione eventi
        System.out.println("Esercizio gestione eventi");
        boolean fine = false;
        int choice;

        do {
            Menu.printMenu("Gestione Eventi Menu", opzionigestioneEventi);
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Non hai inserito un intero, santa giovanna martire");
                input.nextLine();
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Hai scelto Concerto");
                    creaConcerto();
                    break;
                case 2:
                    System.out.println("Hai scelto Conferenza");
                    creaConferenza();
                    break;
                case 3:
                    System.out.println("Hai scelto Mostra Arte");
                    creaMostra();
                    break;
                case 4:
                    System.out.println("Hai scelto Elimina Evento");
                    eliminaEvento();
                    break;
                case 5:
                    System.out.println("Fine programma");
                    fine = true;
                    break;
                default: System.out.println("Non hai inserto un'opzione valida.");


            }
        } while (!fine);

    }
}
