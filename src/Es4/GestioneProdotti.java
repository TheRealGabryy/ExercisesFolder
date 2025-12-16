/*Anche questo esercizio è stato creato con un metodo diverso da quello solito che ho. così risparmio centinaia di righe di codice.*/

package Es4;

import Es3.GestioneRisorse;
import Es4.Models.*;
import Global.GetLocalDate;
import Global.Menu;

import java.time.LocalDate;
import java.util.Scanner;

public class GestioneProdotti {

    private static final Scanner input = new Scanner(System.in);
    private static final Supermercato supermercato = new Supermercato();

    private static final String[] OPZIONI = {
            "Aggiungi prodotto alimentare",
            "Aggiungi bevanda",
            "Visualizza prodotti",
            "Vendi prodotto",
            "Mostra incasso totale",
            "Fine"
    };



    private static void aggiungiAlimentare() {
        String nome = readString("Nome");
        double prezzo = readPositiveDouble();
        int quantita = readPositiveInt("Quantità disponibile");
        LocalDate scadenza = GetLocalDate.getLocalDateFuture(input);

        supermercato.aggiungiProdotto(
                new ProdottoAlimentare(nome, prezzo, quantita, scadenza)
        );
    }

    private static void aggiungiBevanda() {
        String nome = readString("Nome bevanda");
        double prezzo = readPositiveDouble();
        int quantita = readPositiveInt("Quantità disponibile");
        int volume = readPositiveInt("Volume (ml)");

        supermercato.aggiungiProdotto(
                new ProdottoBevanda(nome, prezzo, quantita, volume)
        );
    }

    private static void vendiProdotto() {
        supermercato.visualizzaProdotti();
        int indice = readPositiveInt("Indice prodotto");
        int quantita = readPositiveInt("Quantità da vendere");
        supermercato.vendiProdotto(indice, quantita);
    }

    private static String readString(String msg) {
        String valore;
        do {
            System.out.print(msg + " -> ");
            valore = input.nextLine();
            if (GestioneRisorse.checkInput(valore)) {
                System.out.println("Input non valido.");
            }
        } while (GestioneRisorse.checkInput(valore));
        return valore;
    }

    private static int readPositiveInt(String msg) {
        int valore = -1;
        do {
            System.out.print(msg + " -> ");
            try {
                valore = Integer.parseInt(input.nextLine());
                if (valore <= 0) {
                    System.out.println("Inserisci un valore positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un intero valido.");
            }
        } while (valore <= 0);
        return valore;
    }

    private static double readPositiveDouble() {
        double valore = -1;
        do {
            System.out.print("Prezzo" + " -> ");
            try {
                valore = Double.parseDouble(input.nextLine());
                if (valore <= 0) {
                    System.out.println("Inserisci un valore positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Inserisci un numero valido.");
            }
        } while (valore <= 0);
        return valore;
    }

    public static void gestioneProdotti() {
        boolean fine = false;

        while (!fine) {
            Menu.printMenu("Gestione Prodotti Supermercato", OPZIONI);
            int scelta = readPositiveInt("Scelta");

            switch (scelta) {
                case 1 -> aggiungiAlimentare();
                case 2 -> aggiungiBevanda();
                case 3 -> supermercato.visualizzaProdotti();
                case 4 -> vendiProdotto();
                case 5 -> System.out.println("Incasso totale: " + supermercato.calcolaIncassoTotale());
                case 6 -> fine = true;
                default -> System.out.println("Opzione non valida.");
            }
        }
    }
}
