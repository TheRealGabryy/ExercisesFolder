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

public class GestioneRisorse {

    public static final Scanner input = new Scanner(System.in);

    private static final String[] opzioni = {
            "Aggiungi Dipendente",
            "Aggiungi Manager",
            "Visualizza risorse",
            "Calcola totale stipendi",
            "Fine"
    };

    public static void gestioneRisorseAzienda() {

        Azienda azienda = new Azienda();
        boolean fine = false;

        while (!fine) {
            Menu.printMenu("Gestione Risorse Azienda", opzioni);

            int choice;
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Inserisci un intero.");
                continue;
            }
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Nome: ");
                    String nd = input.nextLine();
                    System.out.print("Cognome: ");
                    String cd = input.nextLine();
                    System.out.print("Retribuzione base: ");
                    double rb = input.nextDouble();
                    input.nextLine();

                    azienda.aggiungiRisorsa(new Dipendente(nd, cd, rb));
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nm = input.nextLine();
                    System.out.print("Cognome: ");
                    String cm = input.nextLine();
                    System.out.print("Retribuzione base: ");
                    double rbm = input.nextDouble();
                    System.out.print("Bonus: ");
                    double bonus = input.nextDouble();
                    input.nextLine();

                    azienda.aggiungiRisorsa(new Manager(nm, cm, rbm, bonus));
                    break;

                case 3:
                    azienda.visualizzaRisorse();
                    break;

                case 4:
                    System.out.println("Totale stipendi: " + azienda.calcolaStipendioTotale());
                    break;

                case 5:
                    fine = true;
                    break;

                default:
                    System.out.println("Opzione non valida.");
            }
        }
    }
}

