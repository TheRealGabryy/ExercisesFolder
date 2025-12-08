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

import Es1.Models.Concerto;
import Es1.Models.Conferenza;
import Es1.Models.Eventi;
import Es1.Models.MostraArte;
import Global.Menu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class GestioneEventi {
    public static final Scanner input = new Scanner(System.in);
    public static String nomeEvento;
    public static LocalDate dataEvento;
    public static LocalTime oraEvento;
    public static LocalTime durata;
    public static double prezzo;
    public static ArrayList<Eventi> eventi = new ArrayList<>();


    public static final int minPartecipanti = 1; public static final int maxPartecipanti = 49;
    public static String[] opzionigestioneEventi = {
            "Crea Concerto",
            "Crea Conferenza",
            "Crea Morstra Arte",
            "Elimina Evento",
            "Fine"
    };
    public static void creaEveneto() {

        // Nome
        System.out.println("Inserisci il nome dell'evento: ");
        do {
            System.out.print("-> ");
            nomeEvento = input.next();
            if (checkNome(nomeEvento)) {
                System.out.println("Nome non valido. Solo lettere.");
            }
        } while (checkNome(nomeEvento));

        // Data
        dataEvento = leggiData();

        // Ora
        oraEvento = leggiOra();

        // Input del prezzo: ho usato un ciclo diverso perchè sto iniziando ad usare questo tipo di scrittura, più stabile
        while (true) {
            System.out.print("Inserisci il prezzo del biglietto: ");
            try {
                prezzo = input.nextDouble();
                if (prezzo < 0) {
                    System.out.println("Il prezzo non puo essere negativo.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Inserisci un numero valido.");
                input.nextLine(); //clear del buffer di input
            }
        }

        //Inserimento della durata, in ore e minuti.
        durata = leggiOra();
    }

    public static String nomeArtista;

    public static void creaConcerto() {
        creaEveneto(); //creo l'evento generale
        System.out.println("Inserisci il nome dell'artista");
        do {
            System.out.print("-> ");
            nomeArtista = input.next(); //inserisco la variabile che manca: l'artista
            if (checkNome(nomeArtista)) {
                System.out.println("Nome non valido. Solo lettere.");
            }
        } while (checkNome(nomeArtista));
        Concerto c = new Concerto(nomeEvento, dataEvento, oraEvento, prezzo, durata, nomeArtista);
        eventi.add(c);
        boolean serale = oraEvento.isAfter(LocalTime.of(19,59));

        //NUMERO PARTECIPANTI ALL'EVENTO
        int partecipanti = inserisciPartecipanti();
        if (serale) {
            System.out.println("Hai diritto ad uno sconto per evento serale");
            c.calcolaPrezzoTotale(partecipanti, true);
        } else {
            System.out.println("L'evento non è serale, prezzo normale.");
            c.calcolaPrezzoTotale(partecipanti, false);
        }

        System.out.println("Prezzo totale dell'evento: " + c.getPrezzoTotale());

    }

    public static void creaConferenza() {
        creaEveneto();
        String relatore;
        System.out.println("Inserisci il nome del referente");
        do {
            System.out.print("-> ");
            relatore = input.next();
            if (checkNome(relatore)) {
                System.out.println("Nome non valido. Solo lettere.");
            }
        } while (checkNome(relatore));

        Conferenza conf = new Conferenza(nomeEvento, dataEvento, oraEvento, prezzo, durata, relatore);
        eventi.add(conf);
        int partecipanti = inserisciPartecipanti();
        if (partecipanti > 15) {
            System.out.println("Hai diritto ad uno sconto per aver portato un grippo studenti");
            conf.calcolaPrezzoTotale(partecipanti, true); //true perchè con 15 partecipanti facciamo che è un gruppo studenti
        } else {
            System.out.println("Nessuno sconto per studenti");
            conf.calcolaPrezzoTotale(partecipanti, false);
        }

        System.out.println("Prezzo totale dell'evento: " + conf.getPrezzoTotale());
    }

    public static void creaMostra() {
        creaEveneto();
        String pittore;
        System.out.println("inserisci il nome del pittore");
        do {
            System.out.print("-> ");
            pittore = input.next();
            if (checkNome(pittore)) {
                System.out.println("Nome non valido. Solo lettere.");
            }
        } while (checkNome(pittore));

        MostraArte m = new MostraArte(nomeEvento, dataEvento, oraEvento, prezzo, durata, pittore);
        eventi.add(m);
        System.out.println("Inserisci quanti partecipanti ci sono all'evento");
        int partecipanti = inserisciPartecipanti();
        m.calcolaPrezzoTotale(partecipanti);
        System.out.println("Prezzo totale dell'evento: " + m.getPrezzoTotale());
    }

    public static void eliminaEvento() {

        if (eventi.isEmpty()) {
            System.out.println("Nessun evento da eliminare.");
            return;
        }

        System.out.println("Seleziona l'evento da eliminare:");
        for (int i = 0; i < eventi.size(); i++) {
            System.out.println((i + 1) + ") " + eventi.get(i).getNomeEvento());
        }

        int scelta;
        do {
            System.out.print("-> ");
            scelta = input.nextInt();
        } while (scelta < 1 || scelta > eventi.size());

        eventi.remove(scelta - 1);

        System.out.println("Evento eliminato.");
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

    public static boolean checkNome(String nome) {
        for (int i = 0; i < nome.length(); i++) {
            if (!Character.isLetter(nome.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static LocalDate leggiData() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            System.out.print("Inserisci la data dell'evento (gg/mm/yyyy): ");

            String inputData = input.next();

            try {
                return LocalDate.parse(inputData, formatter);
            } catch (Exception e) {
                System.out.println("Data non valida. Riprova.");
            }
        }
    }

    public static LocalTime leggiOra() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        while (true) {
            System.out.print("Inserisci l'ora dell'evento (HH:mm): ");

            String inputOra = input.next();

            try {
                return LocalTime.parse(inputOra, formatter);
            } catch (Exception e) {
                System.out.println("Ora non valida. Riprova.");
            }
        }
    }

    public static  int inserisciPartecipanti() {
        System.out.println("Inserisci i partecipandi al concerto (1 - 49)");
        int partecipanti;
        do {
            System.out.print("-> ");
            partecipanti = input.nextInt();
            if (partecipanti < minPartecipanti || partecipanti > maxPartecipanti) {
                System.out.println("Inserisci un numero tra " + minPartecipanti + " e " + maxPartecipanti);
            }
        } while (partecipanti < minPartecipanti || partecipanti > maxPartecipanti);
        return partecipanti;
    }


}
