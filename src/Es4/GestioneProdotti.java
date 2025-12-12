/*Esercizio 4: Sistema di Gestione di Prodotti Alimentari
Descrizione:
Crea un sistema per gestire diversi tipi di prodotti alimentari in un supermercato. Ogni tipo di
prodotto ha un prezzo e una quantità disponibile, ma alcuni prodotti possono essere in sconto.
Requisiti:
1. Crea una classe base Prodotto con i seguenti attributi:
• nome, prezzo, quantitaDisponibile.
• Metodo:
• calcolaPrezzoTotale(int quantita): calcola il prezzo totale per
la quantità desiderata.
2. Crea le seguenti classi derivate:
• ProdottoAlimentare: Aggiungi un attributo dataScadenza e un metodo
calcolaPrezzoTotale() che applica uno sconto se il prodotto è vicino alla
scadenza.
• ProdottoBevanda: Aggiungi un attributo volume (in millilitri) e un metodo
calcolaPrezzoTotale() che applica uno sconto su bevande di grande volume.
3. Crea una classe Supermercato che:
• Contiene un elenco di prodotti.
• Ha un metodo aggiungiProdotto(Prodotto prodotto) per aggiungere
un prodotto al supermercato.
• Ha un metodo calcolaIncassoTotale() che somma il prezzo totale di tutti i
prodotti venduti.
4. Crea un programma Main che:
• Aggiunga prodotti al supermercato e calcoli l'incasso totale.*/


package Es4;

import Es3.GestioneRisorse;
import Es4.Models.*;
import Global.GetLocalDate;
import Global.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class GestioneProdotti {

    public static final Scanner input = new Scanner(System.in);
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final Supermercato s = new Supermercato();


    private static final String[] opzioni = {
            "Aggiungi prodotto alimentare",
            "Aggiungi bevanda",
            "Visualizza prodotti",
            "Vendi prodotto",
            "Mostra incasso totale",
            "Fine"
    };

    public static void aggiungiAlimentare() {
        String nome;
        double prezzo = -1;
        int quantitaDisponibile = 0;
        LocalDate scadenza;

        System.out.println("Nome: ");
        do {
            System.out.print("-> ");
            nome = input.next();
            if (checkInput(nome)) {
                System.out.println("Hai inserito un nome non valido. riprova.");
            }
        } while (checkInput(nome));
        System.out.println("Prezzo: ");
        do {
            System.out.print("-> ");
            try {
                prezzo = input.nextDouble();
            } catch (Exception e) {
                System.out.println("Errore nella lettura, riprova.");
                input.nextLine();
                continue;
            }
            if (prezzo <=0) {
                System.out.println("Hai inserito un prezzo non valido, riprova.");
            }
        } while (prezzo <=0);
        System.out.print("Quantità disponibile: ");
        do {
            System.out.print("-> ");
            try {
                quantitaDisponibile = input.nextInt();
            } catch (Exception e) {
                System.out.println("Errore nella lettura, riprova.");
            }
            if (quantitaDisponibile <=0) {
                System.out.println("Valore non valido. riprova.");
            }
        } while (quantitaDisponibile <=0);
        input.nextLine();

        System.out.print("Data scadenza (dd/MM/yyyy): ");
        scadenza = readDate();
        s.aggiungiProdotto(new ProdottoAlimentare(nome, prezzo, quantitaDisponibile, scadenza));
    }

    public static void gestioneProdotti() {

        boolean fine = false;
        while (!fine) {

            Menu.printMenu("Gestione Prodotti Supermercato", opzioni);

            int choice;
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                input.nextLine();
                System.out.println("Inserisci un intero valido.");
                continue;
            }
            input.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Aggiungi prodotto alimentare");
                    break;

                case 2:
                    System.out.print("Nome: ");
                    String nomeB = input.nextLine();
                    System.out.print("Prezzo: ");
                    double prezzoB = input.nextDouble();
                    System.out.print("Quantità disponibile: ");
                    int qB = input.nextInt();
                    System.out.print("Volume in ml: ");
                    int v = input.nextInt();
                    input.nextLine();

                    s.aggiungiProdotto(new ProdottoBevanda(nomeB, prezzoB, qB, v));
                    break;

                case 3:
                    s.visualizzaProdotti();
                    break;

                case 4:
                    s.visualizzaProdotti();
                    System.out.print("Indice prodotto: ");
                    int idx = input.nextInt();
                    System.out.print("Quantità da vendere: ");
                    int q = input.nextInt();
                    input.nextLine();

                    s.vendiProdotto(idx, q);
                    break;

                case 5:
                    System.out.println("Incasso totale: " + s.calcolaIncassoTotale());
                    break;

                case 6:
                    fine = true;
                    break;

                default:
                    System.out.println("Opzione non valida.");
            }
        }
    }

    public static boolean checkInput(String input) {
        return GestioneRisorse.checkInput(input); //Uso uno già esistente così non lo devo riscrivere
    }

    public static LocalDate readDate() {
        return GetLocalDate.getLocalDateFuture(input);
    }


}

