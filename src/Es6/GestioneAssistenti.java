/*
* Esercizio 6: Gestione di un Sistema di Assistenti Virtuali con AI
Descrizione:
Crea un sistema che gestisce vari tipi di assistenti virtuali. Ogni tipo di assistente ha un
comportamento diverso ma può essere trattato in modo polimorfico, sfruttando l'ereditarietà.
Requisiti:
1. Classe base AssistenteAI:
Crea una classe base AssistenteAI con i seguenti attributi e metodi:
• Attributi:
• nome: il nome dell'assistente (ad esempio, Alexa, Siri, Google Assistant,
ecc.).
• versione: la versione del software dell'assistente.
• Metodi:
• interagisci(String input): metodo che riceve una stringa di input
e stampa una risposta generica. Questo metodo verrà sovrascritto nelle classi
derivate.
• aggiornaVersione(String nuovaVersione): metodo che
aggiorna la versione dell'assistente.
2. Classi derivate:
Crea le seguenti classi derivate da AssistenteAI:
• AssistenteVocale:
• Aggiungi un attributo lingua per gestire la lingua dell'assistente (italiano,
inglese, ecc.).
• Implementa il metodo interagisci(String input) per restituire una
risposta vocale simulata (es. "Sto cercando informazioni su..." o "Posso
aiutarti con...").
• Aggiungi un metodo parla(String messaggio) che simula una
risposta vocale.
• Chatbot:
• Aggiungi un attributo tipoConversazione per gestire se il chatbot è per
uso personale o aziendale.
• Implementa il metodo interagisci(String input) per rispondere
con un messaggio testuale, simulando una conversazione con un chatbot.
• Aggiungi un metodo analizzaDomanda(String domanda) che
simula l'analisi del testo per determinare la risposta più adeguata.
• AssistenteVisivo:
• Aggiungi un attributo risoluzione per definire la qualità visiva
dell'assistente (ad esempio, 720p, 1080p, 4K).
• Implementa il metodo interagisci(String input) per rispondere
con un messaggio che simula un'azione visiva, come mostrare un'immagine o
un grafico.
• Aggiungi un metodo mostraImmagine(String immagine) che
simula il comportamento visivo dell'assistente.
3. Gestione della lista degli assistenti:
Crea una classe GestioneAssistenti che:
• Contiene una lista di oggetti di tipo AssistenteAI.
• Ha un metodo aggiungiAssistente(AssistenteAI assistente) per
aggiungere un assistente alla lista.
• Ha un metodo interagisciConTutti(String input) che fa interagire
tutti gli assistenti nella lista con un determinato input.
4. Programma Main:
• Crea almeno un oggetto di tipo AssistenteVocale, Chatbot, e
AssistenteVisivo.
• Utilizza il polimorfismo per chiamare il metodo interagisci(String
input) su ogni assistente, indipendentemente dal loro tipo.
• Mostra le risposte degli assistenti.*/

package Es6;

import Global.Menu;

import java.util.Scanner;

public class GestioneAssistenti {
    public static final Scanner input = new Scanner(System.in);
    public static String[] opzionigestioneEventi = {
            "Crea Concerto",
            "Crea Conferenza",
            "Crea Morstra Arte",
            "Elimina Evento",
            "Fine"
    };

    public static void gestioneAssistenti() { //entry point gestione eventi
        System.out.println("Esercizio gestione Assistenti");
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
