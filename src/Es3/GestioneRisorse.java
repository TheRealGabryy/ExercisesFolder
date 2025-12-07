/*Esercizio 3: Simulatore di Gestione delle Risorse di un'Azienda
Descrizione:
Crea un sistema per la gestione delle risorse umane di un'azienda che include dipendenti e
manager. Ogni tipo di risorsa ha una retribuzione, ma i manager guadagnano di più rispetto ai
dipendenti e possono avere bonus.
Requisiti:
1. Crea una classe base Risorsa con i seguenti attributi:
• nome, cognome, retribuzioneBase.
• Metodo:
• calcolaRetribuzione(): restituisce la retribuzione base.
2. Crea una classe derivata Manager che estende Risorsa:
• Aggiungi un attributo bonus e un metodo calcolaRetribuzione() che
somma il bonus alla retribuzione base.
3. Crea una classe derivata Dipendente che estende Risorsa:
• Aggiungi un metodo calcolaRetribuzione() che restituisce solo la
retribuzione base (senza bonus).
4. Crea una classe Azienda che:
• Contiene un elenco di risorse (dipendenti e manager) usando una lista.
• Ha un metodo calcolaStipendioTotale() che calcola la somma delle
retribuzioni di tutte le risorse.
5. Crea un programma Main che:
• Crea almeno un oggetto Manager e un oggetto Dipendente.
• Mostra la retribuzione di ogni risorsa e calcola lo stipendio totale dell'azienda.*/


package Es3;

import Global.Menu;

import java.util.Scanner;

public class GestioneRisorse {
    public static final Scanner input = new Scanner(System.in);
    public static String[] opzionigestioneEventi = {
            "Crea Concerto",
            "Crea Conferenza",
            "Crea Morstra Arte",
            "Elimina Evento",
            "Fine"
    };

    public static void gestioneRisorseAzienda() { //entry point gestione eventi
        System.out.println("Esercizio gestione <risorse dell'azienda");
        boolean fine = false;
        int choice = 0;

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
