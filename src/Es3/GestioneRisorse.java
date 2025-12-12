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

import Es3.Models.*;
import Global.Menu;

import java.util.Scanner;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

public class GestioneRisorse {

    public static final Scanner input = new Scanner(System.in);
    public static final Azienda azienda = new Azienda();

    private static final String[] opzioni = {
            "Aggiungi Dipendente",
            "Aggiungi Manager",
            "Visualizza risorse",
            "Calcola totale stipendi",
            "Fine"
    };

    /*
    * MI SONO ACCORTO DI QUANTI DO WHILE FACEVO, e che era possibile condensarli in dei metodi molto più semplici.
    * quindi ho creato dei metodi generali per la lettura, che prendono come parametri:
    *
    * Il "prompt" ovvero l'azione da compiere (Inserisci nome/cognome/ecc)
    * Il messaggio di errore generale
    * E cosa controlla l'errore, che è il metodo "checkInput"
    *
    * Questo mi ha aiutato a imparare "Predictate" che non lo sapevo in java :)
    *
    * Infatti questo codice ora è molto più compatto. anche se FORSE era più leggibile tutti i do while.
    * perchè si capiva molto meglio logicamente. ma per questo esercizio uno questo metodo qui così lo
    * alleno un po.
    * */
    public static String readString(String prompt, String errorMessage, Predicate<String> validator) {
        String value;
        while (true) {
            System.out.print(prompt);
            value = input.nextLine();
            if (validator.test(value)) return value;
            System.out.println(errorMessage);
        }
    }

    public static double readDouble(String prompt, String errorMessage, DoublePredicate validator) {
        while (true) {
            System.out.print(prompt);
            try {
                double n = Double.parseDouble(input.nextLine());
                if (validator.test(n)) return n;
            } catch (Exception ignored) {}
            System.out.println(errorMessage);
        }
    }

    public static void aggiungiDipendente() {
        String nome = readString("Nome -> ", "Nome non valido.", s -> !checkInput(s));
        String cognome = readString("Cognome -> ", "Cognome non valido.", s -> !checkInput(s));
        double retribuzioneBase = readDouble("Retribuzione base -> ", "Valore non valido.", n -> n > 0);

        azienda.aggiungiRisorsa(new Dipendente(nome, cognome, retribuzioneBase));
    }

    public static void aggiungiManager() {
        String nome = readString("Nome -> ", "Nome non valido.", s -> !checkInput(s));
        String cognome = readString("Cognome -> ", "Cognome non valido.", s -> !checkInput(s));
        double retribuzioneBase = readDouble("Retribuzione base -> ", "Valore non valido.", n -> n > 0);
        double bonus = readDouble("Bonus -> ", "Valore non valido.", n -> n > 0);

        azienda.aggiungiRisorsa(new Manager(nome, cognome, retribuzioneBase, bonus));
    }

    public static void gestioneRisorseAzienda() {
        boolean fine = false;

        while (!fine) {
            Menu.printMenu("Gestione Risorse Azienda", opzioni);

            int choice;
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (Exception e) {
                System.out.println("Inserisci un intero valido.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.println("Insrisci Dipendente");
                    aggiungiDipendente();
                    break;

                case 2:
                    System.out.println("Inserisci Manager");
                    aggiungiManager();
                    break;

                case 3:
                    System.out.println("Visualizza Risorse");
                    azienda.visualizzaRisorse();
                    break;

                case 4:
                    System.out.println("Totale stipendi: " + azienda.calcolaStipendioTotale());
                    break;

                case 5:
                    System.out.println("Fine Programma");
                    fine = true;
                    break;

                default:
                    System.out.println("Opzione non valida.");
            }
        }
    }

    public static boolean checkInput(String input) {
        if (input.length() < 3) return true;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) return true;
        }
        return false;
    }

}


